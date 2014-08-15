/*******************************************************************************
 * Copyright (c) 2010 University of Illinois at Urbana-Champaign and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    UIUC - Initial API and implementation
 *    Rocky Dunlap - University of Colorado
 *******************************************************************************/
package org.eclipse.photran.internal.core.lexer.sourceform;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.core.resources.IFile;
import org.eclipse.photran.internal.core.lexer.CPreprocessingLexer;
import org.eclipse.photran.internal.core.lexer.CPreprocessingReader;
import org.eclipse.photran.internal.core.lexer.FixedFormLexerPhase1;
import org.eclipse.photran.internal.core.lexer.FixedFormLexerPhase2;
import org.eclipse.photran.internal.core.lexer.FixedFormLexerPrepass;
import org.eclipse.photran.internal.core.lexer.ILexer;
import org.eclipse.photran.internal.core.lexer.LineAppendingReader;
import org.eclipse.photran.internal.core.sourceform.ISourceForm;

/**
 * An {@link ISourceForm} for fixed form Fortran source code that may
 * contain C preprocessor directives.
 * 
 * @author Jeff Overbey
 */
public class CPreprocessedFixedSourceForm implements ISourceForm
{
    private CPreprocessingReader cppReader;
    
    public ILexer createLexer(
        Reader in, IFile file, String filename,
        final boolean accumulateWhitetext) throws IOException
    {
        
        //return new CPreprocessingFixedFormLexerPhase2(in, file, filename, accumulateWhitetext);
        
        //Rocky changing to do preprocessing first        
        cppReader = new CPreprocessingReader(file, filename, new LineAppendingReader(in));
        return new CPreprocessingFixedFormLexerPhase2(cppReader, file, filename, accumulateWhitetext);
    }

    public CPreprocessedFixedSourceForm configuredWith(Object data)
    {
        return this;
    }
    
    public boolean isFixedForm()     { return true; }
    public boolean isCPreprocessed() { return true; }

    private final class CPreprocessingFixedFormLexerPhase2 extends FixedFormLexerPhase2
    {
        private CPreprocessingFixedFormLexerPhase2(Reader in, IFile file, String filename,
            boolean accumulateWhitetext)
        {
            super(in, file, filename);
        }

        @Override
        protected ILexer createPhase1Lexer(
            IFile file, String filename, final FixedFormLexerPrepass prepass, final Reader prepassReader)
        {
            
            //try adding lexer           
            CPreprocessingLexer lexer = new CPreprocessingLexer(cppReader, file, filename, true) {
                @Override protected ILexer createDelegateLexer(
                    CPreprocessingReader cpp, IFile file, String filename,
                    boolean accumulateWhitetext)
                {
                    //return new FixedFormLexerPhase1(cpp, prepass, file, filename);
                    return new FixedFormLexerPhase1(prepassReader, prepass, file, filename);
                }
            };
            
            lexer.setShouldExpandProducers(false);
            return lexer;

        }
    }
}
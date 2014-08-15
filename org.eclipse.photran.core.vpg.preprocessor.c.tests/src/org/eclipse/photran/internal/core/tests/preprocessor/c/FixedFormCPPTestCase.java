/*******************************************************************************
 * Copyright (c) 2014 University of Colorado and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Rocky Dunlap (University of Colorado) - Initial API and implementation
 *******************************************************************************/
package org.eclipse.photran.internal.core.tests.preprocessor.c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.eclipse.cdt.core.dom.parser.c.GCCScannerExtensionConfiguration;
import org.eclipse.cdt.core.parser.NullLogService;
import org.eclipse.cdt.core.parser.ParserLanguage;
import org.eclipse.cdt.core.parser.ScannerInfo;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.photran.internal.core.SyntaxException;
import org.eclipse.photran.internal.core.lexer.CPreprocessingLexer;
import org.eclipse.photran.internal.core.lexer.CPreprocessingReader;
import org.eclipse.photran.internal.core.lexer.FixedFormLexerPhase1;
import org.eclipse.photran.internal.core.lexer.FixedFormLexerPhase2;
import org.eclipse.photran.internal.core.lexer.FixedFormLexerPrepass;
import org.eclipse.photran.internal.core.lexer.FixedFormReplacement;
import org.eclipse.photran.internal.core.lexer.ILexer;
import org.eclipse.photran.internal.core.lexer.IPreprocessorReplacement;
import org.eclipse.photran.internal.core.lexer.IToken;
import org.eclipse.photran.internal.core.lexer.LexerException;
import org.eclipse.photran.internal.core.lexer.LexerPhase3;
import org.eclipse.photran.internal.core.lexer.LineAppendingReader;
import org.eclipse.photran.internal.core.lexer.SingleCharReader;
import org.eclipse.photran.internal.core.lexer.Terminal;
import org.eclipse.photran.internal.core.lexer.Token;
import org.eclipse.photran.internal.core.lexer.sourceform.CPreprocessedFixedSourceForm;
import org.eclipse.photran.internal.core.parser.ASTExecutableProgramNode;
import org.eclipse.photran.internal.core.parser.Parser;
import org.eclipse.photran.internal.core.preprocessor.c.CPreprocessor;
import org.eclipse.photran.internal.core.preprocessor.c.EndOfFileException;
import org.eclipse.photran.internal.core.preprocessor.c.FileCodeReaderFactory;
import org.eclipse.photran.internal.core.preprocessor.c.ReaderBasedCodeReader;
import org.eclipse.photran.internal.tests.PhotranTestCase;

/**
 * 
 * @author Rocky Dunlap
 *
 */
public class FixedFormCPPTestCase extends PhotranTestCase
{

    public void testFixedFormCPP1() throws IOException, LexerException, SyntaxException, CoreException {
        String filename = "cpp-test-code/fixed_form_test_files/FIXED_TEST.F";
        ASTExecutableProgramNode ast = parse(new File(filename), new CPreprocessedFixedSourceForm());
    }
    
    public void testFixedFormCPP2() throws IOException, LexerException, SyntaxException, CoreException {      
        String filename = "cpp-test-code/fixed_form_test_files/FIXED_TEST_MACRO.F";
        ASTExecutableProgramNode ast = parse(new File(filename), new CPreprocessedFixedSourceForm());
    }
    
    public void testFixedFormCPP3() throws IOException, LexerException, SyntaxException, CoreException {      
        String filename = "cpp-test-code/fixed_form_test_files/FIXED_TEST_NOCPP.F";
        ASTExecutableProgramNode ast = parse(new File(filename), new CPreprocessedFixedSourceForm());
    }
    
    
    
        
    
    /*
     * The rest of the methods in this class are not official test cases, although they are
     * helpful in constructing parts of the lexing stack to examine behavior in isolation.
     * 
     */
    
    
    /*
    private void testCPreprocessorNoPrepass() throws IOException {
        
        String filename = "cpp-test-code/fixed_form_test_files/FIXED_TEST.F";
        
        final Reader reader = new BufferedReader(new FileReader(filename));
        final Reader input = new LineAppendingReader(reader);
                
        CPreprocessor cpp = new CPreprocessor(new ReaderBasedCodeReader(filename, reader),
            new ScannerInfo(), ParserLanguage.C, new NullLogService(), 
            new GCCScannerExtensionConfiguration(), FileCodeReaderFactory.getInstance());

        try 
        {
            org.eclipse.photran.internal.core.preprocessor.c.IToken t = cpp.nextToken();
            while(true) {
                if (t.getParent() != null) {
                    t.getParent();
                }
                t = cpp.nextToken();
            }
        }
        catch (EndOfFileException eof)
        {
           //reached end of file           
        }
    }

    private void testCPreprocessorFixedFormPrepass() throws IOException {
    
        String filename = "cpp-test-code/fixed_form_test_files/ICEDYN_DRV.F";
        
        final Reader reader = new BufferedReader(new FileReader(filename));
        final Reader input = new LineAppendingReader(reader);
        final FixedFormLexerPrepass prepass = new FixedFormLexerPrepass(input);
        SingleCharReader prepassReader = new SingleCharReader()
        {
            @Override
            public int read() throws IOException
            {
                try
                {
                    return prepass.read();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return -1;
                }
            }
            
            @Override
            public void close() throws IOException
            {
                input.close();
            }
        };
        
        CPreprocessor cpp = new CPreprocessor(new ReaderBasedCodeReader(filename, prepassReader),
            new ScannerInfo(), ParserLanguage.C, new NullLogService(), 
            new GCCScannerExtensionConfiguration(), FileCodeReaderFactory.getInstance());

        try 
        {
            org.eclipse.photran.internal.core.preprocessor.c.IToken t = cpp.nextToken();
            while(true) {
                if (t.getParent() != null) {
                    t.getParent();
                }
                t = cpp.nextToken();
            }
        }
        catch (EndOfFileException eof)
        {
           //reached end of file           
        }
    }
    
    
    
    private void testFixedFormLexerPrepass() throws IOException, LexerException {
        
        String filename = "cpp-test-code/fixed_form_test_files/FIXED_TEST.F";
              
        final Reader reader = new BufferedReader(new FileReader(filename));
        final Reader input = new LineAppendingReader(reader);
        final FixedFormLexerPrepass prepass = new FixedFormLexerPrepass(input);
        SingleCharReader prepassReader = new SingleCharReader()
        {
            @Override
            public int read() throws IOException
            {
                try
                {
                    return prepass.read();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return -1;
                }
            }
            
            @Override
            public void close() throws IOException
            {
                input.close();
            }
        };
        
        String output = prepassReader.getString();
        String escaped = removeUnicodeAndEscapeChars(output);
        System.out.println("|" + escaped + "|");
        
        prepassReader.close();
      }
    
   
    private void testCPPFixedFormPhase1Lexer() throws IOException, LexerException {
        
        String filename = "cpp-test-code/fixed_form_test_files/FIXED_TEST.F";
              
        final Reader reader = new BufferedReader(new FileReader(filename));
        final Reader input = new LineAppendingReader(reader);
        final FixedFormLexerPrepass prepass = new FixedFormLexerPrepass(input);
        SingleCharReader prepassReader = new SingleCharReader()
        {
            @Override
            public int read() throws IOException
            {
                try
                {
                    return prepass.read();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return -1;
                }
            }
            
            @Override
            public void close() throws IOException
            {
                input.close();
            }
        };
        
        CPreprocessingReader cppr = new CPreprocessingReader(null, filename, new LineAppendingReader(prepassReader));
        FixedFormLexerPhase1 lexer = new FixedFormLexerPhase1(cppr, prepass, null, filename);
        
        IToken token = lexer.yylex();
        while (token.getTerminal() != Terminal.END_OF_INPUT) 
        {
            token = lexer.yylex();
        }
        
        
    }
    
    private void testAlternativeCPPFixedFormPhase1Lexer() throws IOException, LexerException {
        
        String filename = "cpp-test-code/fixed_form_test_files/FIXED_TEST.F";
              
        final Reader reader = new BufferedReader(new FileReader(filename));
        final Reader input = new LineAppendingReader(reader);
        CPreprocessingReader cppr = new CPreprocessingReader(null, filename, input);
        
//        final FixedFormLexerPrepass prepass = new FixedFormLexerPrepass(cppr);
//        SingleCharReader prepassReader = new SingleCharReader()
//        {
//            @Override
//            public int read() throws IOException
//            {
//                try
//                {
//                    return prepass.read();
//                }
//                catch (Exception e)
//                {
//                    e.printStackTrace();
//                    return -1;
//                }
//            }
//            
//            @Override
//            public void close() throws IOException
//            {
//                input.close();
//            }
//        };
        
        String originalSource = getSourceCodeFromFile(cppr);
        
        
        
        final Reader reader2 = new BufferedReader(new FileReader(filename));
        final Reader input2 = new LineAppendingReader(reader2);
        CPreprocessingReader cppr2 = new CPreprocessingReader(null, filename, input2);
        final FixedFormLexerPrepass prepass2 = new FixedFormLexerPrepass(cppr2);
        SingleCharReader prepassReader2 = new SingleCharReader()
        {
            @Override
            public int read() throws IOException
            {
                try
                {
                    return prepass2.read();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return -1;
                }
            }
            
            @Override
            public void close() throws IOException
            {
                input.close();
            }
        };
        
        
        
        FixedFormLexerPhase1 lexer = new FixedFormLexerPhase1(prepassReader2, prepass2, null, filename);
        
                
        StringBuffer sb = new StringBuffer(4096);
        
        IToken token = lexer.yylex();
        while (token.getTerminal() != Terminal.END_OF_INPUT) 
        {
            //set offsets
            token.setStreamOffset(lexer.getLastTokenStreamOffset());
            token.setLine(lexer.getLastTokenLine());
            token.setFileOffset(lexer.getLastTokenFileOffset());
            token.setCol(lexer.getLastTokenCol());
            token.setLength(lexer.getLastTokenLength());
                  
            //compare
            try {
            String orig = originalSource.substring(token.getStreamOffset(), token.getStreamOffset()+token.getLength());
            System.out.println("Compare: " + token.getText() + " == " + orig);
            }
            catch (StringIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            
            //reproduce original text
            sb.append(token.getWhiteBefore());
            IPreprocessorReplacement pr = token.getPreprocessorDirective();
            if (pr != null) {
                sb.append(((FixedFormReplacement) pr).toString());
            }
            else {
                sb.append(token.getText());
            }
            sb.append(token.getWhiteAfter());
        
            
            
            token = lexer.yylex();
        }  
        
        System.out.println("Original source**********\n" + originalSource + "\n********\n\n");
        System.out.println("Reproduced source**********\n" + sb.toString() + "\n********\n\n");
        
        assertEquals(sb.toString(), originalSource);
        
        
    }

    
    private void testAlternativeCPPFixedFormPhase2Lexer() throws IOException, LexerException, SyntaxException {
        
        String filename = "cpp-test-code/fixed_form_test_files/FIXED_TEST.F";
              
        final Reader reader = new BufferedReader(new FileReader(filename));
        final Reader input = new LineAppendingReader(reader);
        CPreprocessingReader cppr = new CPreprocessingReader(null, filename, input);
        
        final FixedFormLexerPrepass prepass = new FixedFormLexerPrepass(cppr);
        SingleCharReader prepassReader = new SingleCharReader()
        {
            @Override
            public int read() throws IOException
            {
                try
                {
                    return prepass.read();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return -1;
                }
            }
            
            @Override
            public void close() throws IOException
            {
                input.close();
            }
        };
        
        final FixedFormLexerPhase1 lexer1 = new FixedFormLexerPhase1(prepassReader, prepass, null, filename);
        
        //the cppr will be ignored since we set it up above
        
//        CPreprocessingLexer lexerCPP = new CPreprocessingLexer(cppr, null, filename, true)
//        {
//            @Override protected ILexer createDelegateLexer(
//                CPreprocessingReader cpp, IFile file, String filename, boolean accumulateWhitetext)
//            {
//                return lexer1;  //force use of the lexer created above
//            }
//        };
//        
        
        //CPreprocessingLexer above was not working - stream offsets were incorrect
        //removing it from the processing stack for now since we do not need to 
        //support refactoring/rewriting of the AST right now - we just need a 
        //preprocessed parse tree for doing the analysis
        FixedFormLexerPhase2 lexer2 = new FixedFormLexerPhase2(lexer1);
        
        
//        IToken token = lexer2.yylex();
//        while (token.getTerminal() != Terminal.END_OF_INPUT) 
//        {
//           token = lexer2.yylex();
//        }
//       
        
        LexerPhase3 lexer3 = new LexerPhase3(lexer2);
        
        ASTExecutableProgramNode ast = new Parser().parse(lexer3);
        
        
        
        
    }
    
    
    private void testFixedFormPhase1Lexer() throws IOException, LexerException {
        
        String filename = "cpp-test-code/fixed_form_test_files/FIXED_TEST_NOCPP.F";
              
        final Reader reader = new BufferedReader(new FileReader(filename));
        final Reader input = new LineAppendingReader(reader);
        final FixedFormLexerPrepass prepass = new FixedFormLexerPrepass(input);
        Reader prepassReader = new SingleCharReader()
        {
            @Override
            public int read() throws IOException
            {
                try
                {
                    return prepass.read();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return -1;
                }
            }
            
            @Override
            public void close() throws IOException
            {
                input.close();
            }
        };
        
        FixedFormLexerPhase1 lexer = new FixedFormLexerPhase1(prepassReader, prepass, null, filename);
        
        String originalSource = getSourceCodeFromFile(new File(filename));
        
        StringBuffer sb = new StringBuffer(4096);
        
        IToken token = lexer.yylex();
        while (token.getTerminal() != Terminal.END_OF_INPUT) 
        {
            //set offsets
            token.setStreamOffset(lexer.getLastTokenStreamOffset());
            token.setLine(lexer.getLastTokenLine());
            token.setFileOffset(lexer.getLastTokenFileOffset());
            token.setCol(lexer.getLastTokenCol());
            token.setLength(lexer.getLastTokenLength());
                  
            //compare
            String orig = originalSource.substring(token.getStreamOffset(), token.getStreamOffset()+token.getLength());
            System.out.println("Compare: " + token.getText() + " == " + orig);
            
            //reproduce original text
            sb.append(token.getWhiteBefore());
            IPreprocessorReplacement pr = token.getPreprocessorDirective();
            if (pr != null) {
                sb.append(((FixedFormReplacement) pr).toString());
            }
            else {
                sb.append(token.getText());
            }
            sb.append(token.getWhiteAfter());
        
            
            
            token = lexer.yylex();
        }   
        
       
        
        System.out.println("Original source**********\n" + originalSource + "\n********\n\n");
        System.out.println("Reproduced source**********\n" + sb.toString() + "\n********\n\n");
        
        assertEquals(sb.toString(), originalSource);
        
    }
    
    private void testCPreprocessingLexer() throws IOException, LexerException {
        
        String filename = "cpp-test-code/fixed_form_test_files/FIXED_TEST.F";
        
        final Reader reader = new BufferedReader(new FileReader(filename));
        final Reader input = new LineAppendingReader(reader);
        final FixedFormLexerPrepass prepass = new FixedFormLexerPrepass(input);
        Reader prepassReader = new SingleCharReader()
        {
            @Override
            public int read() throws IOException
            {
                try
                {
                    return prepass.read();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return -1;
                }
            }
            
            @Override
            public void close() throws IOException
            {
                input.close();
            }
        };
        
        
        CPreprocessingLexer lexer = new CPreprocessingLexer(prepassReader, null, filename, true)
        {
            @Override protected ILexer createDelegateLexer(
                CPreprocessingReader cpp, IFile file, String filename, boolean accumulateWhitetext)
            {
                return new FixedFormLexerPhase1(cpp, prepass, file, filename);
            }
        };
        
        Token t = lexer.yylex();
        while (t.getTerminal() != Terminal.END_OF_INPUT) {
            t = lexer.yylex();
        }
        
    }
    
    private void testCPreprocessingReader() throws IOException {
    
        String filename = "cpp-test-code/fixed_form_test_files/FIXED_TEST.F";
        
        //public CPreprocessingReader(IFile file, String filename, Reader reader) throws IOException
        Reader codeReader = new FileReader(filename);
        CPreprocessingReader cppr = new CPreprocessingReader(null, filename, codeReader);
        
        int r;
        char[] buf = new char[1024];
        StringBuffer sb = new StringBuffer();
        r = cppr.read(buf);
        while (r != -1) {
            sb.append(buf, 0, r);
            r = cppr.read(buf);
        }
        
        String escaped = removeUnicodeAndEscapeChars(sb.toString());
        System.out.println("\n" + escaped + "\n");
        
    }
    
    
    private static String removeUnicodeAndEscapeChars(String input) {
        StringBuilder buffer = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            if ((int) input.charAt(i) > 256) {
                buffer.append("\\u").append(Integer.toHexString((int) input.charAt(i)));
            } else {
                if (input.charAt(i) == '\n') {
                    buffer.append("\\n");
                } else if(input.charAt(i) == '\t'){
                    buffer.append("\\t");
                }else if(input.charAt(i) == '\r'){
                    buffer.append("\\r");
                }else if(input.charAt(i) == '\b'){
                    buffer.append("\\b");
                }else if(input.charAt(i) == '\f'){
                    buffer.append("\\f");
                }else if(input.charAt(i) == '\''){
                    buffer.append("\\'");
                }else if(input.charAt(i) == '\"'){
                    buffer.append("\\");
                }else if(input.charAt(i) == '\\'){
                    buffer.append("\\\\");
                }else {
                    buffer.append(input.charAt(i));
                }
            }
        }
        return buffer.toString();
    }
     
    
//    protected IAccumulatingLexer lex(File file, ISourceForm sourceForm) throws IOException
//    {
//        return new ASTLexerFactory().createLexer(file, sourceForm);
//    }
//    
    
    private static String getSourceCodeFromFile(File file) throws IOException
    {
       return getSourceCodeFromFile(new FileReader(file));
    }
    
    private static String getSourceCodeFromFile(Reader r) throws IOException {
        StringBuffer sb = new StringBuffer(4096);
        BufferedReader in = new BufferedReader(r);
        for (int ch = in.read(); ch >= 0; ch = in.read())
            sb.append((char)ch);
        in.close();
        return sb.toString();
    }
    
    */
}

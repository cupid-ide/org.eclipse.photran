/*******************************************************************************
 * Copyright (c) 2009 University of Illinois at Urbana-Champaign and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    UIUC - Initial API and implementation
 *******************************************************************************/
package org.eclipse.photran.internal.core.analysis.loops;

import org.eclipse.photran.internal.core.parser.ASTVisitor;

/**
 * An extension of {@link ASTVisitor} which implements {@link IASTVisitorWithLoops}.
 *  
 * @author Jeff Overbey
 * @see IASTVisitorWithLoops
 */
public class ASTVisitorWithLoops extends ASTVisitor implements IASTVisitorWithLoops
{
    public void visitASTProperLoopConstructNode(ASTProperLoopConstructNode node) { traverseChildren(node); }
}

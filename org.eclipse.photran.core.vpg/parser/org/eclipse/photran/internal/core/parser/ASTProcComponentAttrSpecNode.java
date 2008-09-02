/*******************************************************************************
 * Copyright (c) 2007 University of Illinois at Urbana-Champaign and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     UIUC - Initial API and implementation
 *******************************************************************************/
package org.eclipse.photran.internal.core.parser;

import java.io.PrintStream;
import java.util.Iterator;

import java.util.List;

import org.eclipse.photran.internal.core.parser.Parser.ASTNode;
import org.eclipse.photran.internal.core.parser.Parser.ASTNodeWithErrorRecoverySymbols;
import org.eclipse.photran.internal.core.parser.Parser.IASTListNode;
import org.eclipse.photran.internal.core.parser.Parser.IASTNode;
import org.eclipse.photran.internal.core.parser.Parser.IASTVisitor;
import org.eclipse.photran.internal.core.lexer.Token;

import org.eclipse.photran.internal.core.lexer.*;                   import org.eclipse.photran.internal.core.analysis.binding.ScopingNode;

public class ASTProcComponentAttrSpecNode extends ASTNode
{
    org.eclipse.photran.internal.core.lexer.Token isPass; // in ASTProcComponentAttrSpecNode
    org.eclipse.photran.internal.core.lexer.Token isNoPass; // in ASTProcComponentAttrSpecNode
    org.eclipse.photran.internal.core.lexer.Token hiddenTLparen; // in ASTProcComponentAttrSpecNode
    org.eclipse.photran.internal.core.lexer.Token argName; // in ASTProcComponentAttrSpecNode
    org.eclipse.photran.internal.core.lexer.Token isPointer; // in ASTProcComponentAttrSpecNode
    org.eclipse.photran.internal.core.lexer.Token hiddenTRparen; // in ASTProcComponentAttrSpecNode
    ASTAccessSpecNode accessSpec; // in ASTProcComponentAttrSpecNode

    public boolean isPass()
    {
        return this.isPass != null;
    }

    public void setIsPass(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.isPass = newValue;
    }


    public boolean isNoPass()
    {
        return this.isNoPass != null;
    }

    public void setIsNoPass(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.isNoPass = newValue;
    }


    public org.eclipse.photran.internal.core.lexer.Token getArgName()
    {
        return this.argName;
    }

    public void setArgName(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.argName = newValue;
    }


    public boolean isPointer()
    {
        return this.isPointer != null;
    }

    public void setIsPointer(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.isPointer = newValue;
    }


    public ASTAccessSpecNode getAccessSpec()
    {
        return this.accessSpec;
    }

    public void setAccessSpec(ASTAccessSpecNode newValue)
    {
        this.accessSpec = newValue;
    }


    public void accept(IASTVisitor visitor)
    {
        visitor.visitASTProcComponentAttrSpecNode(this);
        visitor.visitASTNode(this);
    }

    @Override protected int getNumASTFields()
    {
        return 7;
    }

    @Override protected IASTNode getASTField(int index)
    {
        switch (index)
        {
        case 0:  return this.isPass;
        case 1:  return this.isNoPass;
        case 2:  return this.hiddenTLparen;
        case 3:  return this.argName;
        case 4:  return this.isPointer;
        case 5:  return this.hiddenTRparen;
        case 6:  return this.accessSpec;
        default: return null;
        }
    }

    @Override protected void setASTField(int index, IASTNode value)
    {
        switch (index)
        {
        case 0:  this.isPass = (org.eclipse.photran.internal.core.lexer.Token)value; return;
        case 1:  this.isNoPass = (org.eclipse.photran.internal.core.lexer.Token)value; return;
        case 2:  this.hiddenTLparen = (org.eclipse.photran.internal.core.lexer.Token)value; return;
        case 3:  this.argName = (org.eclipse.photran.internal.core.lexer.Token)value; return;
        case 4:  this.isPointer = (org.eclipse.photran.internal.core.lexer.Token)value; return;
        case 5:  this.hiddenTRparen = (org.eclipse.photran.internal.core.lexer.Token)value; return;
        case 6:  this.accessSpec = (ASTAccessSpecNode)value; return;
        default: throw new IllegalArgumentException("Invalid index");
        }
    }
}

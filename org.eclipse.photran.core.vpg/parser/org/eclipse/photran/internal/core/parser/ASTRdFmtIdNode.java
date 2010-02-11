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

import org.eclipse.photran.internal.core.parser.Parser.ASTListNode;
import org.eclipse.photran.internal.core.parser.Parser.ASTNode;
import org.eclipse.photran.internal.core.parser.Parser.ASTNodeWithErrorRecoverySymbols;
import org.eclipse.photran.internal.core.parser.Parser.IASTListNode;
import org.eclipse.photran.internal.core.parser.Parser.IASTNode;
import org.eclipse.photran.internal.core.parser.Parser.IASTVisitor;
import org.eclipse.photran.internal.core.lexer.Token;

import org.eclipse.photran.internal.core.lexer.*;                   import org.eclipse.photran.internal.core.analysis.binding.ScopingNode;                   import org.eclipse.photran.internal.core.SyntaxException;                   import java.io.IOException;

@SuppressWarnings({ "unchecked", "unused" })
public class ASTRdFmtIdNode extends ASTNode
{
    org.eclipse.photran.internal.core.lexer.Token hasEqEqOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasOrOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasMinusOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasDivideOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token definedBinaryOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasLtOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token customDefinedOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasEqOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasGeOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasAndOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hiddenTLparen; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasNeOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasTimesOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasPowerOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasGtOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasPlusOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token formatIsAsterisk; // in ASTRdFmtIdNode
    ASTCOperandNode primary1; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasNeqvOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasNotOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasLeOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token definedUnaryOp; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token label; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasSlashEqOp; // in ASTRdFmtIdNode
    ASTUFExprNode formatIdExpr; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hiddenTRparen; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasConcatOp; // in ASTRdFmtIdNode
    ASTCPrimaryNode primary2; // in ASTRdFmtIdNode
    org.eclipse.photran.internal.core.lexer.Token hasEqvOp; // in ASTRdFmtIdNode

    public boolean hasEqEqOp()
    {
        return this.hasEqEqOp != null;
    }

    public void setHasEqEqOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasEqEqOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasOrOp()
    {
        return this.hasOrOp != null;
    }

    public void setHasOrOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasOrOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasMinusOp()
    {
        return this.hasMinusOp != null;
    }

    public void setHasMinusOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasMinusOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasDivideOp()
    {
        return this.hasDivideOp != null;
    }

    public void setHasDivideOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasDivideOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public org.eclipse.photran.internal.core.lexer.Token getDefinedBinaryOp()
    {
        return this.definedBinaryOp;
    }

    public void setDefinedBinaryOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.definedBinaryOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasLtOp()
    {
        return this.hasLtOp != null;
    }

    public void setHasLtOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasLtOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public org.eclipse.photran.internal.core.lexer.Token getCustomDefinedOp()
    {
        return this.customDefinedOp;
    }

    public void setCustomDefinedOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.customDefinedOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasEqOp()
    {
        return this.hasEqOp != null;
    }

    public void setHasEqOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasEqOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasGeOp()
    {
        return this.hasGeOp != null;
    }

    public void setHasGeOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasGeOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasAndOp()
    {
        return this.hasAndOp != null;
    }

    public void setHasAndOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasAndOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasNeOp()
    {
        return this.hasNeOp != null;
    }

    public void setHasNeOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasNeOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasTimesOp()
    {
        return this.hasTimesOp != null;
    }

    public void setHasTimesOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasTimesOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasPowerOp()
    {
        return this.hasPowerOp != null;
    }

    public void setHasPowerOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasPowerOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasGtOp()
    {
        return this.hasGtOp != null;
    }

    public void setHasGtOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasGtOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasPlusOp()
    {
        return this.hasPlusOp != null;
    }

    public void setHasPlusOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasPlusOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean formatIsAsterisk()
    {
        return this.formatIsAsterisk != null;
    }

    public void setFormatIsAsterisk(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.formatIsAsterisk = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public ASTCOperandNode getPrimary1()
    {
        return this.primary1;
    }

    public void setPrimary1(ASTCOperandNode newValue)
    {
        this.primary1 = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasNeqvOp()
    {
        return this.hasNeqvOp != null;
    }

    public void setHasNeqvOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasNeqvOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasNotOp()
    {
        return this.hasNotOp != null;
    }

    public void setHasNotOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasNotOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasLeOp()
    {
        return this.hasLeOp != null;
    }

    public void setHasLeOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasLeOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public org.eclipse.photran.internal.core.lexer.Token getDefinedUnaryOp()
    {
        return this.definedUnaryOp;
    }

    public void setDefinedUnaryOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.definedUnaryOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public org.eclipse.photran.internal.core.lexer.Token getLabel()
    {
        return this.label;
    }

    public void setLabel(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.label = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasSlashEqOp()
    {
        return this.hasSlashEqOp != null;
    }

    public void setHasSlashEqOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasSlashEqOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public ASTUFExprNode getFormatIdExpr()
    {
        return this.formatIdExpr;
    }

    public void setFormatIdExpr(ASTUFExprNode newValue)
    {
        this.formatIdExpr = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasConcatOp()
    {
        return this.hasConcatOp != null;
    }

    public void setHasConcatOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasConcatOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public ASTCPrimaryNode getPrimary2()
    {
        return this.primary2;
    }

    public void setPrimary2(ASTCPrimaryNode newValue)
    {
        this.primary2 = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public boolean hasEqvOp()
    {
        return this.hasEqvOp != null;
    }

    public void setHasEqvOp(org.eclipse.photran.internal.core.lexer.Token newValue)
    {
        this.hasEqvOp = newValue;
        if (newValue != null) newValue.setParent(this);
    }


    public void accept(IASTVisitor visitor)
    {
        visitor.visitASTRdFmtIdNode(this);
        visitor.visitASTNode(this);
    }

    @Override protected int getNumASTFields()
    {
        return 29;
    }

    @Override protected IASTNode getASTField(int index)
    {
        switch (index)
        {
        case 0:  return this.hasEqEqOp;
        case 1:  return this.hasOrOp;
        case 2:  return this.hasMinusOp;
        case 3:  return this.hasDivideOp;
        case 4:  return this.definedBinaryOp;
        case 5:  return this.hasLtOp;
        case 6:  return this.customDefinedOp;
        case 7:  return this.hasEqOp;
        case 8:  return this.hasGeOp;
        case 9:  return this.hasAndOp;
        case 10: return this.hiddenTLparen;
        case 11: return this.hasNeOp;
        case 12: return this.hasTimesOp;
        case 13: return this.hasPowerOp;
        case 14: return this.hasGtOp;
        case 15: return this.hasPlusOp;
        case 16: return this.formatIsAsterisk;
        case 17: return this.primary1;
        case 18: return this.hasNeqvOp;
        case 19: return this.hasNotOp;
        case 20: return this.hasLeOp;
        case 21: return this.definedUnaryOp;
        case 22: return this.label;
        case 23: return this.hasSlashEqOp;
        case 24: return this.formatIdExpr;
        case 25: return this.hiddenTRparen;
        case 26: return this.hasConcatOp;
        case 27: return this.primary2;
        case 28: return this.hasEqvOp;
        default: throw new IllegalArgumentException("Invalid index");
        }
    }

    @Override protected void setASTField(int index, IASTNode value)
    {
        switch (index)
        {
        case 0:  this.hasEqEqOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 1:  this.hasOrOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 2:  this.hasMinusOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 3:  this.hasDivideOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 4:  this.definedBinaryOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 5:  this.hasLtOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 6:  this.customDefinedOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 7:  this.hasEqOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 8:  this.hasGeOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 9:  this.hasAndOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 10: this.hiddenTLparen = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 11: this.hasNeOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 12: this.hasTimesOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 13: this.hasPowerOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 14: this.hasGtOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 15: this.hasPlusOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 16: this.formatIsAsterisk = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 17: this.primary1 = (ASTCOperandNode)value; if (value != null) value.setParent(this); return;
        case 18: this.hasNeqvOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 19: this.hasNotOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 20: this.hasLeOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 21: this.definedUnaryOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 22: this.label = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 23: this.hasSlashEqOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 24: this.formatIdExpr = (ASTUFExprNode)value; if (value != null) value.setParent(this); return;
        case 25: this.hiddenTRparen = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 26: this.hasConcatOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        case 27: this.primary2 = (ASTCPrimaryNode)value; if (value != null) value.setParent(this); return;
        case 28: this.hasEqvOp = (org.eclipse.photran.internal.core.lexer.Token)value; if (value != null) value.setParent(this); return;
        default: throw new IllegalArgumentException("Invalid index");
        }
    }
}


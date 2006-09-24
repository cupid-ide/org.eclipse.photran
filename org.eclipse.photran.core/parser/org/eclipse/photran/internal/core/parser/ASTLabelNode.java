// Generated by Ludwig version 1.0 alpha 6

package org.eclipse.photran.internal.core.parser; import org.eclipse.photran.internal.core.lexer.*;


/**
 * <Label> ::= ticon:T_ICON  :production161
 */
public class ASTLabelNode extends ParseTreeNode
{
    public ASTLabelNode(Nonterminal nonterminal, Production production)
    {
        super(nonterminal, production);
    }

    public Token getASTTicon()
    {
        return this.getChildToken("ticon");
    }

    protected void visitThisNodeUsing(ASTVisitor visitor) { visitor.visitASTLabelNode(this); }
}
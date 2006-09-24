// Generated by Ludwig version 1.0 alpha 6

package org.eclipse.photran.internal.core.parser; import org.eclipse.photran.internal.core.lexer.*;


/**
 * <TypeName> ::= tident:T_IDENT  :production949
 */
public class ASTTypeNameNode extends ParseTreeNode
{
    public ASTTypeNameNode(Nonterminal nonterminal, Production production)
    {
        super(nonterminal, production);
    }

    public Token getASTTident()
    {
        return this.getChildToken("tident");
    }

    protected void visitThisNodeUsing(ASTVisitor visitor) { visitor.visitASTTypeNameNode(this); }
}
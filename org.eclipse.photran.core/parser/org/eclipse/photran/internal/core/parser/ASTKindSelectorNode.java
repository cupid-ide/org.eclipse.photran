// Generated by Ludwig version 1.0 alpha 6

package org.eclipse.photran.internal.core.parser; import org.eclipse.photran.internal.core.lexer.*;


/**
 * <KindSelector> ::= tlparen:T_LPAREN tkindeq:T_KINDEQ Expr:<Expr> trparen:T_RPAREN  :production263
 * <KindSelector> ::= tlparen:T_LPAREN Expr:<Expr> trparen:T_RPAREN  :production264
 */
public class ASTKindSelectorNode extends ParseTreeNode
{
    public ASTKindSelectorNode(Nonterminal nonterminal, Production production)
    {
        super(nonterminal, production);
    }

    public Token getASTTlparen()
    {
        return this.getChildToken("tlparen");
    }

    public Token getASTTkindeq()
    {
        return this.getChildToken("tkindeq");
    }

    public ASTExprNode getASTExpr()
    {
        return (ASTExprNode)this.getChild("Expr");
    }

    public Token getASTTrparen()
    {
        return this.getChildToken("trparen");
    }

    protected void visitThisNodeUsing(ASTVisitor visitor) { visitor.visitASTKindSelectorNode(this); }
}
// Generated by Ludwig version 1.0 alpha 6

package org.eclipse.photran.internal.core.parser; import org.eclipse.photran.internal.core.lexer.*;


/**
 * <AllocatedShape> ::= tlparen:T_LPAREN SectionSubscriptList:<SectionSubscriptList> trparen:T_RPAREN  :production438
 */
public class ASTAllocatedShapeNode extends ParseTreeNode
{
    public ASTAllocatedShapeNode(Nonterminal nonterminal, Production production)
    {
        super(nonterminal, production);
    }

    public Token getASTTlparen()
    {
        return this.getChildToken("tlparen");
    }

    public ASTSectionSubscriptListNode getASTSectionSubscriptList()
    {
        return (ASTSectionSubscriptListNode)this.getChild("SectionSubscriptList");
    }

    public Token getASTTrparen()
    {
        return this.getChildToken("trparen");
    }

    protected void visitThisNodeUsing(ASTVisitor visitor) { visitor.visitASTAllocatedShapeNode(this); }
}
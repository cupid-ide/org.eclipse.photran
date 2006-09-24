// Generated by Ludwig version 1.0 alpha 6

package org.eclipse.photran.internal.core.parser; import org.eclipse.photran.internal.core.lexer.*;


/**
 * <SubroutinePrefix> ::= tsubroutine:T_SUBROUTINE  :production910
 * <SubroutinePrefix> ::= PrefixSpecList:<PrefixSpecList> tsubroutine:T_SUBROUTINE  :production911
 */
public class ASTSubroutinePrefixNode extends ParseTreeNode
{
    public ASTSubroutinePrefixNode(Nonterminal nonterminal, Production production)
    {
        super(nonterminal, production);
    }

    public Token getASTTsubroutine()
    {
        return this.getChildToken("tsubroutine");
    }

    public ASTPrefixSpecListNode getASTPrefixSpecList()
    {
        return (ASTPrefixSpecListNode)this.getChild("PrefixSpecList");
    }

    protected void visitThisNodeUsing(ASTVisitor visitor) { visitor.visitASTSubroutinePrefixNode(this); }
}
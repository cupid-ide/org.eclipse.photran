// Generated by Ludwig version 1.0 alpha 6

package org.eclipse.photran.internal.core.parser; import org.eclipse.photran.internal.core.lexer.*;


/**
 * <WriteStmt> ::= LblDef:<LblDef> twrite:T_WRITE tlparen:T_LPAREN IoControlSpecList:<IoControlSpecList> trparen:T_RPAREN OutputItemList:<OutputItemList> teos:T_EOS  :production709
 * <WriteStmt> ::= LblDef:<LblDef> twrite:T_WRITE tlparen:T_LPAREN IoControlSpecList:<IoControlSpecList> trparen:T_RPAREN teos:T_EOS  :production710
 */
public class ASTWriteStmtNode extends ParseTreeNode
{
    public ASTWriteStmtNode(Nonterminal nonterminal, Production production)
    {
        super(nonterminal, production);
    }

    public ASTLblDefNode getASTLblDef()
    {
        return (ASTLblDefNode)this.getChild("LblDef");
    }

    public Token getASTTwrite()
    {
        return this.getChildToken("twrite");
    }

    public Token getASTTlparen()
    {
        return this.getChildToken("tlparen");
    }

    public ASTIoControlSpecListNode getASTIoControlSpecList()
    {
        return (ASTIoControlSpecListNode)this.getChild("IoControlSpecList");
    }

    public Token getASTTrparen()
    {
        return this.getChildToken("trparen");
    }

    public ASTOutputItemListNode getASTOutputItemList()
    {
        return (ASTOutputItemListNode)this.getChild("OutputItemList");
    }

    public Token getASTTeos()
    {
        return this.getChildToken("teos");
    }

    protected void visitThisNodeUsing(ASTVisitor visitor) { visitor.visitASTWriteStmtNode(this); }
}
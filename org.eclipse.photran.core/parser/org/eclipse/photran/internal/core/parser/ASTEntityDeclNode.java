// Generated by Ludwig version 1.0 alpha 6

package org.eclipse.photran.internal.core.parser; import org.eclipse.photran.internal.core.lexer.*;


/**
 * <EntityDecl> ::= ObjectName:<ObjectName> ( tlparen:T_LPAREN ArraySpec:<ArraySpec> trparen:T_RPAREN )? ( tasterisk:T_ASTERISK CharLength:<CharLength> )? ( Initialization:<Initialization> )?  :production258
 * <EntityDecl> ::= InvalidEntityDecl:<InvalidEntityDecl>  :production259
 */
public class ASTEntityDeclNode extends ParseTreeNode
{
    public ASTEntityDeclNode(Nonterminal nonterminal, Production production)
    {
        super(nonterminal, production);
    }

    public ASTObjectNameNode getASTObjectName()
    {
        return (ASTObjectNameNode)this.getChild("ObjectName");
    }

    public Token getASTTlparen()
    {
        return this.getChildToken("tlparen");
    }

    public ASTArraySpecNode getASTArraySpec()
    {
        return (ASTArraySpecNode)this.getChild("ArraySpec");
    }

    public Token getASTTrparen()
    {
        return this.getChildToken("trparen");
    }

    public Token getASTTasterisk()
    {
        return this.getChildToken("tasterisk");
    }

    public ASTCharLengthNode getASTCharLength()
    {
        return (ASTCharLengthNode)this.getChild("CharLength");
    }

    public ASTInitializationNode getASTInitialization()
    {
        return (ASTInitializationNode)this.getChild("Initialization");
    }

    public ASTInvalidEntityDeclNode getASTInvalidEntityDecl()
    {
        return (ASTInvalidEntityDeclNode)this.getChild("InvalidEntityDecl");
    }

    protected void visitThisNodeUsing(ASTVisitor visitor) { visitor.visitASTEntityDeclNode(this); }
}
package ast.Types;

import ast.ASTNode;
import visitor.Visitor;

public class CharType extends AbstractType {
    public CharType() {
        super(0, 0);
    }


    @Override
    public <TP,TR>TR accept(Visitor<TP,TR> v, TP p) {
        return v.visit(this,p);
    }

    @Override
    public Type arithmetic(Type other, ASTNode node) {
        if(other instanceof CharType)
            return other;
        else if(other instanceof ErrorType)
            return other;
        return super.arithmetic(other,node);

    }
    @Override
    public Type arithmetic( ASTNode node) {
        return this;
    }
    @Override
    public Type comparason(Type other, ASTNode node) {
        if(other instanceof ErrorType)
            return other;
        if(other instanceof CharType)
            return new BooleanType();
        return super.comparason(other,node);
    }
    @Override
    public Type promotesTo(Type other, ASTNode node) {
        if(other instanceof CharType)
            return other;
        else if(other instanceof ErrorType)
            return other;
        return super.promotesTo(other,node);
    }
    @Override
    public Type canBeCast(Type other, ASTNode node) {
        if(other instanceof ErrorType)
            return other;
        if(other instanceof IntType ||other instanceof DoubleType || other instanceof CharType)
            return other;

        return super.canBeCast(other,node);
    }
    @Override
    public boolean isBuildingType() {
        return true;
    }

    @Override
    public int getMemoryBytes() {
        return 1;
    }


    @Override
    public char suffix() {
        return 'b';
    }

    @Override
    public String toString() {
        return "CharType";
    }
}

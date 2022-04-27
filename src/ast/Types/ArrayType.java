package ast.Types;

import ast.ASTNode;
import visitor.Visitor;

import java.util.List;

public class ArrayType extends AbstractType{

    private Type type;
    private int dimension;
    public ArrayType(int line, int column) {
        super(0, 0);
    }

    public ArrayType( Type type, int  dimensions) {
        super(0, 0);
        this.type = type;
        this.dimension = dimension;
    }

    public Type of() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public Type squareBrakets(Type other, ASTNode node) {
        if(other instanceof  ErrorType)
            return other;
        if(other instanceof IntType)
            return getType();

        return super.squareBrakets(other,node);
    }

    @Override
    public <TP,TR>TR accept(Visitor<TP,TR> v, TP p) {
        return v.visit(this,p);
    }

    @Override
    public int getMemoryBytes() {
        return dimension*type.getMemoryBytes();
    }

}

package ast.Definitions;

import ast.AbstractASTNode;
import ast.Types.Type;
import visitor.Visitor;

public class AbstractDefinition extends AbstractASTNode implements Definition {

    private String name;
    private Type type;
    private int scope;

    private int offset;


    public AbstractDefinition(int line, int column,String name,Type type) {
        super(line, column);
        this.name= name;
        this.type=type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type=type;
    }

    @Override
    public int getScope() {
        return scope;
    }

    @Override
    public void setScope(int scope) {
        this.scope=scope;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP p) {
        return null;
    }
    @Override
    public int getOffset() {
        return offset;
    }
    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }
}

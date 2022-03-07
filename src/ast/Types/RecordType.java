package ast.Types;

import java.util.List;

public class RecordType extends AbstractType{

    private List<RecordField> fields;

    public RecordType(int line, int column) {
        super(0, 0);
    }

    public RecordType(List<RecordField> fields) {
        super(0, 0);
        this.fields = fields;
    }

    public List<RecordField> getFields() {
        return fields;
    }

    public void setFields(List<RecordField> fields) {
        this.fields = fields;
    }
}
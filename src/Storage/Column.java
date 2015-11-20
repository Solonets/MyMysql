package Storage;

import RelationalAlgebra.Primitive;

/**
 * Created by ����� on 20.11.2015.
 */
public class Column extends RelationalAlgebra.Column {
    private boolean isAutoincrement;
    private boolean isIndexed;

    public boolean isAutoincrement() {
        return isAutoincrement;
    }

    public void setAutoincrement(String autoincrement) {
        if(autoincrement.equals("true"))
            isAutoincrement = true;
        else
            isAutoincrement = false;
    }

    public boolean isIndexed() {
        return isIndexed;
    }

    public void setIndexed(String indexed) {
        if(indexed.equals("true"))
            isIndexed = true;
        else
            isIndexed = false;
    }

    public Column(String name, Primitive.Type type, boolean isAutoincrement, boolean isIndexed) {
        super(name, type);
        this.isAutoincrement = isAutoincrement;
        this.isIndexed = isIndexed;
    }
}


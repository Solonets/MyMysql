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

    public void setAutoincrement(boolean autoincrement) {
        isAutoincrement = autoincrement;
    }

    public boolean isIndexed() {
        return isIndexed;
    }

    public void setIndexed(boolean indexed) {
        isIndexed = indexed;
    }

    public Column(String name, Primitive.Type type, boolean isAutoincrement, boolean isIndexed) {
        super(name, type);
        this.isAutoincrement = isAutoincrement;
        this.isIndexed = isIndexed;
    }
}


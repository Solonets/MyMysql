package Storage;

import RelationalAlgebra.Primitive;

/**
 * Created by Булат on 20.11.2015.
 */
public class Column extends RelationalAlgebra.Column {
    private boolean isAutoincrement;
    private boolean isIndexed;
    public Column(String name, Primitive.Type type, boolean isAutoincrement, boolean isIndexed) {
        super(name, type);
        this.isAutoincrement = isAutoincrement;
        this.isIndexed = isIndexed;
    }
}

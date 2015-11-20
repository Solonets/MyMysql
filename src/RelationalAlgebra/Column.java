package RelationalAlgebra;

/**
 * Created by Булат on 20.11.2015.
 */
public class Column {
    String name;
    Primitive.Type type;
    public Column(String name, Primitive.Type type) {
        this.name = name;
        this.type = type;
    }
    public Primitive.Type getType()
    {
        return type;
    }
}

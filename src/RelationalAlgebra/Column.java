package RelationalAlgebra;

/**
 * Created by ����� on 20.11.2015.
 */
public class Column {
    private String name;
    private Primitive.Type type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Primitive.Type type) {
        this.type = type;
    }

    public Column(String name, Primitive.Type type) {
        this.name = name;
        this.type = type;
    }
    public Primitive.Type getType()
    {
        return type;
    }
}

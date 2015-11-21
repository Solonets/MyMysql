package RelationalAlgebra;

/**
 * Created by Булат on 21.11.2015.
 */
public abstract class Expression {
    Header header;
    Tuple tuple;
    private Primitive get(String name)
    {
        for (int i = 0; i < header.getColumns().size(); i++)
        {
            if (header.getColumns().get(i).getName().equals(name))
            {
                return tuple.get(i);
            }
        }
        return null;
    }
    public String name() {return "ExpressionResult";}
    public abstract Primitive expr();
    public boolean match(Header header, Tuple tuple) {
        this.header = header;
        this.tuple = tuple;
        if (!header.conform(tuple))
        {
            return false;
        }
        return expr().isTrue();
    }
}

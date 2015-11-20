package RelationalAlgebra;

/**
 * Created by Булат on 20.11.2015.
 */
public abstract class Primitive {
    public static enum Type{
        INT, REAL, STRING
    }
    public abstract String getDisplayedValue();
    public abstract Type getType();
}

package RelationalAlgebra;

/**
 * Created by Наська on 21.11.2015.
 */
public abstract class Set {
    public abstract String toString();
    public abstract boolean add(Tuple t);
    public abstract RAMSet projection(String[] columns);
}

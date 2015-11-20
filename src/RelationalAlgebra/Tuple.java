package RelationalAlgebra;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Булат on 20.11.2015.
 */
public class Tuple {
    ArrayList<Primitive> primitives;
    public Tuple(Primitive[] primitives)
    {
        this.primitives = new ArrayList<Primitive>(Arrays.asList(primitives));
    }
    public String toString()
    {
        StringBuilder str = new StringBuilder("(");
        for (Primitive a: primitives)
        {
            str.append(a.getDisplayedValue());
            str.append(", ");
        }
        str.delete(str.length() - 2, str.length());
        str.append(")");
        return str.toString();
    }
    public int size()
    {
        return primitives.size();
    }
    public Primitive get(int i)
    {
        return primitives.get(i);
    }
}

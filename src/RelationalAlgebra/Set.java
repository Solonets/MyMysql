package RelationalAlgebra;

import java.util.ArrayList;

/**
 * Created by Булат on 20.11.2015.
 */
public class Set {
    Header header;
    ArrayList<Tuple> tuples;
    public Set(Header header)
    {
        this.header = header;
        this.tuples = new ArrayList<Tuple>();
    }
    public boolean add(Tuple t)
    {
        if (header.conform(t))
        {
            this.tuples.add(t);
            return true;
        }
        return false;
    }
    public String toString()
    {
        StringBuilder str = new StringBuilder("{");
        for (Tuple a: tuples)
        {
            str.append(a);
            str.append(", ");
        }
        str.delete(str.length() - 2, str.length());
        str.append("}");
        return str.toString();
    }
}

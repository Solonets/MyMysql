package RelationalAlgebra;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ����� on 20.11.2015.
 */
public class Tuple {
    ArrayList<Primitive> primitives;
    public Tuple(Primitive[] primitives)
    {
        this.primitives = new ArrayList<Primitive>(Arrays.asList(primitives));
    }
    public Tuple(){this.primitives = new ArrayList<Primitive>();}
    public void add(Primitive p) { this.primitives.add(p);}
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
    public byte[] getDump()
    {
        try {
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            for (Primitive p: this.primitives)
            {
                buf.write(p.getDump());
            }
            return buf.toByteArray();
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

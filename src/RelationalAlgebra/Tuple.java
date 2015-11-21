package RelationalAlgebra;

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

    public String showTuple(Integer[] maxLength) {
        String resString = null;
        for(int i = 0; i < primitives.size(); i++) {
            String value = primitives.get(i).getDisplayedValue();
            resString += value;
            for(int j = value.length(); j < maxLength[i]; j++) {
                resString += " ";
            }
        }
        resString += "\n";
        return resString;
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

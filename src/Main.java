import RelationalAlgebra.*;
import RelationalAlgebra.Primitives.*;

import java.util.jar.Attributes;

public class Main {

    public static void main(String[] args) {
        Set set = new Set(new Header(new Column[]{new Column("ID", Primitive.Type.INT), new Column("Name", Primitive.Type.STRING), new Column("Grade", Primitive.Type.REAL)}));
	    set.add(new Tuple(new Primitive[]{new RAInteger(5), new RAString("Sergey"), new RAReal(5.5)}));
        set.add(new Tuple(new Primitive[]{new RAInteger(5), new RAString("Sergey"), new RAString("5.5")}));
        set.add(new Tuple(new Primitive[]{new RAInteger(3), new RAString("Nastya"), new RAReal(5.5)}));
        System.out.print(set);
    }
}

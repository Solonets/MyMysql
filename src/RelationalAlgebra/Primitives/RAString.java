package RelationalAlgebra.Primitives;

import RelationalAlgebra.Primitive;

/**
 * Created by ����� on 20.11.2015.
 */
public class RAString extends Primitive {
    private String value;
    public RAString(String value)
    {
        this.value = value;
    }
    @Override
    public String getDisplayedValue() {
        return "\"" + value + "\"";
    }
    @Override
    public Type getType() {
        return Type.STRING;
    }

}

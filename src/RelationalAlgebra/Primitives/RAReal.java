package RelationalAlgebra.Primitives;

import RelationalAlgebra.Primitive;

import java.nio.ByteBuffer;

/**
 * Created by ����� on 20.11.2015.
 */
public class RAReal extends Primitive {
    private double value;
    public RAReal(double value)
    {
        this.value = value;
    }
    @Override
    public String getDisplayedValue() {
        return "" + value;
    }

    @Override
    public Type getType() {
        return Type.REAL;
    }
    @Override
    public byte[] getDump() {
        return ByteBuffer.allocate(4).putDouble(value).array();
    }
}
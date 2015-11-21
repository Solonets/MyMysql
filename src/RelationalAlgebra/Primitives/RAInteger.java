package RelationalAlgebra.Primitives;

import RelationalAlgebra.Primitive;

import java.nio.ByteBuffer;

/**
 * Created by ����� on 20.11.2015.
 */
public class RAInteger extends Primitive {
    private int value;
    public RAInteger(int value)
    {
        this.value = value;
    }
    @Override
    public String getDisplayedValue() {
        return "" + value;
    }

    @Override
    public Type getType() {
        return Type.INT;
    }

    @Override
    public byte[] getDump() {
        return ByteBuffer.allocate(4).putInt(value).array();
    }
}

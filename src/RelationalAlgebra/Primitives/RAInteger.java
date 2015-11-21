package RelationalAlgebra.Primitives;

import RelationalAlgebra.Primitive;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayInputStream;
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
    public static RAInteger fromByteStream(ByteArrayInputStream stream)
    {
        try {
            byte[] bytes = new byte[4];
            stream.read(bytes);
            return new RAInteger(ByteBuffer.wrap(bytes).getInt());
        }
        catch (Exception e)
        {
            return null;
        }
    }
}

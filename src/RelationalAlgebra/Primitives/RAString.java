package RelationalAlgebra.Primitives;

import RelationalAlgebra.Primitive;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

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
    @Override
    public byte[] getDump() {
        try {
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            buf.write(ByteBuffer.allocate(4).putInt(value.length()).array());
            buf.write(value.getBytes());
            return buf.toByteArray();
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static RAString fromByteStream(ByteArrayInputStream stream)
    {
        try {
            byte[] bytes = new byte[4];
            stream.read(bytes);
            int length = ByteBuffer.wrap(bytes).getInt();
            byte[] str = new byte[length];
            stream.read(bytes);
            return new RAString(new String(bytes));
        } catch (Exception e)
        {
            return null;
        }
    }

}

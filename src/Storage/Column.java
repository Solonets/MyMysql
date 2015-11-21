package Storage;

import RelationalAlgebra.Primitive;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/**
 * Created by ����� on 20.11.2015.
 */
public class Column extends RelationalAlgebra.Column {
    private boolean isAutoincrement;
    private boolean isIndexed;

    public boolean isAutoincrement() {
        return isAutoincrement;
    }

    public void setAutoincrement(String autoincrement) {
        if(autoincrement.equals("true"))
            isAutoincrement = true;
        else
            isAutoincrement = false;
    }

    public boolean isIndexed() {
        return isIndexed;
    }

    public void setIndexed(String indexed) {
        if(indexed.equals("true"))
            isIndexed = true;
        else
            isIndexed = false;
    }

    public Column(String name, Primitive.Type type, boolean isAutoincrement, boolean isIndexed) {
        super(name, type);
        this.isAutoincrement = isAutoincrement;
        this.isIndexed = isIndexed;
    }
    public byte[] getMetaData() {
        try {
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            buf.write(ByteBuffer.allocate(4).putInt(getName().length()).array());
            buf.write(getName().getBytes());
            buf.write(getType().getId());
            buf.write(isAutoincrement ? 1 : 0);
            buf.write(isIndexed ? 1 : 0);
            return buf.toByteArray();
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}


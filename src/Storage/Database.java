package Storage;

import RelationalAlgebra.Primitive;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Наська on 20.11.2015.
 */
public class Database {
    String name;
    ArrayList<Table> tables;
    RandomAccessFile f;
    int pageSize;
    int pagesNum;
    int tablesNum;
    long dataOffset;

    public Database(String name) {
        this.name = name;
        this.tables = new ArrayList<Table>();
        this.open();
        this.pageSize = this.readInt();
        this.pagesNum = this.readInt();
        this.tablesNum = this.readInt();
        for (int i = 0; i < this.tablesNum; i++) {
            String tableName = this.readDynamicString();
            long startPagePos = this.tell();
            int startPage = this.readInt();
            int curPage = this.readInt();
            int lastAutoincrement = this.readInt();
            int columnsNum = this.readInt();
            Column[] columns = new Column[columnsNum];
            for (int j = 0; j < columnsNum; j++)
            {
                String columnName = this.readDynamicString();
                Primitive.Type type = Primitive.Type.fromId(this.readByte());
                int isAutoIncrement = this.readByte();
                int isIndexed = this.readByte();
                Column c = new Column(columnName, type, isAutoIncrement == 1, isIndexed == 1);
                columns[i] = c;
            }
            Header header = new Header(columns);
            Table t = new Table(tableName, header, lastAutoincrement, startPage, curPage);
            t.setStartPagePos(startPagePos);
        }
        dataOffset = this.tell();
        this.close();
    }
    public int readByte()
    {

        try {
            return f.read();
        }
        catch (Exception e)
        {
            return 0;
        }
    }
    public long tell()
    {
        try {
            return f.getFilePointer();
        }
        catch (Exception e)
        {
            return 0;
        }
    }
    public void open()
    {
        try {
            f = new RandomAccessFile(getFileName(), "rw");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void close()
    {
        try {
            f.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public String readDynamicString()
    {
        try {
            int length = this.readInt();
            byte[] bytes = new byte[length];
            f.read(bytes);
            return new String(bytes);
        } catch (Exception e)
        {
            return null;
        }
    }
    public int readInt()
    {
        try {
            byte[] bytes = new byte[4];
            f.read(bytes);
            return ByteBuffer.wrap(bytes).getInt();
        }
        catch (Exception e)
        {
            return 0;
        }
    }
    public String getFileName()
    {
        return name + ".dat";
    }
}

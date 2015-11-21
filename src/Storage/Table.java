package Storage;

import RelationalAlgebra.RAMSet;
import RelationalAlgebra.Set;
import RelationalAlgebra.Tuple;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/**
 * Created by ����� on 20.11.2015.
 */
public class Table extends Set {
    private String name;
    private Header header;
    private int lastAutoincrement = 0;
    private int startPage;
    private int curPage;
    private Database db;
    private long startPagePos = -1;

    public long getStartPagePos() {
        return startPagePos;
    }

    public void setStartPagePos(long startPagePos) {
        this.startPagePos = startPagePos;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(String curPage) {
        this.curPage = Integer.parseInt(curPage);
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = Integer.parseInt(startPage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public int getLastAutoincrement() {
        return lastAutoincrement;
    }

    public void setLastAutoincrement(String lastAutoincrement) {
        this.lastAutoincrement = Integer.parseInt(lastAutoincrement);
    }

    public Table(String name, Header header, int lastAutoincrement, int startPage, int curPage) {
        this.name = name;
        this.header = header;
        this.lastAutoincrement = lastAutoincrement;
        this.startPage = startPage;
        this.curPage = curPage;
    }

    public byte[] getMetaData() {
        try {
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            buf.write(ByteBuffer.allocate(4).putInt(name.length()).array());
            buf.write(name.getBytes());
            buf.write(ByteBuffer.allocate(4).putInt(startPage).array());
            buf.write(ByteBuffer.allocate(4).putInt(curPage).array());
            buf.write(ByteBuffer.allocate(4).putInt(lastAutoincrement).array());
            buf.write(header.getMetaData());
            return buf.toByteArray();
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public void rewriteStatistics()
    {
        db.seek(startPagePos);
        db.writeInt(startPage);
        db.writeInt(curPage);
        db.writeInt(lastAutoincrement);
    }
    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean add(Tuple t) {
        if (!header.conform(t))
        {
            return false;
        }
        Page page = null;
        if (this.curPage < 0)
        {
            page = db.allocateNewPage(-1);
            startPage = curPage = page.getId();
        }
        else
        {
            page = db.loadPage(curPage);
        }
        while (!page.insert(t))
        {
            page = db.allocateNewPage(page.getId());
            curPage = page.getId();
        }
        this.rewriteStatistics();
        return true;
    }

    @Override
    public RAMSet projection(String[] columns) {
        return null;
    }
}

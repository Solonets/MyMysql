package Storage;

import RelationalAlgebra.Tuple;

import java.util.ArrayList;

/**
 * Created by Булат on 21.11.2015.
 */
public class Page {
    int id;
    int next;
    int records;
    long freeSpace;
    ArrayList<Long> offsets;
    Database db;

    public Page(int id, int next, Database db) {
        this.id = id;
        this.db = db;
        this.next = next;
        this.records = 0;
        this.freeSpace = 4;
        this.offsets = new ArrayList<>();
    }
    public void clean()
    {
        db.seekToPage(id);
        db.writeInt(next);
        for (int i = 0; i < db.getPageSize() - 12; i++)
        {
            db.writeByte(0);
        }
        db.writeInt(4);
        db.writeInt(0);
    }
    public void reload()
    {
        db.seekToPage(id);
        next = db.readInt();
        db.seekToPage(id, Database.Location.END, -8);
        freeSpace = db.readInt();
        records = db.readInt();
        db.seekToPage(id, Database.Location.END, -4 * (records + 2));
        this.offsets = new ArrayList<>();
        for (int i = 0; i < records; i++)
        {
            db.seekToPage(id, Database.Location.END, -4 * (records + 2 + id));
            this.offsets.add((long)db.readInt());
        }
    }
    public boolean insert(Tuple t)
    {
        byte[] bytes = t.getDump();
        if (freeSpace + bytes.length + 1 + (records + 3) * 4 > db.getPageSize())
        {
            return false;
        }
        records++;
        this.offsets.add(freeSpace);
        db.seekToPage(id, Database.Location.END, -4 * (records + 2));
        db.writeInt((int)freeSpace);
        db.seekToPage(id, Database.Location.START, (int)freeSpace);
        db.writeInt(bytes.length);
        db.writeBlob(bytes);
        freeSpace += bytes.length + 4;
        db.seekToPage(id, Database.Location.END, -8);
        db.writeInt((int)freeSpace);
        db.writeInt(records);
        return true;
    }
    public int getId() {
        return id;
    }
}

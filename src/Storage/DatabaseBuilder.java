package Storage;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by ����� on 20.11.2015.
 */
public class DatabaseBuilder {
    String name;
    ArrayList<Table> tables;

    public DatabaseBuilder(String name) {
        this.name = name;
        this.tables = new ArrayList<Table>();
    }
    public String getFileName()
    {
        return name + ".dat";
    }
    public void add (Table t)
    {
        this.tables.add(t);
    }
    public boolean writeMetaData()
    {
        PrintWriter out = null;
        try {
            out = new PrintWriter(getFileName());
        } catch (Exception e) {
            return false;
        }
        out.print(tables.size() + " ");
        for(int i = 0; i < tables.size(); i++) {
            out.print(tables.get(i).getMetaData());
        }
        return true;
    }
}

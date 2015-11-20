package Storage;

import java.util.ArrayList;

/**
 * Created by Булат on 20.11.2015.
 */
public class DatabaseBuilder {
    String name;
    ArrayList<Table> tables;

    public DatabaseBuilder(String name) {
        this.name = name;
        this.tables = new ArrayList<Table>();
    }
    public void add (Table t)
    {
        this.tables.add(t);
    }
    public String getMetaData()
    {
        return "";
    }
}

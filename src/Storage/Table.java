package Storage;

import RelationalAlgebra.Header;

/**
 * Created by Булат on 20.11.2015.
 */
public class Table {
    private String name;
    private Header header;
    int lastAutoincrement = 0;

    public Table(String name, Header header, int lastAutoincrement) {
        this.name = name;
        this.header = header;
        this.lastAutoincrement = lastAutoincrement;
    }
}

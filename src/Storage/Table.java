package Storage;

import Storage.Header;

/**
 * Created by ����� on 20.11.2015.
 */
public class Table {
    private String name;
    private Header header;
    private int lastAutoincrement = 0;
    private int page;

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

    public void setLastAutoincrement(int lastAutoincrement) {
        this.lastAutoincrement = lastAutoincrement;
    }

    public Table(String name, Header header, int lastAutoincrement, int page) {
        this.name = name;
        this.header = header;
        this.lastAutoincrement = lastAutoincrement;
        this.page = page;
    }

    public String getMetaData() {
        return name + " " + lastAutoincrement + " " + page + " " + header.getMetaData();
    }
}

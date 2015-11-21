package Storage;

/**
 * Created by ����� on 20.11.2015.
 */
public class Table {
    private String name;
    private Header header;
    private int lastAutoincrement = 0;
    private int startPage;
    private int curPage;

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

    public String getMetaData() {
        return name + " " + lastAutoincrement + " " + startPage + " " + curPage + " " + header.getMetaData() + " $ ";
    }
}

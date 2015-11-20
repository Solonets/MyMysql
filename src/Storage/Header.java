package Storage;

import RelationalAlgebra.Tuple;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ����� on 20.11.2015.
 */
public class Header {
    ArrayList<Column> columns;

    public Header(Column[] columns) {
        this.columns = new ArrayList<Column>(Arrays.asList(columns));
    }
    public boolean conform (Tuple t)
    {
        if (this.columns.size() != t.size())
        {
            return false;
        }
        for (int i = 0; i < columns.size(); i++)
        {
            if (columns.get(i).getType() != t.get(i).getType())
            {
                return false;
            }
        }
        return true;
    }

    public String getMetaData() {
        String meta = new String();
        for(int i = 0; i < columns.size(); i++) {
            Column column = columns.get(i);
            meta += column.getName() + " " +
                        column.getType() + " " +
                            column.isAutoincrement() + " " +
                                column.isIndexed() + " ";
        }
        return meta;
    }
}

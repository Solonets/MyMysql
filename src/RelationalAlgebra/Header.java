package RelationalAlgebra;

import RelationalAlgebra.Column;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Булат on 20.11.2015.
 */
public class Header {
    ArrayList<Column> columns;

    public Header(Column[] columns) {
        this.columns = new ArrayList<Column>(Arrays.asList(columns));
    }
    boolean conform (Tuple t)
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
}

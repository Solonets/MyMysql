package RelationalAlgebra;

import java.util.ArrayList;

/**
 * Created by ����� on 20.11.2015.
 */
public class RAMSet extends Set{
    Header header;
    ArrayList<Tuple> tuples;
    public RAMSet(Header header)
    {
        this.header = header;
        this.tuples = new ArrayList<Tuple>();
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public ArrayList<Tuple> getTuples() {
        return tuples;
    }

    public void setTuples(ArrayList<Tuple> tuples) {
        this.tuples = tuples;
    }

    public boolean add(Tuple t)
    {
        if (header.conform(t))
        {
            this.tuples.add(t);
            return true;
        }
        return false;
    }
    public RAMSet all()
    {
        return this;
    }

    @Override
    public RAMSet selection(Condition condition) {
        ArrayList<Tuple> resTuples = new ArrayList<Tuple>();
        RAMSet set;
        for(int i = 0; i < tuples.size(); i++) {
            if(condition.match(getHeader(), getTuples().get(i))) {
                resTuples.add(getTuples().get(i));
            }
        }
        set = new RAMSet(header);
        set.setTuples(resTuples);
        return set;
    }

    public RAMSet limit(int n) {
        RAMSet set = new RAMSet(getHeader());
        for(int i = 0; i < n; i++) {
            set.getTuples().add(getTuples().get((i)));
        }
        return set;
    }

    public int findMaxWordLength(int i) {
        int maxLength = header.getColumns().get(i).getName().length();
        for(int j = 0; j < tuples.size(); j++) {
            int length = tuples.get(j).get(i).getDisplayedValue().length();
            if(length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    public RAMSet projection(String[] columns) {
        RAMSet set;
        Column column;
        Tuple tuple;
        Header resHeader;
        ArrayList<Tuple> resTuples = new ArrayList<Tuple>();
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        Column[] resColumns = new Column[columns.length];
        for(int i = 0; i < columns.length; i++) {
            for(int j = 0; j < header.getColumns().size(); j++) {
                Column resColumn = header.getColumns().get(j);
                if(columns[i].equals(resColumn.getName())) {
                    column = new Column(resColumn.getName(), resColumn.getType());
                    resColumns[j] = column;
                    indexes.add(j);
                }
            }
        }
        for(int i = 0; i < tuples.size(); i++) {
            tuple = new Tuple();
            for(int j = 0; j < indexes.size(); j++) {
                tuple.add(tuples.get(i).get(indexes.get(j)));
            }
            resTuples.add(tuple);
        }
        resHeader = new Header(resColumns);
        set = new RAMSet(resHeader);
        set.setTuples(resTuples);
        return set;
    }
}

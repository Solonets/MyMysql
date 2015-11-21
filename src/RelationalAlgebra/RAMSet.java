package RelationalAlgebra;

import java.util.ArrayList;

/**
 * Created by ����� on 20.11.2015.
 */
public class RAMSet {
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
    public String toString() {
        int maxLength;
        String resultString = null;
        for(int i = 0; i < header.getColumns().size(); i++) {
            String name = header.getColumns().get(i).getName();
            resultString = name;
            maxLength = findMaxWordLength(i);
            for(int j = name.length(); j < maxLength; j++) {
                resultString += " ";
            }
        }
        resultString += "\n";
        return resultString;
    }


    public String showRAMSet() {
        String resString = header.toString();
        int numOfAttributes = header.getColumns().size();
        Integer[] maxLength = new Integer[numOfAttributes];
        for(int i = 0 ; i < numOfAttributes; i++) {
            maxLength[i] = findMaxWordLength(i);
        }
        for(int i = 0; i < tuples.size(); i++) {
            resString += tuples.get(i).showTuple(maxLength);
        }
        return resString;
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
        ArrayList<Tuple> tuples = new ArrayList<Tuple>();
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        Column[] resColumns = new Column[columns.length];
        for(int i = 0; i < columns.length; i++) {
            for(int j = 0; j < header.getColumns().size(); j++) {
                Column resColumn = header.getColumns().get(j);
                if(columns[i].equals(resColumn)) {
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
            tuples.add(tuple);
        }
        resHeader = new Header(resColumns);
        set = new RAMSet(resHeader);
        set.setTuples(tuples);
        return set;
    }
}

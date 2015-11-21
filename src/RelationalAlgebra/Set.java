package RelationalAlgebra;

import java.util.ArrayList;

/**
 * Created by Наська on 21.11.2015.
 */
public abstract class Set {
    public abstract boolean add(Tuple t);
    public abstract RAMSet limit(int n);
    public abstract RAMSet all();
    @Override
    public String toString() {
        RAMSet s = limit(10);
        int numOfAttributes = s.getHeader().getColumns().size();
        Integer[] maxLength = new Integer[numOfAttributes];
        String resString = "";
        for(int i = 0; i < s.getHeader().getColumns().size(); i++) {
            String name = s.getHeader().getColumns().get(i).getName();
            resString += name;
            maxLength[i] = s.findMaxWordLength(i);
            for(int j = name.length(); j <= maxLength[i]; j++) {
                if(j == maxLength[i]) {
                    resString += "|";
                }
                else {resString += " ";}
            }
        }
        resString += "\n";
        for(int i = 0; i < s.getTuples().size(); i++) {
            resString += s.getTuples().get(i).showTuple(maxLength);
        }
        return resString;
    }

    public RAMSet sort(String[] attributes, boolean[] isIncrementing) {
        RAMSet set = all();
        return set;
     }
    public abstract RAMSet selection(Condition condition);

    public RAMSet projection(Expression[] expressions) {
        RAMSet set = all();
        Primitive p;
        Tuple tuple;
        Column column;
        Header header;
        Primitive.Type[] types = new Primitive.Type[expressions.length];
        Column[] columns = new Column[expressions.length];
        ArrayList<Tuple> tuples = new ArrayList<Tuple>();
        for(int i = 0; i < set.getTuples().size(); i++) {
            tuple = new Tuple();
            for(int j = 0; j < expressions.length; j++) {
                p = expressions[j].calc(set.getHeader(), set.getTuples().get(i));
                if(i == 0) {
                    types[j] = p.getType();
                }
                tuple.add(p);
            }
            tuples.add(tuple);
        }
        for(int i = 0; i < expressions.length; i++) {
            column = new Column(expressions[i].name(), types[i]);
            columns[i] = column;
        }
        header = new Header(columns);
        set = new RAMSet(header);
        set.setTuples(tuples);
        return set;
    }
}

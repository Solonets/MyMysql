package RelationalAlgebra;

/**
 * Created by Наська on 21.11.2015.
 */
public abstract class Set {
    public abstract boolean add(Tuple t);
    public abstract RAMSet projection(String[] columns);
    public abstract RAMSet limit(int n);
    public abstract RAMSet all();
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
}

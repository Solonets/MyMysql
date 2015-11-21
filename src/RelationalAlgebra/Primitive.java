package RelationalAlgebra;

/**
 * Created by ����� on 20.11.2015.
 */
public abstract class Primitive {
    public static enum Type{
        INT(0), REAL(1), STRING(2);
        int id;
        Type(int id) {this.id = id;}
        public static Type fromId(int id)
        {
            switch (id)
            {
                case 0:
                    return INT;
                case 1:
                    return REAL;
                case 2:
                    return STRING;
                default:
                    return INT;
            }
        }
        public int getId(){ return id; };
    }
    public abstract String getDisplayedValue();
    public abstract Type getType();
}

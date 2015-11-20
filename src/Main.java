import RelationalAlgebra.*;
import RelationalAlgebra.Primitives.*;
import Storage.DatabaseBuilder;
import Storage.Table;
import Storage.Column;
import Storage.Header;

import java.util.jar.Attributes;

public class Main {

    public static void main(String[] args) {
        DatabaseBuilder db = new DatabaseBuilder("mydblp");
        db.add(new Table("Alias", new Header(new Column[]{
                new Column("ID", Primitive.Type.INT, true, true),
                new Column("Alias", Primitive.Type.STRING, false, false),
                new Column("Alias", Primitive.Type.STRING, false, true)
        }), 0, 0));
        db.add(new Table("Article", new Header(new Column[]{
                new Column("PublicationID", Primitive.Type.INT, false, true),
                new Column("EditionID", Primitive.Type.INT, false, true)
        }), 0, 0));
        db.add(new Table("AuthorEditor", new Header(new Column[]{
                new Column("AliasID", Primitive.Type.INT, false, true),
                new Column("PublicationID", Primitive.Type.INT, false, true),
                new Column("Type", Primitive.Type.STRING, false, false)
        }), 0, 0));
        db.writeMetaData();
    }
}

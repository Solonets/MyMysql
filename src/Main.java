import RelationalAlgebra.*;
import RelationalAlgebra.Primitives.*;
import Storage.*;
import Storage.Column;
import Storage.Header;

import java.util.jar.Attributes;

public class Main {
    public static void main(String[] args) {
        //clear();
        Database d = new Database("mydblp");
        d.getTable("Alias").add(new Tuple(new Primitive[]{new RAInteger(1), new RAString("Sergey Solonets"), new RAInteger(3)}));
        d.getTable("Alias").add(new Tuple(new Primitive[]{new RAInteger(2), new RAString("Hellos"), new RAInteger(3)}));
        System.out.print(d.getTable("Alias"));
        d.close();
        //d.getTable("Alias")
    }
    public static void clear()
    {
        DatabaseBuilder db = new DatabaseBuilder("mydblp");
        db.add(new Table("Alias", new Header(new Column[]{
                new Column("ID", Primitive.Type.INT, true, true),
                new Column("Alias", Primitive.Type.STRING, false, false),
                new Column("PersonID", Primitive.Type.INT, false, true)
        }), 0, -1, -1));
        db.add(new Table("Article", new Header(new Column[]{
                new Column("PublicationID", Primitive.Type.INT, false, true),
                new Column("EditionID", Primitive.Type.INT, false, true)
        }), 0, -1, -1));
        db.add(new Table("AuthorEditor", new Header(new Column[]{
                new Column("AliasID", Primitive.Type.INT, false, true),
                new Column("PublicationID", Primitive.Type.INT, false, true),
                new Column("Type", Primitive.Type.STRING, false, false)
        }), 0, -1, -1));
        db.add(new Table("Book", new Header(new Column[]{
                new Column("PublicationID", Primitive.Type.INT, false, true),
                new Column("BookTitle", Primitive.Type.STRING, false, false),
                new Column("ISBN", Primitive.Type.STRING, false, false),
                new Column("Volume", Primitive.Type.STRING, false, false),
                new Column("Year", Primitive.Type.INT, false, false),
                new Column("MonthStart", Primitive.Type.INT, false, false),
                new Column("MonthEnd", Primitive.Type.INT, false, false),
                new Column("Adress", Primitive.Type.STRING, false, false),
                new Column("PublisherID", Primitive.Type.INT, false, true),
                new Column("SerieID", Primitive.Type.INT, false, true),
                new Column("SchoolID", Primitive.Type.INT, false, true)
        }), 0, -1, -1));
        db.add(new Table("Cite", new Header(new Column[]{
                new Column("PublicationID1", Primitive.Type.INT, false, true),
                new Column("PublicationID2", Primitive.Type.INT, false, true)
        }), 0, -1, -1));
        db.add(new Table("Edition", new Header(new Column[]{
                new Column("ID", Primitive.Type.INT, true, true),
                new Column("Year", Primitive.Type.INT, false, false),
                new Column("MonthStart", Primitive.Type.INT, false, false),
                new Column("MonthEnd", Primitive.Type.INT, false, false),
                new Column("Volume", Primitive.Type.STRING, false, false),
                new Column("Issue", Primitive.Type.STRING, false, true),
                new Column("JournalID", Primitive.Type.INT, false, true)
        }), 0, -1, -1));
        db.add(new Table("Incollection", new Header(new Column[]{
                new Column("PublicationID", Primitive.Type.INT, false, true),
                new Column("BookID", Primitive.Type.INT, false, true)
        }), 0, -1, -1));
        db.add(new Table("Inproceeding", new Header(new Column[]{
                new Column("PublicationID", Primitive.Type.INT, false, true),
                new Column("ProceedingID", Primitive.Type.INT, false, true)
        }), 0, -1, -1));
        db.add(new Table("Journal", new Header(new Column[]{
                new Column("ID", Primitive.Type.INT, false, true),
                new Column("Name", Primitive.Type.STRING, false, false)
        }), 0, -1, -1));
        db.add(new Table("Person", new Header(new Column[]{
                new Column("ID", Primitive.Type.INT, false, true),
                new Column("DBLPKey", Primitive.Type.STRING, false, false),
                new Column("Info", Primitive.Type.STRING, false, false),
                new Column("ModificationDate", Primitive.Type.STRING, false, false),
                new Column("Homepage", Primitive.Type.STRING, false, false),
                new Column("Photo", Primitive.Type.STRING, false, false),
                new Column("Rank", Primitive.Type.REAL, false, false)
        }), 0, -1, -1));
        db.add(new Table("Proceeding", new Header(new Column[]{
                new Column("PublicationID", Primitive.Type.INT, false, true),
                new Column("BookTitle", Primitive.Type.STRING, false, false),
                new Column("ISBN", Primitive.Type.STRING, false, false),
                new Column("Volume", Primitive.Type.STRING, false, false),
                new Column("Year", Primitive.Type.INT, false, false),
                new Column("MonthStart", Primitive.Type.INT, false, false),
                new Column("MonthEnd", Primitive.Type.INT, false, false),
                new Column("Adress", Primitive.Type.STRING, false, false),
                new Column("PublisherID", Primitive.Type.INT, false, true),
                new Column("SerieID", Primitive.Type.INT, false, true),
                new Column("Issue", Primitive.Type.STRING, false, false)
        }), 0, -1, -1));
        db.add(new Table("Publication", new Header(new Column[]{
                new Column("ID", Primitive.Type.INT, true, true),
                new Column("Title", Primitive.Type.STRING, false, false),
                new Column("DBLPKey", Primitive.Type.STRING, false, false),
                new Column("Pages", Primitive.Type.STRING, false, false),
                new Column("ModificationDate", Primitive.Type.STRING, false, false),
                new Column("Note", Primitive.Type.STRING, false, false),
                new Column("Rank", Primitive.Type.REAL, false, false)
        }), 0, -1, -1));
        db.add(new Table("Publisher", new Header(new Column[]{
                new Column("ID", Primitive.Type.INT, true, true),
                new Column("Name", Primitive.Type.STRING, false, false)
        }), 0, -1, -1));
        db.add(new Table("School", new Header(new Column[]{
                new Column("ID", Primitive.Type.INT, true, true),
                new Column("Name", Primitive.Type.STRING, false, false)
        }), 0, -1, -1));
        db.add(new Table("Serie", new Header(new Column[]{
                new Column("ID", Primitive.Type.INT, true, true),
                new Column("Name", Primitive.Type.STRING, false, false),
                new Column("DBLPKey", Primitive.Type.STRING, false, false)
        }), 0, -1, -1));
        db.add(new Table("Proceeding", new Header(new Column[]{
                new Column("PublicationID", Primitive.Type.INT, false, true),
                new Column("Type", Primitive.Type.STRING, false, false),
                new Column("Year", Primitive.Type.INT, false, false),
                new Column("MonthStart", Primitive.Type.INT, false, false),
                new Column("MonthEnd", Primitive.Type.INT, false, false),
                new Column("SchoolID", Primitive.Type.INT, false, true)
        }), 0, -1, -1));
        db.add(new Table("URL", new Header(new Column[]{
                new Column("ID", Primitive.Type.INT, true, true),
                new Column("URL", Primitive.Type.STRING, false, false),
                new Column("PublicationID", Primitive.Type.INT, false, true)
        }), 0, -1, -1));
        db.add(new Table("Users", new Header(new Column[]{
                new Column("ID", Primitive.Type.INT, true, true),
                new Column("Email", Primitive.Type.STRING, false, false),
                new Column("Name", Primitive.Type.STRING, false, false),
                new Column("LastName", Primitive.Type.STRING, false, false),
                new Column("Password", Primitive.Type.STRING, false, false),
                new Column("Privelege", Primitive.Type.STRING, false, false),
                new Column("Photo", Primitive.Type.STRING, false, false)
        }), 0, -1, -1));
        db.writeMetaData();
    }
}


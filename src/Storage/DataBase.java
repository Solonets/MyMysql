package Storage;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Наська on 20.11.2015.
 */
public class Database {
    public boolean readMetaData(Table[] table) {
        String inputData;
        Scanner in = null;
        Scanner iter = null;
        int numOfTables;
        int numOfAttributes;
        try {
            in = new Scanner(new File("browser.in"));
        } catch (Exception e) {
            return false;
        }
        numOfTables = in.nextInt();
        inputData = in.nextLine();
        String[] tables = inputData.split("$");
        for(int i = 0; i < tables.length; i++) {
            iter = new Scanner(tables[i]);
            table[i].setName(iter.next());
            table[i].setLastAutoincrement(iter.next());
            table[i].setPage(iter.next());
            numOfAttributes = Integer.parseInt(iter.next());
            for(int j = 0; j < numOfAttributes; j++) {
                table[i].getHeader().getColumns().get(j).setName(iter.next());
                table[i].getHeader().getColumns().get(j).setType(iter.next());
                table[i].getHeader().getColumns().get(j).setAutoincrement(iter.next());
                table[i].getHeader().getColumns().get(j).setIndexed(iter.next());
            }
        }
        return true;
    }
}

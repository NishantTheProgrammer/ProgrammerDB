package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class FileDb {
    public static LinkedHashSet<String> getList(String path) {
        LinkedHashSet<String> list = new LinkedHashSet<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String line = bf.readLine();
            while (line != null) {
                list.add(line);
                line = bf.readLine();
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static LinkedHashSet<String> getDatabases() {
        return getList("databases/info.txt");
    }
    // public static void createDatabase(String dbName) {
    //     ArrayList
    // }

    public static void printDatabases() {
        getDatabases().forEach(database -> System.out.println(database));
    }

    public static LinkedHashSet<String> getTables(String databaseName) {
        return getList("databases/" + databaseName +"/info.txt");
    }

    public static void printTables(String databaseName) {
        getTables(databaseName).forEach(table -> System.out.println(table));
    }

}

package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileDb {
    public static ArrayList<String> getList(String path) {
        ArrayList<String> list = new ArrayList<>();
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

    public static ArrayList<String> getDatabases() {
        return getList("databases/info.txt");
    }

    public static void printDatabases() {
        getDatabases().forEach(database -> System.out.println(database));
    }

    public static ArrayList<String> getTables(String databaseName) {
        return getList("databases/" + databaseName +"/info.txt");
    }

    public static void printTables(String databaseName) {
        getTables(databaseName).forEach(table -> System.out.println(table));
    }
}

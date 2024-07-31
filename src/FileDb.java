package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import src.Exceptions.DbAlreadyExists;
import src.Exceptions.DbException;

public class FileDb {

    private static String DB_META_FILE_PATH = "databases/info.txt";
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
        return getList(DB_META_FILE_PATH);
    }
    public static void createDatabase(String dbName) throws DbException {
        if(getDatabases().contains(dbName)) throw new DbAlreadyExists();
        try {
            FileWriter fw = new FileWriter(DB_META_FILE_PATH, true);
            fw.write("\n" + dbName);
            File dataDirectory = new File("databases/" + dbName + "/tables/data");
            File metadataDirectory = new File("databases/" + dbName + "/tables/metadata");
            File tableInfoFile = new File("databases/" + dbName + "/info.txt");
            dataDirectory.mkdirs();
            metadataDirectory.mkdirs();
            tableInfoFile.createNewFile();
            fw.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Added database " + dbName);
    }

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

package src;

import java.io.*;
import java.util.ArrayList;

import src.Exceptions.DbException;

public class Table implements Serializable {
    protected String _tableName;
    ArrayList<Column> columns = new ArrayList<>();
    // private static final long serialVersionUID = 2135094326326691332L;

    public Table(String tableName) {
        this._tableName = tableName;
        this.columns.add(new Column("name", "varchar", null, "Name of Student"));
        this.columns.add(new Column("age", "int", null, "Age in years"));
    }

    public static String getMetadataFilePath(String dbName, String tableName) {
        return "databases/" + dbName + "/tables/metadata/" + tableName + ".txt";
    }

    static void createTable(String dbName, String tableName) throws DbException {
        try {
            FileDb.createTable(dbName, tableName);
            Table table = new Table(tableName);
            String filePath  = getMetadataFilePath(dbName, tableName);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(table);
            oos.close();
        } catch(IOException e) {
            e.printStackTrace();

        }
    }

    static Table getTable(String dbName, String tableName) {
        try {
            String filePath  = getMetadataFilePath(dbName, tableName);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            Table table = (Table)ois.readObject();
            ois.close();
            return table;
        } catch(Exception e) {
            System.out.println("ER" + e.getMessage());
            return null;
        }
    }

    public void insert() {

    }

    public Object find() {
        // ArrayList resultSet = new ArrayList<>();
        // try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
        //     String line;
        //     while((line = br.readLine()) != null) {
        //         String[] values = line.split(",");

        //         for(String value: values) {
        //             System.err.println("valeu " +value);
        //         }
        //     }

        // } catch(Exception e) {
        //     e.printStackTrace();
        // }
        return "nisahnt";
    }

    public void delete() {

    }

    public void update() {

    }

}

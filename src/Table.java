package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Table {
    protected String _tableName;
    Column[] columns;

    Table(String tableName) {
        this._tableName = tableName;
    }

    static void createTable() {

    }

    public void create() {

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

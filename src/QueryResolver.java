package src;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import src.Exceptions.DbException;
import src.Exceptions.InvalidCommndException;
import src.Exceptions.NoDatabaseSelectedException;

public class QueryResolver {
    String databaseName;

    QueryResolver() {

    }
    QueryResolver(String databaseName) {
        this.databaseName = databaseName;
    }

    public int excecute(String query) throws DbException {

        String[] tokens = query.split("\\s+");

        if(tokens[0].equalsIgnoreCase("USE")) {
            this.use(query, tokens);
            return 1;
        }

        if(this.databaseName == null) {
            if(tokens[0].equalsIgnoreCase("SHOW")) {
                this.show(query, tokens);
            }
            else if(tokens[0].equalsIgnoreCase("CREATE")) {
                this.create(query, tokens);
            } else {
                throw new NoDatabaseSelectedException();
            }
            return 1;
        }
        switch (tokens[0].toUpperCase()) {
            case "SHOW": return this.show(query, tokens);
            case "DESC": return this.describe(query, tokens);
            case "SELECT": return this.select(query, tokens);
            case "INSERT": return this.insert(query, tokens);
            case "DELETE": return this.delete(query, tokens);
            case "UPDATE": return this.update(query, tokens);
            case "CREATE": return this.create(query, tokens);
        
            default: throw new InvalidCommndException();
        }
    }

    public int show(String query, String[] tokens) throws DbException {
        if(tokens[1].equalsIgnoreCase("DATABASES")) {
            FileDb.printDatabases();
        }
        else if(tokens[1].equalsIgnoreCase("TABLES")) {
            if(databaseName == null) throw new NoDatabaseSelectedException();
            FileDb.printTables(this.databaseName);
        }
        return 1;
    }


    public int describe(String query, String[] tokens) {
        Table table = Table.getTable(databaseName, tokens[1]);

        System.out.println("Table Name: " + table._tableName);
        table.columns.forEach(column -> {
            System.out.println(column.name + "(" + column.type + ")");
        });
        return 1;

    }


    public int use(String query, String[] tokens) {
        String databaseName = tokens[1];
        if(FileDb.getDatabases().contains(databaseName)) {
            this.databaseName = databaseName;
        } else {
            System.err.println(ConsoleColors.RED +  "DATABASE (" + databaseName + ") NOT FOUND ❌ " + ConsoleColors.RESET);
        }
        return 1;
    }
    public int select(String query, String[] tokens) {
        
        // Table student = new Table("student");



        // Object data = student.find();
        // System.out.println(data);
        // System.out.println("This command will fetch some data");
        return 1;

    }
    public int insert(String query, String[] tokens) {
        System.out.println("This command will store some data");
        return 1;

    }
    public int update(String query, String[] tokens) {
        System.out.println("This command will update some data");
        return 1;

    }
    public int delete(String query, String[] tokens) {
        System.out.println("This command will remove some data");
        return 1;
    }

    public int create(String query, String[] tokens) throws DbException {
        // Table.createTable();
        if(tokens[1].equalsIgnoreCase("DATABASE")) {
            FileDb.createDatabase(tokens[2]);
        }
        else if(tokens[1].equalsIgnoreCase("TABLE")) {
            if(databaseName == null) throw new NoDatabaseSelectedException();
            Table.createTable(this.databaseName, tokens[2]);
        }
        return 1;

    }

    public void prompt() {
        System.out.print("\033\143");
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        String command; 
        while(true) {
            System.out.print(ConsoleColors.GREEN_BOLD + "ProgrammerDB(" + (this.databaseName != null ? this.databaseName : "") +")> " + ConsoleColors.RESET);
            command = sc.nextLine();
            if(command.equalsIgnoreCase("exit")) {
                System.out.println("BYE");
                break;
            }

            try {
                this.excecute(command);
            } catch(DbException e) {
                System.out.println(e.getColoredMessage());
            }

        }
        sc.close();
    }
}

package src;

import java.util.Arrays;
import java.util.Scanner;

public class QueryResolver {
    String databaseName;
    QueryResolver(String databaseName) {
        this.databaseName = databaseName;
    }

    public int excecute(String query) {

        String[] tokens = query.split("\\s+");

        
        System.out.println(ConsoleColors.BLUE + "EXCECUTING QUERY: " + ConsoleColors.RESET + query);
        switch (tokens[0].toUpperCase()) {
            case "SELECT": return this.select(tokens);
            case "INSERT": return this.insert(tokens);
            case "DELETE": return this.delete(tokens);
            case "UPDATE": return this.update(tokens);
        
            default:
                System.out.print(ConsoleColors.RED  + "INVALID COMMAND" + ConsoleColors.RESET);
                break;
        }
        return 1;
    }

    public int select(String[] tokens) {
        System.out.println("This command will fetch some data");
        return 1;

    }
    public int insert(String[] tokens) {
        System.out.println("This command will store some data");
        return 1;

    }
    public int update(String[] tokens) {
        System.out.println("This command will update some data");
        return 1;

    }
    public int delete(String[] tokens) {
        System.out.println("This command will remove some data");
        return 1;
    }

    public void prompt() {
        System.out.print("\033\143");
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        String command; 
        while(true) {
            System.out.print(ConsoleColors.GREEN_BOLD + "ProgrammerDB(" + this.databaseName +")>" + ConsoleColors.RESET);
            command = sc.nextLine();
            if(command.equalsIgnoreCase("exit")) {
                System.out.println("BYE");
                break;
            }

            this.excecute(command);
        }
        sc.close();
    }
}

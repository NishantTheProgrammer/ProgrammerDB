package src;

import java.util.Scanner;

public class QueryResolver {
    QueryResolver(String databaseName) {
        System.out.print("databaseName: " + databaseName);
    }

    public int excecute(String query) {

        System.out.println(ConsoleColors.BLUE + "EXCECUTING QUERY: " + ConsoleColors.RESET + query);
        return 1;
    }

    public void prompt() {
        System.out.print("\033\143");
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        String command; 
        while(true) {
            System.out.print(ConsoleColors.GREEN_BOLD + "ProgrammerDB> " + ConsoleColors.RESET);
            command = sc.nextLine();
            if(command.equalsIgnoreCase("exit")) break;

            this.excecute(command);
        }
        sc.close();
    }
}

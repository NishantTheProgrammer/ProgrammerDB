package src;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hey");
        QueryResolver qr = new QueryResolver("test");

        qr.prompt();
    }
}
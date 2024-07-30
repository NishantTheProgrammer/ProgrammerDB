package src;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        QueryResolver qr = new QueryResolver("school");
        qr.prompt();
    }
}
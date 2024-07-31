package src.Exceptions;

import src.ConsoleColors;

public class DbAlreadyExists extends DbException {
    public DbAlreadyExists() {
        super("DATABASE ALREADY EXISTS");
    }
}

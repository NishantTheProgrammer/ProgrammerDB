package src.Exceptions;

import src.ConsoleColors;

public class TableAlreadyExists extends DbException {
    public TableAlreadyExists() {
        super("TABLE ALREADY EXISTS");
    }
}

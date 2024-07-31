package src.Exceptions;

import src.ConsoleColors;

public class DbException extends Exception {
    DbException(String msg) {
        super(msg);
    }

    public String getColoredMessage() {
        return ConsoleColors.RED + getMessage() + " ❌" + ConsoleColors.RESET;
    }
}

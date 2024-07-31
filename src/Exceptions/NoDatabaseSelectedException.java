package src.Exceptions;

import src.ConsoleColors;

public class NoDatabaseSelectedException extends DbException {
    public NoDatabaseSelectedException() {
        super("DATABASE NOT SELECTED");
    }
}

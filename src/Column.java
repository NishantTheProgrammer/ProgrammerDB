package src;

import java.io.Serializable;

public class Column implements Serializable {
    String name;
    String type;
    Boolean nullable = true;
    Boolean primary = false;
    Boolean unique = false;
    Object defaultValue;
    String comment;

    // Constructor with defaults
    public Column(String name, String type, Object defaultValue, String comment) {
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
        this.comment = comment;
    }

    // Constructor with all parameters
    public Column(String name, String type, Boolean nullable, Boolean primary, Boolean unique, Object defaultValue, String comment) {
        this.name = name;
        this.type = type;
        this.nullable = nullable;
        this.primary = primary;
        this.unique = unique;
        this.defaultValue = defaultValue;
        this.comment = comment;
    }
}

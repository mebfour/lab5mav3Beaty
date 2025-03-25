package Commands;

import java.util.LinkedHashMap;

public interface Command {
    LinkedHashMap<Object, Object> execute(String[] args);      //  см. паттерн Command
    String getDescription();


}

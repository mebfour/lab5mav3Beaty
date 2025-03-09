package Commands;

public interface Command {
    void execute(String[] args);      //  см. паттерн Command
    String getDescription();


}

package Commands;

public class ExitCommand implements Command {

    @Override
    public void execute(String[] args) {
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "завершает программу";
    }


}

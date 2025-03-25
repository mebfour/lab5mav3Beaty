package Commands;

import java.util.LinkedHashMap;

public class ExitCommand implements Command {

    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        System.out.println(" ______\n" +
                "< bye >\n" +
                " ------\n" +
                "        \\   ^__^\n" +
                "         \\  (oo)\\_______\n" +
                "            (__)\\       )\\/\\\n" +
                "                ||----w |\n" +
                "                ||     ||\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n");
        System.exit(0);
        return null;
    }

    @Override
    public String getDescription() {
        return "завершает программу";
    }


}

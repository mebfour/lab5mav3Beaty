package Commands;
import InputHandler.InputProvider;
import InputHandler.KeyboardInputProvider;
import InputHandler.inputName;
import MyClasses.Route;

import java.util.Scanner;

public class AddCommand implements Command{

    @Override
    public String getDescription() {
        return "добавляет новый объект в конец коллекции";
    }

    @Override
    public void execute(String[] args) {
        InputProvider inputProvider = new KeyboardInputProvider();
        Route rn = new Route();
        inputName.sthName(rn, inputProvider);
    }





}

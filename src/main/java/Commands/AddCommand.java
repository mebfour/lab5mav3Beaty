package Commands;
import InputHandler.InputProvider;
import InputHandler.KeyboardInputProvider;
import InputHandler.inputObject;
import MyClasses.Route;

import java.util.LinkedHashMap;

public class AddCommand implements Command{

    @Override
    public String getDescription() {
        return "добавляет новый объект в конец коллекции";
    }

    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        InputProvider inputProvider = new KeyboardInputProvider();
        Route rn = new Route();
        inputObject.sthName(rn, inputProvider);
        return null;
    }





}

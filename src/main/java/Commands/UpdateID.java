package Commands;

import InputHandler.InputProvider;
import InputHandler.KeyboardInputProvider;
import InputHandler.inputObject;
import MyClasses.Route;

import java.util.LinkedHashMap;

import static Service.CollectionManager.routeList;

public class UpdateID extends AddCommand{

    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        InputProvider inputProvider = new KeyboardInputProvider();
        String k = inputObject.findKeyById(inputProvider);
        Route rn = routeList.get(k);
        inputObject.sthName(rn, inputProvider);
        routeList.put(rn.getName(),rn);
        return null;
    }

    @Override
    public String getDescription() {
        return "обновляет значение элемента коллекции, id которого равен заданному";
    }

}

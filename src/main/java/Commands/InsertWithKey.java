package Commands;

import InputHandler.InputProvider;
import InputHandler.KeyboardInputProvider;
import InputHandler.inputObject;
import MyClasses.Route;

import java.util.LinkedHashMap;

import static Service.CollectionManager.routeList;

public class InsertWithKey extends AddCommand {

    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {

        InputProvider inputProvider = new KeyboardInputProvider();
        Route rn = new Route();
        inputObject.inputKey(rn);
        inputObject.sthName(rn, inputProvider);
        routeList.put(rn.getKey(), rn);

        return null;
    }

    @Override
    public String getDescription() {
        return "добавляет элемент с заданным ключом";
    }

}

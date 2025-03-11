package Commands;

import InputHandler.InputProvider;
import InputHandler.KeyboardInputProvider;
import InputHandler.inputName;
import MyClasses.Route;

import java.util.Scanner;

import static Service.CollectionManager.routeList;

public class InsertNull extends AddCommand {

    @Override
    public void execute(String[] args) {

        InputProvider inputProvider = new KeyboardInputProvider();
        Route rn = new Route();
        inputName.inputKey(rn);
        inputName.sthName(rn, inputProvider);
        routeList.put(rn.getKey(), rn);

    }

    @Override
    public String getDescription() {
        return "добавляет элемент с заданным ключом";
    }

}

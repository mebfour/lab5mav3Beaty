package Commands;

import InputHandler.InputProvider;
import InputHandler.KeyboardInputProvider;
import InputHandler.inputName;
import MyClasses.Route;

import static Service.CollectionManager.routeList;

public class UpdateID extends AddCommand{

    @Override
    public void execute(String[] args) {
        InputProvider inputProvider = new KeyboardInputProvider();
        String k =inputName.findKeyById(inputProvider);
        Route rn = routeList.get(k);
        inputName.sthName(rn, inputProvider);
        routeList.put(rn.getName(),rn);
    }

    @Override
    public String getDescription() {
        return "обновляет значение элемента коллекции, id которого равен заданному";
    }

}

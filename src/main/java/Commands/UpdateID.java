package Commands;

import IDK_IJUSTWANTAWORKINGFUCKINGPROGRAMM.inputName;
import MyClasses.Route;

import static Service.CollectionManager.routeList;

public class UpdateID extends AddCommand{

    @Override
    public void execute(String[] args) {
        Route rn = new Route();
        inputName.updateID(rn);
        inputName.sthName(rn);
        routeList.put(rn.getName(),rn);
    }

    @Override
    public String getDescription() {
        return "обновляет значение элемента коллекции, id которого равен заданному";
    }

}

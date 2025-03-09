package Commands;

import IDK_IJUSTWANTAWORKINGFUCKINGPROGRAMM.inputName;
import MyClasses.Route;
import static Service.CollectionManager.routeList;

public class InsernNull extends AddCommand {

    @Override
    public void execute(String[] args) {
        Route rn = new Route();
        inputName.inputKey(rn);
        inputName.sthName(rn);
        routeList.put(rn.getKey(), rn);
    }

    @Override
    public String getDescription() {
        return "добавляет элемент с заданным ключом";
    }

}

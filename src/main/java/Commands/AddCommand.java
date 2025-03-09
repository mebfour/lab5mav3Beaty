package Commands;
import IDK_IJUSTWANTAWORKINGFUCKINGPROGRAMM.inputName;
import MyClasses.Route;

public class AddCommand implements Command{
    @Override
    public String getDescription() {
        return "добавляет новый объект в конец коллекции";
    }

    @Override
    public void execute(String[] args) {
        Route rn = new Route();
        inputName.sthName(rn);
    }





}

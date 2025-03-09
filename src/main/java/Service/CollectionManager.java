package Service;

import MyClasses.Route;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;



public class CollectionManager {


    public static LinkedHashMap<String, Route> routeList = new LinkedHashMap<>();
    // Дата инициализации коллекции. Обновляется каждый раз при запуске приложения.
    private final java.time.ZonedDateTime initializationTime;
    {
        initializationTime = java.time.ZonedDateTime.now();
    }
    public CollectionManager(){};



    public void addToCollection(Route route){

        try {

            routeList.put(route.getKey(), route);
        }catch (Exception e){
            routeList.put(route.getName(),route);
        }


    }
    public static Class<?> getCollectionType(){
        return routeList.getClass();
    }

    public ZonedDateTime getCollectionInitializationTime() {
        return initializationTime;
    }

    public LinkedHashMap getCollection() {
        return routeList;
    }



}

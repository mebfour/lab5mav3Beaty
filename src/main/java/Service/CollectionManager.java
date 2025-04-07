package Service;

import Commands.XmlProcessing.XmlRouteReader;
import MyClasses.Route;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.ZonedDateTime;
import java.util.LinkedHashMap;




@XmlRootElement(name = "routeList")
public class CollectionManager {
    public static String globalFilePath;

    public static LinkedHashMap<String, Route> routeList = XmlRouteReader.readRoutesFromXml(globalFilePath);
    private final java.time.ZonedDateTime initializationTime;

    {
        initializationTime = java.time.ZonedDateTime.now();
    }

    public static void init(String path) {
        globalFilePath = path;
        routeList = XmlRouteReader.readRoutesFromXml(globalFilePath);
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


    @XmlElement(name="route")
    public LinkedHashMap getCollection() {
        return routeList;
    }



}

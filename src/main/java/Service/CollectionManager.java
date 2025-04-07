package Service;

import Commands.XmlProcessing.XmlRouteReader;
import MyClasses.Route;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.Date;




@XmlRootElement(name = "routeList")
public class CollectionManager {
    public static String globalFilePath;
    public static LinkedHashMap<String, Route> routeList = XmlRouteReader.readRoutesFromXml(globalFilePath);
    private static Date initializationTime = new Date();

    public static void init(String path) {
        globalFilePath = path;
        routeList = XmlRouteReader.readRoutesFromXml(globalFilePath);
    }

    public static Date getInitializationTime() {
        return initializationTime;
    }

    public static void setInitializationTime(Date date) {
        if (date != null) {
            initializationTime = date;
        }
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



    @XmlElement(name="route")
    public LinkedHashMap getCollection() {
        return routeList;
    }



}

package Service;

import Commands.XmlProcessing.XmlRouteReader;
import MyClasses.Route;

import java.util.LinkedHashMap;

public class DataProcessor {
    public void processData(String filePath) {
        // Передаем filePath дальше
        XmlRouteReader xmlRouteReader = new XmlRouteReader();
        LinkedHashMap<String, Route> routes = xmlRouteReader.readRoutesFromXml(filePath);
    }
}

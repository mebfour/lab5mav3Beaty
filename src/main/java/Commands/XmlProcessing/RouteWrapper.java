package Commands.XmlProcessing;

import MyClasses.Route;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.LinkedHashMap;

import static Service.CollectionManager.routeList;

@XmlRootElement(name = "routes") // Указываем, что это корневой элемент XML
public class RouteWrapper {
    private LinkedHashMap<String, Route> routeMap = routeList;

    // Конструктор по умолчанию (обязателен для JAXB)
    public RouteWrapper() {}

    // Конструктор с параметрами
    public RouteWrapper(LinkedHashMap<String, Route> routeMap) {
        this.routeMap = routeMap;
    }

    // Геттер и сеттер для коллекции
    @XmlElement(name = "route") // Указываем имя элемента в XML
    public LinkedHashMap<String, Route> getRouteMap() {
        return routeMap;
    }

    public void setRouteMap(LinkedHashMap<String, Route> routeMap) {
        this.routeMap = routeMap;
    }
}

package Commands.XmlProcessing;

import MyClasses.Route;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.LinkedHashMap;

public class XmlRouteReader {

    public static LinkedHashMap<String, Route> readRoutesFromXml (){
        String filePath = "src\\main\\java\\files\\file.xml";
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            // Создаем JAXB контекст
            JAXBContext context = JAXBContext.newInstance(RouteWrapper.class);

            // Создаем Unmarshaller
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Читаем XML через BufferedInputStream
            RouteWrapper wrapper = (RouteWrapper) unmarshaller.unmarshal(bis);

            return wrapper.getRouteMap() != null ?
                    new LinkedHashMap<>(wrapper.getRouteMap()) :
                    new LinkedHashMap<>();

        } catch (Exception e) {
            System.err.println("Ошибка при чтении XML: " + e.getMessage());
            return new LinkedHashMap<>();
        }
    }

}

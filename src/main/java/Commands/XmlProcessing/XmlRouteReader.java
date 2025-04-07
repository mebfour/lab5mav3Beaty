package Commands.XmlProcessing;

import MyClasses.Route;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

import static Service.CollectionManager.globalFilePath;

public class XmlRouteReader {

    public static LinkedHashMap<String, Route> readRoutesFromXml (String filePath){
        if (filePath == null || filePath.isEmpty()) {

            filePath = "file.xml"; // значение по умолчанию
        }
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Файл не найден");
            filePath = "file.xml";
        }
        if (!file.canRead()) {
            System.out.println("Нет прав на чтение файла");
            filePath = "file.xml";
        }

        // Проверка расширения файла (опционально)
        if (!filePath.toLowerCase().endsWith(".xml")) {
            System.out.println("Файл должен иметь расширение .xml");
            filePath = "file.xml";
        }
        InputStreamReader isr = null;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             // Создаем JAXB контекст
             JAXBContext context = JAXBContext.newInstance(RouteWrapper.class);

             // Создаем Unmarshaller
             Unmarshaller unmarshaller = context.createUnmarshaller();

             // Читаем XML через BufferedInputStream
             RouteWrapper wrapper = (RouteWrapper) unmarshaller.unmarshal(isr);

            return wrapper.getRouteMap() != null ?
                    new LinkedHashMap<>(wrapper.getRouteMap()) :
                    new LinkedHashMap<>();
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка");
            return readDefaultFile();
        } catch (IOException ex) {
            System.out.println("Ошибка ввода-вывода");
            return readDefaultFile();
        } catch (JAXBException ex) {
            System.out.println("Ошибка парсинга в Xml");
            return readDefaultFile();
        }
    }
    private static LinkedHashMap<String, Route> readDefaultFile() {
        try {
            File defaultFile = new File("file.xml");
            if (defaultFile.exists()) {
                try (InputStream is = new FileInputStream(defaultFile)) {
                    JAXBContext context = JAXBContext.newInstance(RouteWrapper.class);
                    Unmarshaller unmarshaller = context.createUnmarshaller();
                    RouteWrapper wrapper = (RouteWrapper) unmarshaller.unmarshal(is);
                    return wrapper.getRouteMap() != null ?
                            new LinkedHashMap<>(wrapper.getRouteMap()) :
                            new LinkedHashMap<>();
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла по умолчанию");
        }
        return new LinkedHashMap<>(); // Возвращаем пустую коллекцию
    }
}

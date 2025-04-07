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
        }
        if (!file.canRead()) {
            System.out.println("Нет прав на чтение файла");
        }

        // Проверка расширения файла (опционально)
        if (!filePath.toLowerCase().endsWith(".xml")) {
            System.out.println("Файл должен иметь расширение .xml");
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
        } catch (IOException ex) {
            System.out.println("Ошибка ввода-вывода");
        } catch (JAXBException ex) {
            System.out.println("Ошибка парсинга в Xml");
        }
        return null;
    }

}

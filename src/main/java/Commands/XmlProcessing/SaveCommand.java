package Commands.XmlProcessing;

import Commands.Command;
import MyClasses.Route;
import Service.CollectionManager;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;

import static Service.CollectionManager.*;

public class SaveCommand implements Command {
    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        LinkedHashMap<String, Route> routeMap = routeList;
        String filePath = globalFilePath;

        try {
            // Создаём обёртку для коллекции
            RouteWrapper wrapper = new RouteWrapper(routeMap);
            wrapper.setInitializationTime(CollectionManager.getInitializationTime());

            // Создаём контекст JAXB
            JAXBContext context = JAXBContext.newInstance(RouteWrapper.class);

            // Создаём Marshaller
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Проверяем и создаём директорию, если её нет
            File file = new File(filePath);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            // Удаляем существующий файл, если он есть
            if (file.exists()) {
                file.delete();
            }

            // Создаём новый файл
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + filePath);
            } else {
                System.out.println("Файл уже существует, но был удалён и создан заново.");
            }

            // Используем FileOutputStream для записи XML
            try (OutputStream os = new FileOutputStream(file)) {
                marshaller.marshal(wrapper, os);
                System.out.println("Коллекция успешно сохранена в файл: " + filePath);
            }

        } catch (JAXBException | IOException e) {
            System.out.println("Ошибка сохранения в файл.");

        }
        return null;
    }

    @Override
    public String getDescription() {
        return "сохраняет коллекцию в файл";
    }
}
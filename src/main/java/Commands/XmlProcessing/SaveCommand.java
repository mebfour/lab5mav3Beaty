package Commands.XmlProcessing;

import Commands.Command;
import MyClasses.Route;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import static Service.CollectionManager.globalFilePath;
import static Service.CollectionManager.routeList;

/**
 * JAXB использует аннотации, поэтому работать с ним легко и просто. Чтобы сохранить Java объект в XML файл,
 * мы должны проставить необходимые JAXB аннотации в классе и методах класса, а затем
 * создать объект Marshaller для сохранения объекта в XML.
 *
 * Также есть специальный класс JAXBContext, который является точкой входа для JAXB и предоставляет методы
 * для сохранения/восстановления объекта.
 */



public class SaveCommand implements Command {
    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        LinkedHashMap<String, Route> routeMap = routeList;
        String filePath = globalFilePath;

        try {
            // Создаём обёртку для коллекции
            RouteWrapper wrapper = new RouteWrapper(routeMap);

            // Создаём контекст JAXB
            JAXBContext context = JAXBContext.newInstance(RouteWrapper.class);

            // Создаём Marshaller
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Форматируем XML

            // Проверяем, существует ли директория
            File file = new File(filePath);

            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs(); // Создаём директорию, если её нет
            }

            if (file.exists()) {
                file.delete(); // Удаляем существующий файл
            }
            // Создаём новый файл
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + filePath);
            } else {
                System.out.println("Файл уже существует, но был удалён и создан заново.");
            }

            // Сохраняем коллекцию в XML-файл
            marshaller.marshal(wrapper, file);

            System.out.println("Коллекция успешно сохранена в файл: " + filePath);
        } catch (JAXBException | IOException e) {
            System.out.println("Ошибка сохранения в файл.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getDescription() {
        return "сохраняет коллекцию в файл";
    }
}

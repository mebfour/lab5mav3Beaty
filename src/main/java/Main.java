

import InputHandler.Instructions;
import MyClasses.Route;
import Service.CollectionManager;
import Service.DataProcessor;

import java.util.LinkedHashMap;

import static Commands.XmlProcessing.XmlRouteReader.readRoutesFromXml;
import static Service.CollectionManager.globalFilePath;


public class Main {

    public static void main(String[] args) {
        String filePath;
        if (args.length > 0) {
             filePath= args[0];
        }else {
            filePath = "file.xml";
        }
        CollectionManager.init(filePath);
        Instructions.greeting(globalFilePath);
        DataProcessor dataProcessor = new DataProcessor();
        dataProcessor.processData(globalFilePath);
    }


}

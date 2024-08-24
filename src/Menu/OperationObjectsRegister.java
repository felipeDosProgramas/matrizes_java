package Menu;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class OperationObjectsRegister {
    private final int operationId = ((int) log.get("operationsLastInsertedId")) + 1;
    private final Date operatedAt = Date.from(Instant.now());
    private final HashSet<String> usedObjectsNames = new HashSet<>();
    private static final HashSet<OperationObjectsRegister> operationObjectsRegisterInstance = new HashSet<>();
    static JSONObject log;

    private static String getLogFileContents(){
        var file = new StringBuilder();
        var scanner = new Scanner("../Log.json");
        while (scanner.hasNextLine())
            file.append(scanner.nextLine()).append(System.lineSeparator());
        return file.toString();
    }
    private static void parseJsonContents(String fileContents){
        try {
            log = (JSONObject) new JSONParser().parse(fileContents);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static OperationObjectsRegister getOperationObjectsRegisterInstance() {
        OperationObjectsRegister operation = new OperationObjectsRegister();
        operationObjectsRegisterInstance.add(operation);
        return operation;
    }

    public void setUsedObjectName(String objectName){
        usedObjectsNames.add(objectName);
    }

    public void dispatchOperationDataOnLogFile(){
        try(var writer = new BufferedWriter(new FileWriter("../Log.json"))) {
            writer.write(log.toJSONString());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

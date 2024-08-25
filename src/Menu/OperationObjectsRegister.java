package Menu;

import LogsManager.LOG;
import LogsManager.LogsLocationHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Stack;

class OperationObjectsRegister {
    protected static final Stack<OperationIdentifier> operationIdentifiersStack = new Stack<>();

    private static Object parseJsonContents(String fileContents)
    {
        try {
            return new JSONParser().parse(fileContents);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("unchecked")
    protected static long getNewOperationId(){
        long lastInsertedId;
        JSONObject operationsIdentifierLog = (JSONObject) parseJsonContents(
                LogsLocationHandler.readFromLog(LOG.OPERATIONS_IDENTIFIERS)
        );
        operationsIdentifierLog.put(
                "lastInsertedId",
                lastInsertedId = 1 + (long) operationsIdentifierLog.get("lastInsertedId")
        );
        LogsLocationHandler.writeOnLog(
                operationsIdentifierLog.toJSONString(),
                LOG.OPERATIONS_IDENTIFIERS
        );
        return lastInsertedId;
    }
    @SuppressWarnings("unchecked")
    public static void  addOperatedObjectsToLogInstance(){
        JSONObject operationsLog = (JSONObject) parseJsonContents(
                LogsLocationHandler.readFromLog(LOG.OPERATIONS)
        );

        var operationsArray = (JSONArray) operationsLog.get("executedOperations");

        operationsArray.addAll(
                operationIdentifiersStack.stream()
                        .map(OperationIdentifier::getOperationData)
                        .toList()
        );

        operationsLog.put("executedOperations", operationsArray);

        LogsLocationHandler.writeOnLog(
                operationsLog.toJSONString(),
                LOG.OPERATIONS
        );
    }
}

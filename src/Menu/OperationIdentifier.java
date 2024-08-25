package Menu;

import java.time.Instant;
import java.util.Date;
import java.util.Stack;

public class OperationIdentifier {
    private final long operationId;
    private final Date operatedAt;
    private final Stack<String> usedObjectsNames;

    public OperationIdentifier(long operationId){
        this.operationId = operationId;
        this.usedObjectsNames = new Stack<>();
        this.operatedAt = Date.from(Instant.now());
    }

    public void setUsedObjectName(String objectName){
        if (!usedObjectsNames.contains(objectName))
            usedObjectsNames.add(objectName);
    }
    public String getOperationData(){
        return  " ID: " + operationId +
                " Operated At: " + operatedAt +
                " Objects used: " + getUsedObjectsNames();
    }
    public String getOperationData(String separator){
        return  "ID: " + operationId + separator +
                "Operated At: " + operatedAt + separator +
                "Objects used: " + getUsedObjectsNames() + separator;
    }

    private String getUsedObjectsNames(){
        return usedObjectsNames.stream().reduce((p, a) -> p + ", " + a).orElseThrow();
    }
}

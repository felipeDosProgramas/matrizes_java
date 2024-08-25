package Menu;

public class OperationsIdentifiersManager extends OperationObjectsRegister{

    public static OperationIdentifier getOperationIdentifierInstance() {
        var operation = new OperationIdentifier(
                getNewOperationId()
        );
        operationIdentifiersStack.add(operation);
        return operation;
    }
}

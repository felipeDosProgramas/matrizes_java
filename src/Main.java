import Menu.*;
import Records.Matrix;

public class Main {

    public static void main(String[] args) {
        do {
            executeOperation(
                    OperationsIdentifiersManager.getOperationIdentifierInstance(),
                    OperationChooser.getInstance()
            );
            OperationsIdentifiersManager.addOperatedObjectsToLogInstance();
            System.out.println("Type 0 to quit, any other number to continue.");
        }
        while (OperationChooser.scanner.nextInt() != 0);
    }

    private static void executeOperation(OperationIdentifier operationIdentifier, OperationChooser operationChooserInstance){
        ArgumentsInstancesRepository.setOperationIdentifier(operationIdentifier);
        new OperationCaller(operationChooserInstance)
            .execute(
                OperationChooser.chooseOperation()
            )
            .ifPresent(
                matrix -> printOperationExit(operationIdentifier, matrix)
            );
    }

    private static void printOperationExit(OperationIdentifier operationIdentifier, Matrix operationResult){
        System.out.println(
                operationIdentifier.getOperationData( "\n")
        );
        System.out.println(
                operationResult
        );
    }
}

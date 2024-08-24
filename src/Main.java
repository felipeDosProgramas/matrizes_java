import Menu.OperationCaller;
import Menu.OperationChooser;
import Records.Matrix;

import java.lang.reflect.Method;
import java.util.Optional;

public class Main {
    public static void executeOperation(){
        Method operationToExecute = OperationChooser.chooseOperation();
        OperationCaller operationCallerInstance = new OperationCaller(
                OperationChooser.getInstance()
        );
        Optional<Matrix> operationResult = operationCallerInstance.execute(operationToExecute);
        if (operationResult.isEmpty())
            return;
        System.out.println(operationResult.get());
    }
    public static void main(String[] args) {
        do {
            executeOperation();
            System.out.println("Type 0 to quit, any other number to continue.");
        }
        while (OperationChooser.scanner.nextInt() != 0);
    }
}

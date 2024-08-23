import Menu.OperationCaller;
import Menu.OperationsChooser;
import Records.Matrix;

import java.lang.reflect.Method;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Method operationToExecute = OperationsChooser.chooseOperation();
        OperationCaller operationCallerInstance = new OperationCaller(
                OperationsChooser.getInstance()
        );
        Optional<Matrix> operationResult = operationCallerInstance.execute(operationToExecute);
        if (operationResult.isEmpty())
            return;
        System.out.println(operationResult.get());
    }
}

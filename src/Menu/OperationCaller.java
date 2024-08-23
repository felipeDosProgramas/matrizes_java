package Menu;

import Records.Matrix;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OperationCaller {
    private final OperationsChooser operationsChooser;

    public OperationCaller(OperationsChooser operationsChooser) {
        this.operationsChooser = operationsChooser;
    }

    private Matrix invokeMethod(Method method)
            throws InvocationTargetException, IllegalAccessException, NoSuchElementException
    {
        return (Matrix) method.invoke(null,
                operationsChooser
                        .getProperArgumentsInstances(method)
                        .orElseThrow()
        );
    }
    private boolean invokeMethodWithoutReturn(Method method)
            throws InvocationTargetException, IllegalAccessException, NoSuchElementException
    {
        if (method.getReturnType() == Matrix.class)
            return false;
        method.invoke(null,
            operationsChooser
                    .getProperArgumentsInstances(method)
                    .orElseThrow()
        );
        return true;
    }
    public Optional<Matrix> execute(Method method){
        try {
            if(invokeMethodWithoutReturn(method))
                return Optional.empty();
            return Optional.of(
                    invokeMethod(method)
            );
        } catch (IllegalAccessException | InvocationTargetException | NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }
}

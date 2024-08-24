package Menu;

import Records.Matrix;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OperationCaller {
    private final OperationChooser operationChooser;

    public OperationCaller(OperationChooser operationChooser) {
        this.operationChooser = operationChooser;
    }

    private Matrix invokeMethod(Method method)
            throws InvocationTargetException, IllegalAccessException, NoSuchElementException
    {
        return (Matrix) method.invoke(null,
                operationChooser
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
            operationChooser.getProperArgumentsInstances(method)
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

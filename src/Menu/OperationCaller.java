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
        return (Matrix) method.invoke(
                null,
                operationChooser.getProperArgumentsInstances(method)
        );
    }

    /**
     * Calls by reflection the following method:
     * @authentication_with_scanner {@link MatrixOperations.Authentication#execute(java.util.Scanner)} method
     */
    private boolean invokeMethodWithoutReturn(Method method)
            throws InvocationTargetException, IllegalAccessException, NoSuchElementException
    {
        if (method.getReturnType() == Matrix.class)
            return false;
        method.invoke(
                null,
                operationChooser.getProperArgumentsInstances(method)
        );
        return true;
    }

    /**
     * Calls by reflection the following methods:
     * @matrices_sum {@link MatrixOperations.Sum#sumMatrices(Matrix, Matrix)}
     * @matrices_transposition {@link MatrixOperations.Transposition#revert(Matrix)}
     * @multiplication_of_matrix_by_scalar {@link MatrixOperations.Multiplication.MatrixByScalar#matrixByScalar(Matrix, double)}
     * @multiplication_of_matrix_by_matrix {@link MatrixOperations.Multiplication.MatrixByMatrix#matrixByMatrix(Matrix, Matrix)}
     */
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

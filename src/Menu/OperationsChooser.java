package Menu;

import Interfaces.Operation;
import MatrixOperations.*;
import MatrixOperations.Multiplication.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Predicate;

public class OperationsChooser {
    public static final Scanner scanner = new Scanner(System.in);
    private static OperationsChooser selfInstance = null;

    public List<Class<? extends Operation>> operations = List.of(
            Authentication.class,
            Sum.class,
            Transposition.class,
            MatrixByScalar.class,
            MatrixByMatrix.class
    );
    public static OperationsChooser getInstance(){
        if (selfInstance == null)
            selfInstance = new OperationsChooser();
        return selfInstance;
    }
    private Class<? extends Operation> getOperationToExecute(){
        System.out.println("choose a number between 0 and 4");
        try
            { return operations.get(scanner.nextInt()); }
        catch (IndexOutOfBoundsException _)
            { return getOperationToExecute(); }
    }

    public Optional<Object[]> getProperArgumentsInstances(Method method){
        Class<?>[] parameterTypes = method.getParameterTypes();
        return ArgumentsInstancesRepository.getArgumentsInstancesByTypeClass(
                parameterTypes
        );
    }

    public Method getEntryPointMethodFromOperation(Class<? extends Operation> chosenOperation){
        Predicate<? super Method> isMethodPublicAndStatic = m ->
                Modifier.isStatic(m.getModifiers()) &&
                Modifier.isPublic(m.getModifiers());
        return Arrays.stream(chosenOperation.getDeclaredMethods())
                .filter(isMethodPublicAndStatic)
                .findFirst().orElseThrow();
    }

    public static Method chooseOperation(){
        OperationsChooser operationsChooserInstance = getInstance();
        return operationsChooserInstance.getEntryPointMethodFromOperation(
                operationsChooserInstance.getOperationToExecute()
        );
    }
}

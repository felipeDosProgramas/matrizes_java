package Menu;

import Interfaces.Operation;
import MatrixOperations.*;
import MatrixOperations.Multiplication.*;

import java.lang.reflect.InvocationTargetException;
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

    private Class<? extends Operation> getOperationToExecute(){
        System.out.println("choose a number between 0 and 4");
        try
        { return operations.get(scanner.nextInt()); }
        catch (IndexOutOfBoundsException _)
        { return getOperationToExecute(); }
    }

    public Optional<Object[]> getProperArgumentsInstances(Method method){
        Class<?>[] parameterTypes = method.getParameterTypes();
        return ArgumentsHashMap.getArgumentsInstancesByTypeClass(
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

    public static void chooseOperation(){
        if (selfInstance == null)
            selfInstance = new OperationsChooser();
        Method method = selfInstance.getEntryPointMethodFromOperation(
                selfInstance.getOperationToExecute()
        );
        try {
            method.invoke(null, selfInstance.getProperArgumentsInstances(method).orElseThrow());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }
}

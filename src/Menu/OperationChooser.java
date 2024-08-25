package Menu;

import Interfaces.Operation;
import MatrixOperations.*;
import MatrixOperations.Multiplication.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Predicate;

public class OperationChooser {
    public static final Scanner scanner = new Scanner(System.in);
    private static OperationChooser selfInstance = null;

    public List<Class<? extends Operation>> operations = List.of(
            Authentication.class,
            Sum.class,
            Transposition.class,
            MatrixByScalar.class,
            MatrixByMatrix.class
    );
    private OperationChooser(){}
    public static OperationChooser getInstance(){
        if (selfInstance == null)
            selfInstance = new OperationChooser();
        return selfInstance;
    }
    private void printMenu(){
        System.out.println("choose a number between 0 and 4");
        System.out.println("""
                0 - Authentication with username and password\s
                1 - Sum between two matrices\s
                2 - Matrix transposition\s
                3 - Product between a Matrix and a scalar\s
                4 - Product between two Matrices
        """);
    }
    private Class<? extends Operation> getOperationToExecute(){
        printMenu();
        try
            { return operations.get(scanner.nextInt()); }
        catch (IndexOutOfBoundsException _)
            { return getOperationToExecute(); }
    }

    public Object[] getProperArgumentsInstances(Method method){
        Class<?>[] parameterTypes = method.getParameterTypes();
        return ArgumentsInstancesRepository.getArgumentsInstancesByTypeClass(
                parameterTypes
        );
    }

    private Predicate<? super Method> isMethodPublicAndStatic(){
        return (method) -> Modifier.isStatic(method.getModifiers())
                && Modifier.isPublic(method.getModifiers());
    }

    /** The entry point method of an operation is the only public and static method. */
    public Method getEntryPointMethodFromOperation(Class<? extends Operation> chosenOperation){
        return Arrays.stream(chosenOperation.getDeclaredMethods())
                .filter(isMethodPublicAndStatic())
                .findFirst()
                .orElseThrow();
    }

    public static Method chooseOperation(){
        OperationChooser operationChooserInstance = getInstance();
        return operationChooserInstance.getEntryPointMethodFromOperation(
                operationChooserInstance.getOperationToExecute()
        );
    }
}

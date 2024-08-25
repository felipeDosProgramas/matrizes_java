package Menu;

import static toUseOnOperations.MatricesToUseOnTests.getCorrectMatrix1;

public class ArgumentsInstancesRepository {
    static private OperationIdentifier operationIdentifier;

    public static Object[] getArgumentsInstancesByTypeClass(Class<?>[] parametersClasses) {
        Object[] instances = new Object[parametersClasses.length];
        for (int i = 0; i < parametersClasses.length; i++)
            instances[i] = getInstanceByClassName(parametersClasses[i].getTypeName());
        return instances;
    }

    private static Object getInstanceByClassName(String typeName) {
        operationIdentifier.setUsedObjectName(typeName);
        return switch (typeName){
            case "Records.Matrix" -> getCorrectMatrix1();
            case "java.util.Scanner" -> OperationChooser.scanner;
            case "double" -> (double) 0;
            default -> null;
        };
    }

    public static void setOperationIdentifier(OperationIdentifier operationIdentifier) {
        ArgumentsInstancesRepository.operationIdentifier = operationIdentifier;
    }
}

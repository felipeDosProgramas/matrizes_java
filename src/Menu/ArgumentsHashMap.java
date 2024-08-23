package Menu;

import java.util.Optional;

import static Tests.resources.MatricesToUseOnTests.getCorrectMatrix1;

public class ArgumentsHashMap {

    public static Optional<Object[]> getArgumentsInstancesByTypeClass(Class<?>[] parametersClasses) {
        Object[] instances = new Object[parametersClasses.length];
        for (int i = 0; i < parametersClasses.length; i++) {
            instances[i] = getInstanceByClassName(parametersClasses[i].getTypeName());
        }
        return Optional.of(instances);
    }

    private static Object getInstanceByClassName(String typeName) {
        return switch (typeName){
            case "Records.Matrix" -> getCorrectMatrix1();
            case "java.util.Scanner" -> OperationsChooser.scanner;
            case "double" -> (double) 0;
            default -> null;
        };
    }
}

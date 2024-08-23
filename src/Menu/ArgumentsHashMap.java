package Menu;

import Records.Matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

import static Tests.resources.MatricesToUseOnTests.getCorrectMatrix1;

public class ArgumentsHashMap {
    private static final String doubleMatrixNames = "[Records.Matrix, Records.Matrix]";
    private static final String oneMatrixName = "[Records.Matrix]";
    private static final String oneScannerName = "[java.util.Scanner]";
    private static final String matrixAndDoubleNames = "[Records.Matrix, java.lang.Double]";

    private static final Matrix[] doubleMatrixInstances = new Matrix[]{ getCorrectMatrix1(), getCorrectMatrix1() };
    private static final Matrix[] oneMatrixInstance = new Matrix[] { getCorrectMatrix1() };
    private static final Scanner[] oneScannerInstance = new Scanner[]{ OperationsChooser.scanner };
    private static final Object[] matrixAndDoubleInstances = new Object[]{ getCorrectMatrix1(), (double) 0};

    private static final HashMap<String, Object[]> argumentsMap = new HashMap<>(5);
    static {
        argumentsMap.put(doubleMatrixNames, doubleMatrixInstances); // Sum, MatrixByMatrix
        argumentsMap.put(oneMatrixName, oneMatrixInstance); // Transposition
        argumentsMap.put(oneScannerName, oneScannerInstance); // Authentication
        argumentsMap.put(matrixAndDoubleNames, matrixAndDoubleInstances); // MatrixByScalar
    }
    public static Optional<Object[]> getArgumentsInstances(String[] parametersTypesNames) {
        System.out.println(Arrays.toString(parametersTypesNames));
        var instances = argumentsMap.get(Arrays.toString(parametersTypesNames));
        System.out.println(Arrays.toString(instances));
        return instances == null
                ? Optional.empty()
                : Optional.of(instances);
    }
}

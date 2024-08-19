package Tests.resources.toUseOnOperations;

import Records.Matrix;
import Tests.resources.MatricesToUseOnTests;

public class MatricesToUseOnMultiplication extends MatricesToUseOnTests {

    public static Matrix matrix1Times5 = new Matrix(new double[][]{
            {15, 17.5, 20},
            {17, 18, 25},
            {25, 27, 28}
    });
    public static Matrix matrix1TimesMatrix2 = new Matrix(new double[][]{
            {40.9,44.7,58.4},
            {47.44,51.86,66.6},
            {61.36,67.18,88.76}
    });
}

package Tests.resources;

import Records.Matrix;

public class MatricesToUseOnTests {
    public static Matrix correctMatrix1 = new Matrix(new double[][]{
            {3, 3.5, 4},
            {3.4, 3.6, 5},
            {5, 5.4, 5.6}
    });
    public static Matrix correctMatrix2 = new Matrix(new double[][]{
            {3, 3.5, 5},
            {3.4, 3.6, 6},
            {5, 5.4, 7}
    });
    public static Matrix matrixWithWrongInternalLengths = new Matrix(new double[][]{
            {6, 7, 9},
            {6.8, 7.2},
            {10, 1., 11.2}
    });
}

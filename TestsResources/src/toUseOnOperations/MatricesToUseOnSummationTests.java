package toUseOnOperations;

import Records.Matrix;

public class MatricesToUseOnSummationTests extends MatricesToUseOnTests {
    public static Matrix expectedSumOfMatrix1ByItself = new Matrix(new double[][]{
            {6, 7, 8},
            {6.8, 7.2, 10},
            {10, 10.8, 11.2}
    });
    public static Matrix correctMatrix3ThatIsNotTheSumOfMatrices1And2 = new Matrix(new double[][]{
            {6, 7, 9},
            {6.8, 7.2, 43},
            {10, 1., 11.2}
    });
}

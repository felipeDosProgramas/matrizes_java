package Tests.MatrixOperations;

import MatrixOperations.Sum;
import Records.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumTest {
    static Matrix matrix1ToTest = new Matrix(new double[][]{
            {3, 3.5, 4},
            {3.4, 3.6, 5},
            {5, 5.4, 5.6}
    });
    static Matrix matrix2ToTest = new Matrix(new double[][]{
            {3, 3.5, 4},
            {3.4, 3.6, 5},
            {5, 5.4, 5.6}
    });
    @Test
    public void testSumBothMatrices(){
        Matrix result = Sum.sumMatrices(matrix1ToTest, matrix2ToTest);
        Matrix expectedMatrix = new Matrix(new double[][]{
                {6, 7, 8},
                {6.8, 7.2, 10},
                {10, 10.8, 11.2}
        });
        Assertions.assertEquals(expectedMatrix, result);
    }
}

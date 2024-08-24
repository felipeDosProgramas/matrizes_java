package Tests.MatrixOperations;

import MatrixOperations.Multiplication.MatrixByMatrix;
import MatrixOperations.Multiplication.MatrixByScalar;
import Records.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Tests.resources.toUseOnOperations.MatricesToUseOnMultiplication.*;

public class MatrixMultiplicationTest {

    @Test
    public void testMultiplicationBtwMatrixAndScalar(){
        Assertions.assertEquals(
                matrix1Times5,
                MatrixByScalar.matrixByScalar(
                        getCorrectMatrix1(),
                        5
                )
        );
    }
    @Test
    public void testMultiplicationBtw2Matrices(){
        Assertions.assertEquals(
                matrix1TimesMatrix2,
                MatrixByMatrix.matrixByMatrix(
                        getCorrectMatrix1(),
                        correctMatrix2
                )
        );
    }
    @Test
    public void testWrongMultiplicationBtwMatrixAndScalar(){
        Assertions.assertNotEquals(
                matrix1Times5,
                MatrixByScalar.matrixByScalar(
                        new Matrix(getCorrectMatrix1().rows().clone()),
                        4
                )
        );
    }
    @Test
    public void testWrongMultiplicationBtw2Matrices(){
        Assertions.assertNotEquals(
                matrix1TimesMatrix2,
                MatrixByMatrix.matrixByMatrix(
                        getCorrectMatrix1(),
                        getCorrectMatrix1()
                )
        );
    }
}

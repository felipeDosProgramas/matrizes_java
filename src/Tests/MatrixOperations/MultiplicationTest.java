package Tests.MatrixOperations;

import MatrixOperations.Multiplication;
import Records.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Tests.resources.toUseOnOperations.MatricesToUseOnMultiplication.*;

public class MultiplicationTest {

    @Test
    public void testMultiplicationBtwMatrixAndScalar(){
        Assertions.assertEquals(
                matrix1Times5,
                Multiplication.MatrixByScalar(
                        getCorrectMatrix1(),
                        5
                )
        );
    }
    @Test
    public void testMultiplicationBtw2Matrices(){
        Assertions.assertEquals(
                matrix1TimesMatrix2,
                Multiplication.MatrixByMatrix(
                        getCorrectMatrix1(),
                        correctMatrix2
                )
        );
    }
    @Test
    public void testWrongMultiplicationBtwMatrixAndScalar(){
        Assertions.assertNotEquals(
                matrix1Times5,
                Multiplication.MatrixByScalar(
                        new Matrix(getCorrectMatrix1().rows().clone()),
                        4
                )
        );
    }
    @Test
    public void testWrongMultiplicationBtw2Matrices(){
        Assertions.assertNotEquals(
                matrix1TimesMatrix2,
                Multiplication.MatrixByMatrix(
                        getCorrectMatrix1(),
                        getCorrectMatrix1()
                )
        );
    }
}

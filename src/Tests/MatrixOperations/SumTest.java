package Tests.MatrixOperations;

import MatrixOperations.Sum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Tests.resources.toUseOnOperations.MatricesToUseOnSumationTests.*;

public class SumTest {

    @Test
    public void testSumBothMatrices() throws Exception
    {
        Assertions.assertEquals(
                expectedSumOfMatrices1ByItself,
                Sum.sumMatrices(
                        correctMatrix1,
                        correctMatrix1
                )
        );
    }
    @Test
    public void testSumWrongBothMatrices() throws Exception
    {
        Assertions.assertNotEquals(
                correctMatrix3ThatIsntTheSumOfMatrices1And2,
            Sum.sumMatrices(
                correctMatrix1,
                correctMatrix2
            )
        );
    }
    @Test
    public void testThrowsExceptionWhenTryToSumMatricesWithDifferentInternalLengths()
    {
        Assertions.assertThrows(
            Exception.class,
            () -> Sum.sumMatrices(
                correctMatrix1,
                matrixWithWrongInternalLengths
            )
        );
    }
}

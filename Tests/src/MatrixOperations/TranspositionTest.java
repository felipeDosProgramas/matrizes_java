package MatrixOperations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static toUseOnOperations.MatricesToUseOnTests.correctMatrix2;
import static toUseOnOperations.MatricesToUseOnTests.getCorrectMatrix1;
import static toUseOnOperations.MatricesToUseOnTranspositionTests.transposedMatrix1;

public class TranspositionTest {

    @Test
    public void testCorrectTransposition(){
        Assertions.assertEquals(
            transposedMatrix1,
            Transposition.revert(
                    getCorrectMatrix1()
            )
        );
    }
    @Test
    public void testIncorrectTransposition(){
        Assertions.assertNotEquals(
            transposedMatrix1,
            Transposition.revert(
                correctMatrix2
            )
        );
    }
}

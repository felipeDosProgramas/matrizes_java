package Tests.MatrixOperations;

import MatrixOperations.Transposition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Tests.resources.toUseOnOperations.MatricesToUseOnTranspositionTests.*;

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

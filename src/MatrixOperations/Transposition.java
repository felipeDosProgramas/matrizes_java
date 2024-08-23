package MatrixOperations;

import Interfaces.Operation;
import Records.Matrix;

public class Transposition implements Operation
{
    public static Matrix revert(Matrix matrix){
        var transposedMatrix = new Matrix(new double[matrix.rows().length][matrix.rows()[0].length]);
        for (int i = 0; i < matrix.rows().length; i++)
            for (int j = 0; j < matrix.rows()[i].length; j++)
                transposedMatrix.rows()[i][j] = matrix.rows()[j][i];
        return transposedMatrix;
    }
}

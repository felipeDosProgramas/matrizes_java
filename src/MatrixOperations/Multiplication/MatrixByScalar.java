package MatrixOperations.Multiplication;

import Interfaces.Operation;
import Records.Matrix;


public class MatrixByScalar implements Operation {

    public static Matrix matrixByScalar(Matrix matrix, double scalar){
        var newMatrix = new double[matrix.rows().length][matrix.rows()[0].length];
        for (int i = 0; i < matrix.rows().length; i++)
            for (int j = 0; j < matrix.rows()[i].length; j++) {
                newMatrix[i][j] = matrix.rows()[i][j] * scalar;
            }
        return new Matrix(newMatrix);
    }
}

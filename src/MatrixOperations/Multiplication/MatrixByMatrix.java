package MatrixOperations.Multiplication;

import Interfaces.Operation;
import Records.Matrix;

import java.util.Arrays;

public class MatrixByMatrix implements Operation {
    private static double getOperationsToDo(double[] row, double[] column){
        var multiplications = new double[row.length];
        for (int i = 0; i < row.length; i++)
            multiplications[i] = row[i] * column[i];
        return Arrays.stream(multiplications.clone()).sum();
    }
    public static Matrix matrixByMatrix(Matrix matrix1, Matrix matrix2){
        var newMatrix = new Matrix(new double[matrix1.rows().length][matrix2.rows()[0].length]);
        for (int i = 0; i < matrix1.rows().length; i++)
            for (int j = 0; j < matrix2.rows()[i].length; j++)
                newMatrix.rows()[i][j] = getOperationsToDo(matrix1.rows()[i], matrix2.column(j));
        return newMatrix;
    }
}

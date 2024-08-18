package MatrixOperations;

import Records.Matrix;

import java.util.Arrays;

public class Multiplication {

    private static double multiplyRowByColumn(double[] row, double[] column){
        return multiply(row) + multiply(column);
    }

    private static double multiply (double[] list) {
        return Arrays.stream(list).reduce((p, a) -> p * a).orElseThrow();
    }

    public static Matrix MatrixByScalar(Matrix matrix, double scalar){
        for (int i = 0; i < matrix.rows().length; i++)
            for (int j = 0; j < matrix.rows()[i].length; j++)
                matrix.rows()[i][j] *= scalar;
        return matrix;
    }
    public static Matrix MatrixByMatrix(Matrix matrix1, Matrix matrix2){
        var newMatrix = new double[matrix1.rows().length][matrix2.rows()[0].length];
        for (int i = 0; i < matrix1.rows().length; i++)
            for (int j = 0; j < matrix2.rows()[i].length; j++)
                newMatrix[i][j] = multiplyRowByColumn(matrix1.rows()[i], matrix2.rows()[j]);
        return new Matrix(newMatrix);
    }
}

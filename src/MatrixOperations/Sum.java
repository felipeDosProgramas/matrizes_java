package MatrixOperations;

import Records.Matrix;

public class Sum {

    static double[] sumRow(double[] row1, double[] row2){
        double[] resultantRow = new double[3];
        for (int i = 0; i < 3; i++)
            resultantRow[i] = row1[i] + row2[i];
        return resultantRow;
    }

    public static Matrix sumMatrices(Matrix matrix1, Matrix matrix2){
        var resultantMatrix = new double[3][3];
        for (int i = 0; i < 3; i++)
            resultantMatrix[i] = sumRow(matrix1.rows()[i], matrix2.rows()[i]);
        return new Matrix(resultantMatrix);
    }
}

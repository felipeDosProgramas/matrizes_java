package MatrixOperations;

import Interfaces.Operation;
import Records.Matrix;

public class Sum implements Operation {

    static double[] sumRows(double[] row1, double[] row2){
        double[] resultantRow = new double[3];
        for (int i = 0; i < 3; i++)
            resultantRow[i] = row1[i] + row2[i];
        return resultantRow;
    }
    static boolean bothMatricesHasSameInternalLengths(Matrix matrix1, Matrix matrix2){
        if (matrix1.rows().length != matrix2.rows().length)
            return false;
        for (int i = 0; i < matrix1.rows().length; i++)
            if (matrix1.rows()[i].length != matrix2.rows()[i].length)
                return false;
        return true;
    }
    public static Matrix sumMatrices(Matrix matrix1, Matrix matrix2) throws Exception {
        if (!bothMatricesHasSameInternalLengths(matrix1, matrix2))
            throw new Exception("matrices with different internal lengths");
        var resultantMatrix = new Matrix(new double[matrix1.rows().length][matrix1.rows()[0].length]);
        for (int i = 0; i < matrix1.rows().length; i++)
            resultantMatrix.rows()[i] = sumRows(matrix1.rows()[i], matrix2.rows()[i]);
        return resultantMatrix;
    }
}

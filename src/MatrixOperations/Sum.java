package MatrixOperations;

public class Sum {

    static double[] sumRow(double[] row1, double[] row2){
        double[] resultantRow = new double[3];
        for (int i = 0; i < 3; i++)
            resultantRow[i] = row1[i] + row2[2];
        return resultantRow;
    }

    static double[][] sumMatrices(double[][] matrix1, double[][] matrix2){
        var resultantMatrix = new double[3][3];
        for (int i = 0; i < 3; i++)
            resultantMatrix[i] = sumRow(matrix1[i], matrix2[i]);
        return resultantMatrix;
    }
}

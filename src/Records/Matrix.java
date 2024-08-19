package Records;


import java.util.Arrays;

public record Matrix(
        double[][] rows
) {
    public double[] column(int columnIndex){
        var column = new double[rows().length];
        for (int i = 0; i < rows().length; i++)
            column[i] = rows()[i][columnIndex];
        return column;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Matrix))
            return false;
        return bothMatricesGotSameNumbers(
                (Matrix) obj
        );
    }

    private boolean bothMatricesGotSameNumbers(Matrix obj) {
        for (int i = 0; i < this.rows().length; i++)
            for (int j = 0; j < this.rows()[i].length; j++)
                if (this.rows[i][j] != obj.rows()[i][j])
                    return false;
        return true;
    }

    private String getConcatenatedRow(StringBuilder stringBuilder, double[] rowToConcat){
        stringBuilder.append("{ ");
        for (double v : rowToConcat)
            stringBuilder
                    .append(v)
                    .append(", ");
        return stringBuilder
                .deleteCharAt(stringBuilder.length() - 2)
                .append("}, ")
                .toString();
    }
    @Override
    public String toString() {
        var rowsToHandle = rows().clone();
        var stringedRows = new String[rowsToHandle.length];
        for (int i = 0; i < rowsToHandle.length; i++)
            stringedRows[i] = getConcatenatedRow(new StringBuilder(), rowsToHandle[i]);
        return "Matrix{" +
                Arrays.stream(stringedRows).reduce(String::concat).orElseThrow() +
                '}';
    }

}

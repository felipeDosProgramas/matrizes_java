package Records;


import java.util.Arrays;

public record Matrix(
        double[][] rows
) {
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Matrix))
            return false;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (this.rows[i][j] != ((Matrix) obj).rows()[i][j])
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
        var stringedRows = new String[rows().length];
        for (int i = 0; i < rows().length; i++)
            stringedRows[i] = getConcatenatedRow(new StringBuilder(), rows()[i]);
        return "Matrix{" +
                Arrays.stream(stringedRows).reduce(String::concat).orElseThrow() +
                '}';
    }
}

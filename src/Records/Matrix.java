package Records;


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
}

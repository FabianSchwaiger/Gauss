public class Gauss {
    public static double[][] gaussSolve(double[][] matrix) {
        for(int row = 0; row < matrix.length; row++) {
            startRowWith1(matrix, row, row);
            subRowToOthersBelow(matrix, row, row);
        }

        for(int row = matrix.length-1; row > 0; row--) {
            subRowToOthersAbove(matrix, row, row);
        }

        return matrix;
    }

    /**
     * makes the current row of the given matrix start wit a 1 (divide row by value)
     *
     * TODO only possible, if startColumn starts with != 0, automatic row/column swaps could be implemented to support more matrices
     *
     * @param matrix
     * @param row
     * @param startColumn
     * @return
     */
    private static double[][] startRowWith1(double[][] matrix, int row, int startColumn) {
        double divisor = matrix[row][startColumn];
        for(int i = startColumn; i < matrix[row].length; i++) {
            matrix[row][i] /= divisor;
        }
        return matrix;
    }

    private static double[][] subRowToOthersBelow(double[][] matrix, int row, int startColumn) {
        double mult = 0;

        for(int j = row+1; j < matrix.length; j++) {
            mult = matrix[j][startColumn];
            for(int i = startColumn; i < matrix[row].length; i++) {
                matrix[j][i] = matrix[j][i] - (mult * matrix[row][i]);
            }
        }

        return matrix;
    }

    private static double[][] subRowToOthersAbove(double[][] matrix, int row, int startColumn) {
        double mult = 0;

        for(int j = 0; j < row; j++) {
            mult = matrix[j][startColumn];
            for(int i = startColumn; i < matrix[row].length; i++) {
                matrix[j][i] = matrix[j][i] - (mult * matrix[row][i]);
            }
        }

        return matrix;
    }
}

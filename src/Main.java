import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[][] matrix;

        // 53
        /*
        matrix = new double[][] {{10, 7, 8, 7, 32},
                                 {7, 5, 6, 5, 23},
                                 {8, 6, 10, 9, 33},
                                 {7, 5, 9, 10, 31}};
        */

        // 54
        /*
        matrix = new double[][] {{10, 7, 8, 7, 32.1},
                                 {7, 5, 6, 5, 22.9},
                                 {8, 6, 10, 9, 33.1},
                                 {7, 5, 9, 10, 30.9}};
        */

        // 55

        matrix = new double[][] {{10, 7, 8.1, 7.2, 32},
                                 {7.08, 5.04, 6, 5, 23},
                                 {8, 5.98, 9.89, 9, 33},
                                 {6.99, 4.99, 9, 9.98, 31}};

        matrix = gaussSolve(matrix);

        for(double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

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

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws  Exception {
        int matrixToSolve = 53;

        double[][] matrix;

        switch (matrixToSolve) {
            case 53: {
                matrix = new double[][] {{10, 7, 8, 7, 32},
                        {7, 5, 6, 5, 23},
                        {8, 6, 10, 9, 33},
                        {7, 5, 9, 10, 31}};
                break;
            }
            case 54: {
                matrix = new double[][] {{10, 7, 8, 7, 32.1},
                        {7, 5, 6, 5, 22.9},
                        {8, 6, 10, 9, 33.1},
                        {7, 5, 9, 10, 30.9}};
                break;
            }
            case 55: {
                matrix = new double[][] {{10, 7, 8.1, 7.2, 32},
                        {7.08, 5.04, 6, 5, 23},
                        {8, 5.98, 9.89, 9, 33},
                        {6.99, 4.99, 9, 9.98, 31}};
                break;
            }
            default: {
                throw new Exception("example " + matrixToSolve + " not supported!");
            }
        }


        matrix = Gauss.gaussSolve(matrix);

        printMatrix(matrix);

    }

    public static void printMatrix(double[][] matrix) {
        for(double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }


}

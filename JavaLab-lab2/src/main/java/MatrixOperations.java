import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 100;
    private static final int MAX_SIZE = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = getMatrixSize(scanner, "ширину");
        int height = getMatrixSize(scanner, "висоту");

        if (width == -1 || height == -1) return;

        int[][] matrix = new int[height][width];
        if (!fillMatrix(matrix, scanner)) return;

        printMatrix(matrix);
        System.out.println("Мінімальний елемент: " + findMin(matrix));
        System.out.println("Максимальний елемент: " + findMax(matrix));
        System.out.println("Середнє арифметичне: " + calculateAverage(matrix));
        System.out.println("Середнє геометричне: " + calculateGeometricMean(matrix));
    }

    private static int getMatrixSize(Scanner scanner, String dimension) {
        System.out.printf("Введіть %s матриці (не більше %d): ", dimension, MAX_SIZE);
        int size = scanner.nextInt();
        if (size > MAX_SIZE) {
            System.out.println("Розмір не може перевищувати " + MAX_SIZE);
            return -1;
        }
        return size;
    }

    private static boolean fillMatrix(int[][] matrix, Scanner scanner) {
        System.out.print("Виберіть спосіб створення матриці (1 - вручну, 2 - рандомно): ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            fillMatrixManually(matrix, scanner);
        } else if (choice == 2) {
            fillMatrixRandomly(matrix);
        } else {
            System.out.println("Невірний вибір.");
            return false;
        }
        return true;
    }

    private static void fillMatrixManually(int[][] matrix, Scanner scanner) {
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void fillMatrixRandomly(int[][] matrix) {
        Random random = new Random();
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                row[j] = MIN_RANDOM + random.nextInt(MAX_RANDOM - MIN_RANDOM + 1);
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int element : row) {
                min = Math.min(min, element);
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int element : row) {
                max = Math.max(max, element);
            }
        }
        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0, count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }
        return count == 0 ? 0 : (double) sum / count;
    }

    private static double calculateGeometricMean(int[][] matrix) {
        double product = 1.0;
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element == 0) return 0;
                product *= element;
                count++;
            }
        }
        return count == 0 ? 0 : Math.pow(product, 1.0 / count);
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số hàng (m): ");
        int rows = sc.nextInt();
        System.out.print("Nhập số cột (n): ");
        int cols = sc.nextInt();

        double[][] matrix = new double[rows][cols];

        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = sc.nextDouble();
            }
        }

        double maxValue = matrix[0][0];
        int rowMax = 0;
        int colMax = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                    rowMax = i;
                    colMax = j;
                }
            }
        }

        System.out.println("\nMa trận vừa nhập:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nGiá trị lớn nhất là: " + maxValue);
        System.out.println("Vị trí (tọa độ): dòng " + rowMax + ", cột " + colMax);

    }
}
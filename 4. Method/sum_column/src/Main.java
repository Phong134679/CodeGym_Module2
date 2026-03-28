import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.print("Nhập số hàng: ");
        int rows = sc.nextInt();
        System.out.print("Nhập số cột: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Tạo số ngẫu nhiên từ 0 đến 100
                matrix[i][j] = rd.nextInt(101);
            }
        }

        System.out.println("\nMảng 2 chiều:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("\nNhập số thứ tự cột cần tính tổng (0 đến " + (cols - 1) + "): ");
        int colIndex = sc.nextInt();

        if (colIndex < 0 || colIndex >= cols) {
            System.out.println("Vị trí cột không hợp lệ!");
        } else {
            double sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += matrix[i][colIndex];
            }
            System.out.println("Tổng của cột " + colIndex + " là: " + sum);
        }

        sc.close();
    }
}
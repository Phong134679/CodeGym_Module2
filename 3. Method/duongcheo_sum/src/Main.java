import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.print("Nhập size mảng: ");
        int rows = sc.nextInt();

        int[][] matrix = new int[rows][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                // Tạo số ngẫu nhiên từ 0 đến 100
                matrix[i][j] = rd.nextInt(101);
            }
        }
        System.out.println("\nMảng 2 chiều:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += matrix[i][i];
        }
        System.out.println("Tổng giá trị trên đường chéo chính: " + sum);
        sc.close();
    }
}
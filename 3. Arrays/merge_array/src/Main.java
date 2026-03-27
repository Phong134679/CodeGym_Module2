import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập kích thước mảng 1: ");
        int n1 = sc.nextInt();
        int[] array1 = new int[n1];

        System.out.print("Nhập kích thước mảng 2: ");
        int n2 = sc.nextInt();
        int[] array2 = new int[n2];

        System.out.println("Nhập phần tử cho mảng 1:");
        for (int i = 0; i < n1; i++) {
            System.out.print("array1[" + i + "] = ");
            array1[i] = sc.nextInt();
        }

        System.out.println("Nhập phần tử cho mảng 2:");
        for (int i = 0; i < n2; i++) {
            System.out.print("array2[" + i + "] = ");
            array2[i] = sc.nextInt();
        }

        int[] array3 = new int[n1 + n2];

        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }

        for (int i = 0; i < array2.length; i++) {
            array3[array1.length + i] = array2[i];
        }

        System.out.print("Mảng sau khi gộp: ");
        for (int i : array3) {
            System.out.print(i + " ");
        }
    }
}
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }

        System.out.println("\nMang ban dau: " + Arrays.toString(arr));

        insertionSort(arr);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            System.out.println("Buoc " + i + ": Dang xet phan tu key = " + key);

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

            System.out.println("Ket qua sau buoc " + i + ": " + Arrays.toString(arr));
            System.out.println();
        }

        System.out.println("Mang sau khi sap xep: " + Arrays.toString(arr));
    }
}
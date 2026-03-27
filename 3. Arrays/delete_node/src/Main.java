import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        int n = array.length;

        System.out.print("Mảng hiện tại: ");
        inMang(array);

        System.out.print("Nhập phần tử X cần xoá: ");
        int x = sc.nextInt();

        int index_del = -1;

        for (int i = 0; i < n; i++) {
            if (array[i] == x) {
                index_del = i;
                for (int j = index_del; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[n - 1] = 0;
                i--;
            }
        }

        if (index_del == -1) {
            System.out.println("Phần tử " + x + " không tồn tại trong mảng.");
        }

        System.out.print("Mảng sau khi xoá: ");
        inMang(array);

        sc.close();
    }

    public static void inMang(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
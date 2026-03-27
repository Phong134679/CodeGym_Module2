import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = {10, 20, 30, 40, 50, 0, 0};
        int n = array.length;

        System.out.print("Nhập giá trị cần thêm (V): ");
        int v = sc.nextInt();
        System.out.print("Nhập vị trí cần chèn (index): ");
        int index_add = sc.nextInt();

        // Biến temp giữ giá trị cần chèn ban đầu
        int temp = v;

        for (int i = index_add; i < n; i++) {
            // Tráo đổi giá trị đang cầm trên tay (temp) với giá trị trong mảng
            int currentVal = array[i];
            array[i] = temp;
            temp = currentVal;
        }

        System.out.print("Mảng sau khi thêm: ");
        for (int i : array) System.out.print(i + " ");

        sc.close();
    }
}
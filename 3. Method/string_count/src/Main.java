import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "java programming language";

        System.out.print("Nhập một ký tự: ");
        char c = sc.next().charAt(0);

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        System.out.println("Chuỗi gốc: " + str);
        System.out.println("Số lần ký tự '" + c + "' xuất hiện là: " + count);

        sc.close();
    }
}
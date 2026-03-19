import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rate = 23000;

        System.out.print("Enter USD amount: ");
        double usd = scanner.nextDouble();

        double vnd = usd * rate;

        System.out.println("Value in VND: " + vnd + "vnd");
    }
}
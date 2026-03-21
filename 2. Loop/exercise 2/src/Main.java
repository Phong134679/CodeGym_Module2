
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        int count = 0;
        int num = 2;

        while (count < 20) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
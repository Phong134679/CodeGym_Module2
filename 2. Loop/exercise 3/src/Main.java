
public class Main {
    public static void main(String[] args) {
        int count = 0;

        for(int num = 2; count < 100; ++num) {
            if (isPrime(num) && num < 100) {
                System.out.print(num + " ");
                ++count;
            }
        }

    }

    public static boolean isPrime(int n) {
        for(int i = 2; (double)i <= Math.sqrt((double)n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

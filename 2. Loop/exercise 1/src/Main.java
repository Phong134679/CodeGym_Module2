import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("1. Rectengle\n" + "2. Triangle Bottum left\n" +"3. Triangle Top left\n");
        System.out.println("Input your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        int length = 5;
        int width = 4;

        switch(choice) {
            case 1:
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < length; y++) {
                        System.out.println("*");
                        System.out.println(" ");
                    }
                    System.out.println("\n");
                }
            case 2:
                for (int i = 1; i <= length; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }

            case 3:
                for (int i = length; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
        }
    }
}
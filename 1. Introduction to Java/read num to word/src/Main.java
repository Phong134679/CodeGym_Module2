import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input your number: ");
        int number;
        while (true) {
            if(scan.hasNextInt()) {
                number = scan.nextInt();
                break;
            } else {
                System.out.println("error");
                scan.next();
            }
        }
        switch (number) {
            case 0: System.out.println("zero"); break;
            case 1: System.out.println("one"); break;
            case 2: System.out.println("two"); break;
            case 3: System.out.println("three"); break;
            case 4: System.out.println("four"); break;
            case 5: System.out.println("five"); break;
            case 6: System.out.println("six"); break;
            case 7: System.out.println("seven"); break;
            case 8: System.out.println("eight"); break;
            case 9: System.out.println("nine"); break;
        }

        if (number >= 10 && number < 20) {
            int ones = number % 10;
            switch (ones) {
                case 0: System.out.println("ten"); break;
                case 1: System.out.println("eleven"); break;
                case 2: System.out.println("twelve"); break;
                case 3: System.out.println("thirteen"); break;
                case 4: System.out.println("fourteen"); break;
                case 5: System.out.println("fifteen"); break;
                case 6: System.out.println("sixteen"); break;
                case 7: System.out.println("seventeen"); break;
                case 8: System.out.println("eighteen"); break;
                case 9: System.out.println("nineteen"); break;
            }
        }

        if (number >= 20 && number < 1000) {
            String ones_number = "", tens_number = "", hundred_number = "";

            int h_digit = number / 100;
            int t_digit = (number % 100) / 10;
            int o_digit = number % 10;

            switch (h_digit) {
                case 1: hundred_number = "one hundred"; break;
                case 2: hundred_number = "two hundred"; break;
                case 3: hundred_number = "three hundred"; break;
                case 4: hundred_number = "four hundred"; break;
                case 5: hundred_number = "five hundred"; break;
                case 6: hundred_number = "six hundred"; break;
                case 7: hundred_number = "seven hundred"; break;
                case 8: hundred_number = "eight hundred"; break;
                case 9: hundred_number = "nine hundred"; break;
                default: hundred_number = ""; break;
            }

            switch (t_digit) {
                case 2: tens_number = "twenty"; break;
                case 3: tens_number = "thirty"; break;
                case 4: tens_number = "forty"; break;
                case 5: tens_number = "fifty"; break;
                case 6: tens_number = "sixty"; break;
                case 7: tens_number = "seventy"; break;
                case 8: tens_number = "eighty"; break;
                case 9: tens_number = "ninety"; break;
                default: tens_number = ""; break;
            }

            switch (o_digit) {
                case 1: ones_number = "one"; break;
                case 2: ones_number = "two"; break;
                case 3: ones_number = "three"; break;
                case 4: ones_number = "four"; break;
                case 5: ones_number = "five"; break;
                case 6: ones_number = "six"; break;
                case 7: ones_number = "seven"; break;
                case 8: ones_number = "eight"; break;
                case 9: ones_number = "nine"; break;
                default: ones_number = ""; break;
            }
            String result = hundred_number + " " + "and" + " " + tens_number + " " + ones_number;

            System.out.println(result);
        }


    }
}
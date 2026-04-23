import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        pushToStack(input, stack);
        printStack(stack);

        sc.close();
    }

    public static void pushToStack(String str, Stack<Character> stack) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
    }

    public static void printStack(Stack<Character> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
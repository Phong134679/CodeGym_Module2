import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }

        sc.close();
    }
}
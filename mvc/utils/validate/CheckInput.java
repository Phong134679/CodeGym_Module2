package mvc.utils.validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CheckInput {
    private static Scanner sc = new Scanner(System.in);

    public static int checkInt(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ.");
            }
        }
    }

    public static double checkDouble(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ.");
            }
        }
    }

    public static String checkString(String mess) {
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Lỗi: Dữ liệu không được để trống.");
        }
    }

    public static String checkRegex(String mess, String regex, String errorMsg) {
        while (true) {
            String input = checkString(mess);
            if (input.matches(regex)) {
                return input;
            }
            System.out.println("Lỗi: " + errorMsg);
        }
    }

    public static String checkDate(String mess) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            String dateStr = checkString(mess);
            try {
                LocalDate.parse(dateStr, formatter);
                return dateStr;
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: Ngày không đúng định dạng dd/MM/yyyy.");
            }
        }
    }

    public static boolean isValidDateRange(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        return !start.isAfter(end);
    }

    public static boolean checkYesNo(String mess) {
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("có") || input.equals("co") || input.equals("y") || input.equals("yes")) return true;
            if (input.equals("không") || input.equals("khong") || input.equals("n") || input.equals("no")) return false;
            System.out.println("Lỗi: Vui lòng nhập Có/Không (Y/N).");
        }
    }
}
package View;

import Controller.CustomerController;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========= QUẢN LÝ KHÁCH HÀNG =========");
            System.out.println("1. Thêm khách hàng (Tạo Node mới)");
            System.out.println("2. Xóa khách hàng theo ID");
            System.out.println("3. In toàn bộ danh sách");
            System.out.println("4. Tìm theo tên");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            choice = sc.nextInt();
            sc.nextLine(); // Xử lý trôi lệnh (clear buffer) sau khi nhập số

            switch (choice) {
                case 1:
                    System.out.println("--- Nhập thông tin khách hàng ---");
                    System.out.print("Nhập ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập Họ tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập Ngày sinh: ");
                    String dob = sc.nextLine();
                    System.out.print("Nhập Địa chỉ: ");
                    String address = sc.nextLine();

                    // Gọi controller xử lý
                    controller.processAddCustomer(id, name, dob, address);
                    break;

                case 2:
                    System.out.print("Nhập ID cần xóa: ");
                    String idDel = sc.nextLine();
                    controller.processDeleteCustomer(idDel);
                    break;

                case 3:
                    System.out.println("--- Danh sách khách hàng hiện tại ---");
                    controller.displayAllCustomers();
                    break;

                case 4:
                    System.out.print("Nhập tên khách hàng cần tìm: ");
                    String searchName = sc.nextLine();
                    controller.processSearchByName(searchName);
                    break;

                case 0:
                    System.out.println("Đang thoát chương trình...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        } while (choice != 0);

        sc.close();
    }
}
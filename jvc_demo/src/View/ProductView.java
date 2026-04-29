package View;

import java.util.Scanner;
import Controller.ProductHandler;
public class ProductView {
    public static void main(String[] args) {
        ProductHandler handler = new ProductHandler();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ SẢN PHẨM =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xoá sản phẩm");
            System.out.println("4. Tìm kiếm theo tên");
            System.out.println("5. Sắp xếp và Hiển thị");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine(); // Chống trôi lệnh

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: "); String id = sc.nextLine();
                    System.out.print("Nhập tên: "); String name = sc.nextLine();
                    System.out.print("Nhập giá: "); double price = sc.nextDouble();
                    handler.handleAdd(id, name, price);
                    break;
                case 2:
                    System.out.print("Nhập ID cần sửa: "); String uId = sc.nextLine();
                    System.out.print("Tên mới: "); String uName = sc.nextLine();
                    System.out.print("Giá mới: "); double uPrice = sc.nextDouble();
                    handler.handleUpdate(uId, uName, uPrice);
                    break;
                case 3:
                    System.out.print("Nhập ID cần xoá: "); String dId = sc.nextLine();
                    handler.handleDelete(dId);
                    break;
                case 4:
                    System.out.print("Nhập tên tìm kiếm: "); String sName = sc.nextLine();
                    handler.handleSearch(sName);
                    break;
                case 5:
                    handler.handleSortAndDisplay();
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);

        sc.close();
    }
}
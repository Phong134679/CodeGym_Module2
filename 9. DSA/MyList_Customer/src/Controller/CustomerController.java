package Controller;

import Model.Entities.Customer;
import Model.Entities.MyArrayList;
import Model.Logic.CustomerManager;

public class CustomerController {
    // Controller vẫn giữ tham chiếu đến lớp Logic (Nghiệp vụ)
    private CustomerManager logicManager = new CustomerManager();

    // 1. Thêm khách hàng
    public void processAddCustomer(String id, String name, String dob, String address) {
        // Kiểm tra tính hợp lệ của tên thông qua Logic
        if (!logicManager.isValidName(name)) {
            System.out.println("Lỗi: Tên không hợp lệ (không được chứa số hoặc ký tự đặc biệt).");
            return;
        }

        // Chuẩn hóa tên trước khi tạo đối tượng Customer
        String cleanName = logicManager.normalizeName(name);
        Customer newCustomer = new Customer(id, cleanName, dob, address);

        // Đẩy trực tiếp đối tượng Customer vào danh sách trong Logic
        // Không còn bước tạo Node ở đây nữa
        logicManager.addNewCustomer(newCustomer);

        System.out.println("Hệ thống: Đã thêm khách hàng '" + cleanName + "' vào ArrayList thành công!");
    }

    // 2. Xóa khách hàng theo ID
    public void processDeleteCustomer(String id) {
        // Gọi hàm xóa của lớp nghiệp vụ
        boolean success = logicManager.deleteById(id);

        if (success) {
            System.out.println("Hệ thống: Đã xóa thành công khách hàng có ID: " + id);
        } else {
            System.out.println("Hệ thống: Không tìm thấy khách hàng có ID: " + id + " để xóa.");
        }
    }

    // 3. Hiển thị toàn bộ danh sách
    public void displayAllCustomers() {
        System.out.println("\n--- DANH SÁCH KHÁCH HÀNG (ARRAYLIST) ---");
        logicManager.printAll();
        System.out.println("----------------------------------------");
    }

    // 4. Tìm kiếm khách hàng theo tên
    public void processSearchByName(String inputName) {
        // Bước 1: Kiểm tra hợp lệ qua Logic
        if (!logicManager.isValidName(inputName)) {
            System.out.println("Lỗi: Tên nhập vào không hợp lệ.");
            return;
        }

        // Bước 2: Chuẩn hóa tên
        String tempName = logicManager.normalizeName(inputName);

        // Bước 3: Tìm kiếm đối tượng Customer (Không phải trả về Node)
        Customer result = logicManager.findByName(tempName);

        if (result != null) {
            System.out.println("Hệ thống: Tìm thấy khách hàng!");
            System.out.println(result.toString());
        } else {
            System.out.println("Hệ thống: Không tìm thấy khách hàng nào có tên: " + inputName);
        }
    }
}
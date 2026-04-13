package Controller;

import Model.Entities.Customer;
import Model.Entities.Node;
import Model.Logic.CustomerManager;

public class CustomerController {
    private CustomerManager logicManager = new CustomerManager();

    public void processAddCustomer(String id, String name, String dob, String address) {
        if (!logicManager.isValidName(name)) {
            System.out.println("Lỗi: Tên không hợp lệ (không được chứa số hoặc ký tự đặc biệt).");
            return;
        }

        // Gọi hàm chuẩn hóa trước khi truyền vào Customer
        String cleanName = logicManager.normalizeName(name);
        Customer newCustomer = new Customer(id, cleanName, dob, address);

        Node newNode = new Node(newCustomer);
        logicManager.addNodeToList(newNode);
        System.out.println("Hệ thống: Đã thêm khách hàng với tên chuẩn hóa: " + cleanName);
    }

    public void processDeleteCustomer(String id) {
        boolean success = logicManager.deleteNode(id);

        if (success) {
            System.out.println("Hệ thống: Đã xóa thành công khách hàng có ID: " + id);
        } else {
            System.out.println("Hệ thống: Không tìm thấy khách hàng có ID: " + id + " để xóa.");
        }
    }

    public void displayAllCustomers() {
        System.out.println("\n--- DANH SÁCH KHÁCH HÀNG HIỆN TẠI ---");
        logicManager.printList();
        System.out.println("-------------------------------------");
    }

    public void processSearchByName(String inputName) {
        // Bước 1: Kiểm tra hợp lệ
        if (!logicManager.isValidName(inputName)) {
            System.out.println("Lỗi: Tên nhập vào không hợp lệ.");
            return;
        }

        // Bước 2: Chuẩn hóa và lưu vào biến tạm
        String tempName = logicManager.normalizeName(inputName);

        // Bước 3: Truyền biến tạm vào hàm tìm kiếm ở Logic
        Node result = logicManager.findByName(tempName);

        if (result != null) {
            System.out.println("Hệ thống: Tìm thấy khách hàng!");
            System.out.println(result.data.toString());
        } else {
            System.out.println("Hệ thống: Không tìm thấy khách hàng nào có tên: " + inputName);
        }
    }
}
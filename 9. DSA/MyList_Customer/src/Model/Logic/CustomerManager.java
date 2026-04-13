package Model.Logic;

import Model.Entities.Customer;
import Model.Entities.MyArrayList; // Giả sử bạn để MyArrayList ở Entities hoặc Logic tùy ý

public class CustomerManager {
    // Sử dụng MyArrayList Generic để lưu trữ Customer
    private MyArrayList<Customer> customerList;

    public CustomerManager() {
        this.customerList = new MyArrayList<>();
    }

    // --- 1. Thao tác thêm ---
    public void addNewCustomer(Customer c) {
        if (c != null) {
            customerList.add(c);
        }
    }

    // --- 2. Thao tác xóa theo ID ---
    public boolean deleteById(String id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(id)) {
                customerList.remove(i);
                return true;
            }
        }
        return false;
    }

    // --- 3. Thao tác hiển thị ---
    public void printAll() {
        if (customerList.size() == 0) {
            System.out.println("Danh sách trống!");
            return;
        }
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(customerList.get(i).toString());
        }
    }

    // --- 4. Thao tác tìm kiếm theo tên (đã chuẩn hóa) ---
    public Customer findByName(String normalizedSearchName) {
        for (int i = 0; i < customerList.size(); i++) {
            // Chuẩn hóa tên của khách hàng trong danh sách trước khi so sánh
            String currentName = normalizeName(customerList.get(i).getName());
            if (currentName.equals(normalizedSearchName)) {
                return customerList.get(i);
            }
        }
        return null;
    }

    // --- 5. Hàm bổ trợ: Kiểm tra tính hợp lệ ---
    public boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        // Chấp nhận chữ cái, khoảng trắng và ký tự Tiếng Việt
        String pattern = "^[a-zA-Z\\s\\p{L}]+$";
        return name.matches(pattern);
    }

    // --- 6. Hàm bổ trợ: Chuẩn hóa tên ---
    public String normalizeName(String name) {
        if (name == null) return "";
        return name.trim().toLowerCase();
    }
}
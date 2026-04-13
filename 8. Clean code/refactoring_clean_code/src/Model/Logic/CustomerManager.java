package Model.Logic;
import Model.Entities.Node;


public class CustomerManager {
    private Node head;

    // Hàm thêm node vào danh sách (ví dụ thêm vào cuối)
    public void addNodeToList(Node newNode) {
        if (newNode == null) return;

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public boolean deleteNode(String id) {
        // Trường hợp 0: Danh sách trống
        if (head == null) {
            return false;
        }

        // Trường hợp 1: Node cần xóa nằm ở đầu (Head)
        if (head.data.getId().equals(id)) {
            head = head.next; // Chuyển head sang node tiếp theo
            return true;
        }

        // Trường hợp 2: Node cần xóa nằm ở giữa hoặc cuối
        Node temp = head;
        // Tìm node đứng trước node có ID cần xóa
        while (temp.next != null && !temp.next.data.getId().equals(id)) {
            temp = temp.next;
        }

        // Nếu tìm thấy node cần xóa (temp.next không null)
        if (temp.next != null) {
            // "Nhảy qua" node cần xóa bằng cách nối node hiện tại với node sau của node bị xóa
            temp.next = temp.next.next;
            return true;
        }

        // Không tìm thấy ID trong danh sách
        return false;
    }

    // Hàm in danh sách để kiểm tra (bổ sung thêm)
    public void printList() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Danh sách trống.");
            return;
        }
        while (temp != null) {
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }

    public boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        // Regex: Chỉ chấp nhận chữ cái và khoảng trắng (hỗ trợ Tiếng Việt cơ bản)
        String pattern = "^[a-zA-Z\\s\\p{L}]+$";
        return name.matches(pattern);
    }

    public String normalizeName(String name) {
        if (name == null) return "";
        // Loại bỏ khoảng trắng thừa ở 2 đầu và chuyển về chữ thường
        return name.trim().toLowerCase();
    }

    public Node findByName(String normalizedSearchName) {
        Node temp = head;
        while (temp != null) {
            // Chuẩn hóa tên trong node để so sánh tương đương
            String currentName = normalizeName(temp.data.getName());
            if (currentName.equals(normalizedSearchName)) {
                return temp; // Trả về node tìm thấy
            }
            temp = temp.next;
        }
        return null; // Không tìm thấy
    }
}


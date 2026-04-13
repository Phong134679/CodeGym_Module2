public class MyListTest {
    public static void main(String[] args) {
        // Tạo một danh sách các chuỗi (String)
        MyList<String> listString = new MyList<>();

        System.out.println("--- KIỂM TRA PHƯƠNG THỨC ADD ---");
        listString.add("Java");
        listString.add("Python");
        listString.add("C++");
        listString.add(1, "JavaScript"); // Chèn vào index 1

        for (int i = 0; i < listString.size(); i++) {
            System.out.println("Vị trí " + i + ": " + listString.get(i));
        }

        System.out.println("\n--- KIỂM TRA XÓA VÀ TÌM KIẾM ---");
        System.out.println("Đã xóa: " + listString.remove(2)); // Xóa Python
        System.out.println("Size hiện tại: " + listString.size());

        System.out.println("Danh sách có chứa 'Java' không? " + listString.contains("Java"));
        System.out.println("Vị trí của 'C++': " + listString.indexOf("C++"));

        System.out.println("\n--- KIỂM TRA CLEAR ---");
        listString.clear();
        System.out.println("Size sau khi clear: " + listString.size());
    }
}
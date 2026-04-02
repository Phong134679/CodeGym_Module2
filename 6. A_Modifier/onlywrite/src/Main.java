class Student {
    private String name = "Phong";
    private String classes = "codegym";

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void display() {
        System.out.println("Name: " + this.name + ", Classes: " + this.classes);
    }
}

public class Main {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Student
        Student student = new Student();

        // Hiển thị giá trị mặc định ban đầu
        System.out.print("Default status: ");
        student.display();

        // Truy cập và thay đổi giá trị thông qua phương thức setter
        student.setName("Alice");
        student.setClasses("C03");

        // Hiển thị giá trị sau khi thay đổi
        System.out.print("After using setters: ");
        student.display();
    }
}
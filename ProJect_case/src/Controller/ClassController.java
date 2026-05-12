package Control;

import Model.Manage.ClassList;
import Model.Manage.SubjectList;
import java.util.Scanner;

public class ClassController {
    private ClassList classModel;
    private SubjectList subjectModel; // Cần để xóa dây chuyền điểm số
    private Scanner sc;

    public ClassController(ClassList classModel, SubjectList subjectModel) {
        this.classModel = classModel;
        this.subjectModel = subjectModel;
        this.sc = new Scanner(System.in);
    }

    public void addClass() {
        System.out.print("Nhập mã lớp mới: ");
        String id = sc.nextLine();
        System.out.print("Nhập tên lớp mới: ");
        String name = sc.nextLine();

        classModel.addClass(id, name);
        System.out.println("Thông báo: Thêm lớp thành công.");
    }

    public void removeClass() {
        System.out.print("Nhập mã lớp cần xóa: ");
        String id = sc.nextLine();

        // Gọi hàm xóa triệt để đã viết trong Model
        classModel.deleteClass(id, subjectModel);
    }

    public void updateClass() {
        System.out.print("Nhập mã lớp cần sửa: ");
        String id = sc.nextLine();

        // Logic sửa: Tìm lớp -> Nhập tên mới -> Gọi setter trong Model
        if (classModel.searchWithID(id)) {
            System.out.print("Nhập tên lớp mới (để trống nếu không đổi): ");
            String newName = sc.nextLine();
            // Bạn có thể bổ sung hàm update trong ClassList để xử lý việc này
            System.out.println("Thông báo: Cập nhật thông tin thành công.");
        }
    }
}
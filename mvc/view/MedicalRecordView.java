package mvc.view;

import mvc.controller.MedicalRecordController;
import mvc.entity.MedicalRecord;
import mvc.entity.NormalRecord;
import mvc.entity.VIPRecord;
import mvc.utils.exception.DuplicateMedicalRecordException;
import mvc.utils.exception.NotFoundException;
import mvc.utils.validate.CheckInput;

import java.util.List;

public class MedicalRecordView {
    private static MedicalRecordController controller = new MedicalRecordController();

    public static void initialize() {
        controller.loadData();
    }

    public static void mainMenu() {
        while (true) {
            System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Xem danh sách các bệnh án");
            System.out.println("2. Thêm mới");
            System.out.println("3. Xóa");
            System.out.println("4. Thoát");
            int choice = CheckInput.checkInt("Nhập lựa chọn: ");

            switch (choice) {
                case 1:
                    displayRecords();
                    break;
                case 2:
                    addNewRecord();
                    break;
                case 3:
                    deleteRecord();
                    break;
                case 4:
                    System.out.println("Đã thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void displayRecords() {
        List<MedicalRecord> list = controller.getAll();
        if (list.isEmpty()) {
            System.out.println("Danh sách bệnh án hiện đang trống.");
            return;
        }
        System.out.println("--- DANH SÁCH BỆNH ÁN ---");
        for (MedicalRecord r : list) {
            System.out.println(r);
        }
    }

    private static void addNewRecord() {
        System.out.println("\n--- THÊM MỚI BỆNH ÁN ---");
        int stt = controller.getNextStt(); // STT tự động tăng
        System.out.println("Số thứ tự: " + stt);

        String recordCode;
        while (true) {
            recordCode = CheckInput.checkRegex("Nhập mã bệnh án (BA-XXX): ", "^BA-\\d{3}$", "Mã bệnh án phải đúng định dạng BA-XXX (X là số).");
            // Validate thủ công vòng lặp để catch Exception
            try {
                // Tạo một bản nháp rỗng để controller check duplicate
                controller.add(new NormalRecord(0, recordCode, "", "", "", "", "", 0));
                // Nếu vượt qua được add (không ném ra DuplicateException), chúng ta xóa nó đi vì đây chỉ là test
                controller.delete(recordCode);
                break;
            } catch (DuplicateMedicalRecordException e) {
                System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập mã khác.");
            } catch (NotFoundException ignored) {}
        }

        String patientCode = CheckInput.checkRegex("Nhập mã bệnh nhân (BN-XXX): ", "^BN-\\d{3}$", "Mã bệnh nhân phải đúng định dạng BN-XXX (X là số).");
        String patientName = CheckInput.checkString("Nhập tên bệnh nhân: ");

        String inDate, outDate;
        while (true) {
            inDate = CheckInput.checkDate("Nhập ngày nhập viện (dd/MM/yyyy): ");
            outDate = CheckInput.checkDate("Nhập ngày ra viện (dd/MM/yyyy): ");
            if (CheckInput.isValidDateRange(inDate, outDate)) {
                break;
            } else {
                System.out.println("Lỗi: Ngày nhập viện phải nhỏ hơn hoặc bằng ngày ra viện.");
            }
        }

        String reason = CheckInput.checkString("Nhập lý do nhập viện: ");

        int type = CheckInput.checkInt("Loại bệnh án (1 - Thường, 2 - VIP): ");
        try {
            if (type == 1) {
                double fee = CheckInput.checkDouble("Nhập phí nằm viện: ");
                controller.add(new NormalRecord(stt, recordCode, patientCode, patientName, inDate, outDate, reason, fee));
            } else {
                String vipType = CheckInput.checkRegex("Nhập loại VIP (VIP I, VIP II, VIP III): ", "^(VIP I|VIP II|VIP III)$", "Chỉ được chọn 1 trong 3 gói: VIP I, VIP II, VIP III.");
                String vipDuration = CheckInput.checkDate("Nhập thời hạn VIP (dd/MM/yyyy): ");
                controller.add(new VIPRecord(stt, recordCode, patientCode, patientName, inDate, outDate, reason, vipType, vipDuration));
            }
            System.out.println("Thêm mới bệnh án thành công!");
        } catch (DuplicateMedicalRecordException e) {
            System.out.println("Lỗi: Bệnh án đã tồn tại trong hệ thống.");
        }
    }

    private static void deleteRecord() {
        System.out.println("\n--- XÓA BỆNH ÁN ---");
        String recordCode = CheckInput.checkString("Nhập Mã bệnh án cần xóa: ");

        try {
            // Chỉ bắt NotFoundException từ service để xác nhận tồn tại
            boolean confirm = CheckInput.checkYesNo("Bạn có chắc chắn muốn xóa bệnh án này? (Có/Không): ");
            if (confirm) {
                controller.delete(recordCode);
                System.out.println("Đã xóa bệnh án thành công.");
                displayRecords(); // Hiển thị lại danh sách sau khi xóa
            } else {
                System.out.println("Đã hủy thao tác xóa.");
            }
        } catch (NotFoundException e) {
            System.out.println("Lỗi: Bệnh án không tồn tại.");
        }
    }
}
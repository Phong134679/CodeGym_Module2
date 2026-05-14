package mvc.service.impl;

import mvc.entity.MedicalRecord;
import mvc.entity.NormalRecord;
import mvc.entity.VIPRecord;
import mvc.repository.MedicalRecordRepository;
import mvc.utils.FileHelper.FileHelper;
import mvc.utils.exception.DuplicateMedicalRecordException;
import mvc.utils.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordService {
    private MedicalRecordRepository repo = new MedicalRecordRepository();
    private final String FILE_PATH = "data/medical_records.csv";

    public List<MedicalRecord> findAll() {
        return repo.findAll();
    }

    public void addRecord(MedicalRecord record) throws DuplicateMedicalRecordException {

        if (repo.findByRecordCode(record.getRecordCode()) != null) {
            throw new DuplicateMedicalRecordException("Bệnh án đã tồn tại.");
        }
        repo.add(record);
        saveToFile();
    }

    public void deleteRecord(String recordCode) throws NotFoundException {
        MedicalRecord target = repo.findByRecordCode(recordCode);
        if (target == null) {
            throw new NotFoundException("Bệnh án không tồn tại.");
        }
        repo.delete(target);
        saveToFile();
    }

    public int generateNextStt() {
        List<MedicalRecord> list = repo.findAll();
        if (list.isEmpty()) return 1;
        return list.get(list.size() - 1).getStt() + 1;
    }

    public void saveToFile() {
        List<String> lines = new ArrayList<>();
        lines.add("STT,Ma benh an,Ma benh nhan,Ten benh nhan,Ngay nhap vien,Ngay ra vien,Ly do nhap vien,Thong tin rieng,Thoi han VIP");

        for (MedicalRecord r : repo.findAll()) {
            lines.add(r.toCSVFormat());
        }

        FileHelper.writeToFile(FILE_PATH, lines);
    }

    public void loadFromFile() {
        repo.clearAll();
        List<String> lines = FileHelper.readFromFile(FILE_PATH);

        if (lines.size() <= 1) return;

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] p = line.split(",");

            if (p.length >= 8) {
                try {
                    int stt = Integer.parseInt(p[0].trim());
                    String recordCode = p[1].trim();
                    String patientCode = p[2].trim();
                    String patientName = p[3].trim();
                    String inDate = p[4].trim();
                    String outDate = p[5].trim();
                    String reason = p[6].trim();

                    if (p[7].contains("VIP")) {
                        String vipType = p[7].trim();
                        String vipDuration = (p.length >= 9) ? p[8].trim() : "N/A";
                        repo.add(new VIPRecord(stt, recordCode, patientCode, patientName, inDate, outDate, reason, vipType, vipDuration));
                    } else {
                        double fee = Double.parseDouble(p[7].trim());
                        repo.add(new NormalRecord(stt, recordCode, patientCode, patientName, inDate, outDate, reason, fee));
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi định dạng dữ liệu tại dòng " + (i + 1) + ": " + e.getMessage());
                }
            }
        }
    }
}
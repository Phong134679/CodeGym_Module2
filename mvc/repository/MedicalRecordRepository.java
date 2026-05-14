package mvc.repository;

import mvc.entity.MedicalRecord;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordRepository {
    private List<MedicalRecord> records = new ArrayList<>();

    public List<MedicalRecord> findAll() {
        return records;
    }

    public void add(MedicalRecord record) {
        records.add(record);
    }

    public void delete(MedicalRecord record) {
        records.remove(record);
    }

    public MedicalRecord findByRecordCode(String recordCode) {
        for (MedicalRecord r : records) {
            if (r.getRecordCode().equals(recordCode)) return r;
        }
        return null;
    }

    public void clearAll() {
        records.clear();
    }
}
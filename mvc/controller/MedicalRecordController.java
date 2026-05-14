package mvc.controller;

import mvc.entity.MedicalRecord;
import mvc.service.impl.MedicalRecordService;
import mvc.utils.exception.DuplicateMedicalRecordException;
import mvc.utils.exception.NotFoundException;
import java.util.List;

public class MedicalRecordController {
    private MedicalRecordService service = new MedicalRecordService();

    public void loadData() { service.loadFromFile(); }

    public List<MedicalRecord> getAll() { return service.findAll(); }

    public int getNextStt() { return service.generateNextStt(); }

    public void add(MedicalRecord record) throws DuplicateMedicalRecordException {
        service.addRecord(record);
    }

    public void delete(String recordCode) throws NotFoundException {
        service.deleteRecord(recordCode);
    }
}
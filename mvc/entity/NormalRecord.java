package mvc.entity;

public class NormalRecord extends MedicalRecord {
    private double fee; // Phí nằm viện

    public NormalRecord(int stt, String recordCode, String patientCode, String patientName,
                        String admissionDate, String dischargeDate, String reason, double fee) {
        super(stt, recordCode, patientCode, patientName, admissionDate, dischargeDate, reason);
        this.fee = fee;
    }

    @Override
    public String toCSVFormat() {
        return stt + "," + recordCode + "," + patientCode + "," + patientName + "," +
                admissionDate + "," + dischargeDate + "," + reason + "," + fee;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Phí: %-10.0f VNĐ |", fee);
    }
}
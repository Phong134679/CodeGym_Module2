package mvc.entity;

public abstract class MedicalRecord {
    protected int stt;
    protected String recordCode;
    protected String patientCode;
    protected String patientName;
    protected String admissionDate;
    protected String dischargeDate;
    protected String reason;

    public MedicalRecord(int stt, String recordCode, String patientCode, String patientName,
                         String admissionDate, String dischargeDate, String reason) {
        this.stt = stt;
        this.recordCode = recordCode;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.reason = reason;
    }

    public int getStt() { return stt; }
    public String getRecordCode() { return recordCode; }

    // Abstract method bắt buộc các lớp con phải ghi đè (override)
    public abstract String toCSVFormat();

    @Override
    public String toString() {
        return String.format("| %-4d | %-10s | %-10s | %-20s | %-12s | %-12s | %-25s |",
                stt, recordCode, patientCode, patientName, admissionDate, dischargeDate, reason);
    }
}
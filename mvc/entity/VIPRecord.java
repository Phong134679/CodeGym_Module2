package mvc.entity;

public class VIPRecord extends MedicalRecord {
    private String vipType;
    private String vipDuration;

    public VIPRecord(int stt, String recordCode, String patientCode, String patientName,
                     String admissionDate, String dischargeDate, String reason,
                     String vipType, String vipDuration) {
        super(stt, recordCode, patientCode, patientName, admissionDate, dischargeDate, reason);
        this.vipType = vipType;
        this.vipDuration = vipDuration;
    }

    @Override
    public String toCSVFormat() {
        return stt + "," + recordCode + "," + patientCode + "," + patientName + "," +
                admissionDate + "," + dischargeDate + "," + reason + "," + vipType + "," + vipDuration;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" VIP: %-7s | Hạn: %-12s |", vipType, vipDuration);
    }
}
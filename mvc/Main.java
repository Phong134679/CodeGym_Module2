package mvc;

import mvc.view.MedicalRecordView;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        MedicalRecordView.initialize();
        MedicalRecordView.mainMenu();
    }
}
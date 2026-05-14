import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName1 = "file1.txt";
        String fileName2 = "file2.txt";

        while (true) {
            System.out.println("1. Tao va ghi du lieu vao file");
            System.out.println("2. Copy du lieu sang file khac");
            System.out.println("3. Thoat");
            System.out.print("Chon: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                createAndWriteFile(fileName1, sc);
            } else if (choice == 2) {
                copyFile(fileName1, fileName2);
            } else if (choice == 3) {
                break;
            }
        }
        sc.close();
    }

    public static void createAndWriteFile(String fileName, Scanner sc) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("Da tao file: " + file.getName());
            }

            System.out.print("Nhap noi dung: ");
            String content = sc.nextLine();

            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("Da ghi du lieu thanh cong.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String sourcePath, String destPath) {
        try {
            File source = new File(sourcePath);
            File dest = new File(destPath);

            if (source.exists()) {
                Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Da copy du lieu tu " + sourcePath + " sang " + destPath);
            } else {
                System.out.println("File nguon khong ton tai!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
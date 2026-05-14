import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Country {
    int id;
    String code;
    String name;
    String test = "hihi";

    Country(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
    public String toCsvRow() {

        return id + "," + code + "," + name + "," + test;
    }
}

public class Main {
    public static void main(String[] args) {
        Country[] countries = {
                new Country(1, "AU", "Australia"),
                new Country(2, "CN", "China"),
                new Country(3, "JP", "Japan"),
                new Country(4, "TH", "Thailand")
        };

        String fileName = "contry.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Country c : countries) {
                bw.write(c.toCsvRow());
                bw.newLine();
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package Model.Entities;
import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> productList = new ArrayList<>();

    public void addProduct(Product p) {
        productList.add(p);
    }

    public void displayAll() {
        for (Product p : productList) {
            System.out.println(p.getId() + " - " + p.getName() + " - " + p.getPrice());
        }
    }

    public void searchByName(String name) {
        for (Product p : productList) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println(p.getId() + " - " + p.getPrice());
            }
        }
    }

    public void updateProduct(String id, String newName, double newPrice) {
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                p.setName(newName);
                p.setPrice(newPrice);
                return;
            }
        }
    }

    public void deleteProduct(String id) {
        productList.removeIf(p -> p.getId().equals(id));
    }

    public void bubbleSortByPrice() {
        int n = productList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (productList.get(j).getPrice() > productList.get(j + 1).getPrice()) {
                    Product temp = productList.get(j);
                    productList.set(j, productList.get(j + 1));
                    productList.set(j + 1, temp);
                }
            }
        }
    }
}
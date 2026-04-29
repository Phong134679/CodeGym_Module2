package Controller;

import java.util.Scanner;
import Model.Entities.ProductManager;
import Model.Entities.Product;

public class ProductHandler {
    private ProductManager manager = new ProductManager();

    public void handleAdd(String id, String name, double price) {
        Product p = new Product(id, name, price);
        manager.addProduct(p);
        System.out.println("Hệ thống: Đã lưu sản phẩm.");
    }

    public void handleUpdate(String id, String newName, double newPrice) {
        manager.updateProduct(id, newName, newPrice);
        System.out.println("Hệ thống: Đã cập nhật sản phẩm " + id);
    }

    public void handleDelete(String id) {
        manager.deleteProduct(id);
        System.out.println("Hệ thống: Đã thực hiện lệnh xoá.");
    }

    public void handleSearch(String name) {
        manager.searchByName(name);
    }

    public void handleSortAndDisplay() {
        manager.bubbleSortByPrice();
        manager.displayAll();
    }
}
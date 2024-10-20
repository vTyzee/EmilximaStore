package Handlers;

import model.Product;
import model.ProductCatalog;

import java.util.Scanner;

public class ProductHandler {
    private ProductCatalog catalog;
    public ProductHandler(ProductCatalog catalog){
        this.catalog = catalog;
    }
    public void addProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название продукта: ");
        String name = scanner.nextLine();

        System.out.print("Введите цену продукта: ");
        double price = scanner.nextDouble();

        System.out.print("Введите категорию продукта: ");
        scanner.nextLine();
        String category = scanner.nextLine();

        Product product = new Product(name, price, category);
    catalog.addProducts(product);

        System.out.println("Продукт добавлен: " + product);

    }
    public void removeProduct(String name){
        Product product = catalog.findProductByName(name);
        if (product != null){
           catalog.removeProduct(product);
            System.out.println("Продукст удален: " + product);
        }else {
            System.out.println("продукт не найден.");
        }
    }

    public void listProducts() {
    }
}

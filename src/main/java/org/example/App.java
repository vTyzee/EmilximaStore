package org.example; // Указываем, что класс находится в пакете org.example


import Handlers.ProductHandler;
import impl.ConsoleInput;
import model.Product;
import model.ProductCatalog;
import model.ShoppingCart;

public class App { // Объявляем класс App, который будет содержать основную логику

    private ProductHandler productHandler; // Обработчик продуктов
    private ShoppingCart cart; // Корзина покупок
    private ConsoleInput input; // Ввод с консоли
    private ProductCatalog catalog; // Каталог продуктов

    // Конструктор для инициализации всех объектов
    public App() {
        this.catalog = new ProductCatalog(); // Инициализируем каталог продуктов
        this.cart = new ShoppingCart(); // Инициализируем корзину покупок
        this.productHandler = new ProductHandler(catalog); // Инициализируем обработчик продуктов
        this.input = new ConsoleInput(); // Инициализируем ввод с консоли
    }

    // Основной метод для запуска программы
    public void run() {
        System.out.println("Добро пожаловать в магазин Emilxima!");

        boolean running = true; // Флаг для цикла работы программы
        while (running) { // Цикл, который будет работать до тех пор, пока running == true
            System.out.println("Выберите действие: ");
            System.out.println("1. Добавить продукт");
            System.out.println("2. Показать все продукты");
            System.out.println("3. Удалить продукт");
            System.out.println("4. Добавить продукт в корзину");
            System.out.println("5. Показать корзину");
            System.out.println("6. Выйти");

            String choice = input.getInput(); // Получаем выбор пользователя

            switch (choice) {
                case "1":
                    // Добавляем продукт
                    productHandler.addProduct();
                    break;
                case "2":
                    // Выводим все продукты
                    productHandler.listProducts();
                    break;
                case "3":
                    // Удаляем продукт по имени
                    System.out.print("Введите название продукта для удаления: ");
                    String nameToRemove = input.getInput();
                    productHandler.removeProduct(nameToRemove);
                    break;
                case "4":
                    // Добавляем продукт в корзину
                    System.out.print("Введите название продукта для добавления в корзину: ");
                    String nameToCart = input.getInput();
                    Product productToAdd = catalog.findProductByName(nameToCart);
                    if (productToAdd != null) {
                        cart.addItem(productToAdd);
                        System.out.println("Продукт добавлен в корзину: " + productToAdd);
                    } else {
                        System.out.println("Продукт не найден.");
                    }
                    break;
                case "5":
                    // Показать содержимое корзины
                    System.out.println("Содержимое корзины: ");
                    for (Product p : cart.getProducts()) {
                        System.out.println(p);
                    }
                    System.out.println("Общая сумма: " + cart.calculateTotal());
                    break;
                case "6":
                    // Завершить работу программы
                    System.out.println("До свидания!");
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
                    break;
            }
        }
    }
}

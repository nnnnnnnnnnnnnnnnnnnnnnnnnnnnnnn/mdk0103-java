package products;

public class Main {

    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 1, 0, 15, 80);
        Product banana = new Product("Банан", 1, 0, 23, 105);
        Product cake = new Product("Торт", 10, 29, 70, 2000);
        Product cheese = new Product("Сыр", 7, 25, 1, 400);
        Product chicken = new Product("Курица", 25, 10, 0, 250);

        MyProducts myProducts = new MyProducts(50, 30, 60, 1500);
        myProducts.addProduct(apple);
        myProducts.addProduct(banana);
        myProducts.addProduct(cake);
        myProducts.addProduct(cheese);
        myProducts.addProduct(chicken);
        myProducts.printProductNames();
    }
}

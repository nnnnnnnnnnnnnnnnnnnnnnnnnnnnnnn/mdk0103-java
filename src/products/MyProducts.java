package products;

import org.mockito.internal.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyProducts {
    private int maxProteins;
    private int maxFats;
    private int maxCarbs;
    private int maxCalories;
    private List<Product> products;

    public MyProducts(int maxProteins, int maxFats, int maxCarbs, int maxCalories) {
        setMaxProteins(maxProteins);
        setMaxFats(maxFats);
        setMaxCarbs(maxCarbs);
        setMaxCalories(maxCalories);
        products = new ArrayList<>();
    }

    public int getMaxProteins() {
        return maxProteins;
    }

    public void setMaxProteins(int maxProteins) {
        if (maxProteins < 0) {
            throw new IllegalArgumentException("Максимальное количество белков не может быть негативным значением");
        }
        this.maxProteins = maxProteins;
    }

    public int getMaxFats() {
        return maxFats;
    }

    public void setMaxFats(int maxFats) {
        if (maxFats < 0) {
            throw new IllegalArgumentException("Максимальное количество жиров не может быть негативным значением");
        }
        this.maxFats = maxFats;
    }

    public int getMaxCarbs() {
        return maxCarbs;
    }

    public void setMaxCarbs(int maxCarbs) {
        if (maxCarbs < 0) {
            throw new IllegalArgumentException("Максимальное количество углеводов не может быть негативным значением");
        }
        this.maxCarbs = maxCarbs;
    }

    public int getMaxCalories() {
        return maxCalories;
    }

    public void setMaxCalories(int maxCalories) {
        if (maxCalories < 0) {
            throw new IllegalArgumentException("Максимальное количество калорий не может быть негативным значением");
        }
        this.maxCalories = maxCalories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        String output = String.format("Невозможно добавить %s: превышен лимит ", product.getName());
        if (product.getProteins() > maxProteins) {
            output += "белков, ";
        }
        if (product.getFats() > maxFats) {
            output += "жиров, ";
        }
        if (product.getCarbs() > maxCarbs) {
            output += "углеводов, ";
        }
        if (product.getCalories() > maxCalories) {
            output += "калорий, ";
        }

        if (output.contains(",")) {
            System.out.println(output);
            System.out.println("djfvnkjdfndv");
        }
        else {
            products.add(product);
            System.out.println("Добавлен продукт: " + product.getName());
        }
    }

    public void printProductNames() {
        System.out.println(products.stream().map(Product::getName).collect(Collectors.joining(", ")));
    }
}

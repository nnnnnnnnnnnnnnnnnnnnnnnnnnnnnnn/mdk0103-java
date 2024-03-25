package products;

public class Product {
    private String name;
    private int proteins;
    private int fats;
    private int carbs;
    private int calories;

    // конструктор со всеми аргументами
    public Product(String name, int proteins, int fats, int carbs, int calories) {
        setName(name);
        setProteins(proteins);
        setFats(fats);
        setCarbs(carbs);
        setCalories(calories);
    }

    // конструктор с именем
    public Product(String name) {
        this(name, 0, 0, 0, 0);
    }

    // пустой конструктор
    public Product() {
        this("Какой-то продукт");
    }

    // конструктор с именем и калориями
    public Product(String name, int calories) {
        this(name, 0, 0, 0, calories);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не указано");
        }
        this.name = name;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        if (proteins < 0) {
            throw new IllegalArgumentException("Протеины не могут быть негативным значением");
        }
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        if (fats < 0) {
            throw new IllegalArgumentException("Жиры не могут быть негативным значением");
        }
        this.fats = fats;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        if (carbs < 0) {
            throw new IllegalArgumentException("Углеводы не могут быть негативным значением");
        }
        this.carbs = carbs;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        if (calories < 0) {
            throw new IllegalArgumentException("Калории не могут быть негативным значением");
        }
        this.calories = calories;
    }

    // override toString method to print product details
    @Override
    public String toString() {
        return getName();
    }
}

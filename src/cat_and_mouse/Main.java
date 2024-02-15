package cat_and_mouse;

/*
Задачу реализовать через ООП
Коты и мыши
Характеристики кота - имя, скорость, вес, пойманные выши
Характеристики мыши - скорость
Кот хранит информацию о пойманных мышах (максимум 10)
Кот ловит мышь только если его скорость выше, чем у мыши
Кот может напасть на другого кота и, если он больше по весу, то отобрать его мышей (если скорость мыши выше, чем скорость кота, то мышь убежит).
*/

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Рыжик", 15, 8);
        Cat cat2 = new Cat("Пушок", 12, 12);
        Cat cat3 = new Cat("Том", 18, 10);

        Mouse mouse1 = new Mouse(10);
        Mouse mouse2 = new Mouse(16);
        Mouse mouse3 = new Mouse(14);
        Mouse mouse4 = new Mouse(17);

        cat1.catchMouse(mouse1);
        cat1.catchMouse(mouse2);
        cat1.catchMouse(mouse3);
        cat1.showCaughtMice();

        cat2.fight(cat1);
        cat1.showCaughtMice();
        cat2.showCaughtMice();

        cat3.catchMouse(mouse4);
        cat3.fight(cat2);
    }
}
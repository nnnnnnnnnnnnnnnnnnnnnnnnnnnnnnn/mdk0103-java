package cat_and_mouse;

import java.util.ArrayList;
import java.util.List;

class Cat {
    private String name;
    private int speed;
    private int weight;
    private List<Mouse> caughtMice;

    public Cat(String name, int speed, int weight) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.caughtMice = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    public void catchMouse(Mouse mouse) {
        if (caughtMice.size() < 10) {
            System.out.printf("%s пытается поймать мышь со скоростью %s... ", name, mouse.getSpeed());
            if (speed > mouse.getSpeed()) {
                caughtMice.add(mouse);
                System.out.println(name + " поймал мышь.");
            } else {
                System.out.println("Мышь убежала от кота " + name);
            }
        }
        else {
            System.out.printf("У кота %s закончилось место для мышей\n", name);
        }
    }

    public void fight(Cat otherCat) {
        if (weight > otherCat.getWeight()) {
                System.out.println(name + " победил кота " + otherCat.getName());
            for (Mouse mouse : otherCat.caughtMice) {
                catchMouse(mouse);
            }
                otherCat.caughtMice.clear();
        } else {
            System.out.println(name + " проиграл коту " + otherCat.getName());
        }
    }

    public void showCaughtMice() {
        System.out.printf("%s поймал %s мышей\n", name, caughtMice.size());
    }
}

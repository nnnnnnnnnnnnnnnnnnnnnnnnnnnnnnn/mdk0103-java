package play;

import java.util.Random;

public class Unit {
    protected static Random rand = new Random();
    protected int health;
    public String name;

    public Unit(int health, String name) {
        this.health = health;
        this.name = name;
    }

    public int attack(Enemy enemy) {
        return -1;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }
}

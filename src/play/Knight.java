package play;

public class Knight extends Unit {
    public Knight() {
        super(120, "Рыцарь");
    }
    @Override
    public int attack(Enemy enemy) {
        int choice = rand.nextInt(3);
        int damage = 0;
        switch (choice) {
            case 0: damage += 10;
            case 1: damage += 5;
            case 2: damage += 15;
        }
        enemy.takeDamage(damage);
        return damage;
    }
}

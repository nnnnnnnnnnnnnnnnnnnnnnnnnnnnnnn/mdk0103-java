package play;

public class Soldier extends Unit {
    public Soldier() {
        super(70, "Пехотинец");
    }

    @Override
    public int attack(Enemy enemy) {
        int choice = rand.nextInt(2);
        int damage = 0;
        switch (choice) {
            case 0: damage += 5;
            case 1: damage += 10;
        }
        enemy.takeDamage(damage);
        return damage;
    }
}

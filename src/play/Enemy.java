package play;

public class Enemy {
    public int enemyType;
    private int health;
    private int healthDamage;
    private int goldDamage;

    public Enemy(int enemyType) {
        this.enemyType = enemyType;
        if (enemyType == 1) {
            this.health = 50;
            this.healthDamage = 5;
            this.goldDamage = 50;
        } else if (enemyType == 2) {
            this.health = 100;
            this.healthDamage = 10;
            this.goldDamage = 100;
        } else if (enemyType == 3) {
            this.health = 200;
            this.healthDamage = 50;
            this.goldDamage = 200;
        }
    }

    public void attack(King king) {
        king.army.get(0).takeDamage(healthDamage);
        king.decreaseGold(goldDamage);
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }
}


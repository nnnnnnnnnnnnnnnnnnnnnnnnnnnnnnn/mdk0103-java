package play;

import java.util.List;

public class King {
    private int health;
    private int gold;
    public List<Unit> army;

    public King(int health, int gold, List<Unit> army) {
        this.health = health;
        this.gold = gold;
        this.army = army;
        }


    public void decreaseGold(int amount) {
        gold += amount;
    }

    public int getGold() {
        return gold;
    }

}


package play;

/*
У короля есть очки здоровье и золото, а также армия, состоящая из рыцарей и пехотинцев.
У рыцарей и пехотинцев есть здоровье и различные виды атак (у рыцарей больше здоровья и атак).
Также есть три типа врагов, которые наносят урон.
    1 тип: урон – 5 очков,
    2 тип: урон – 10 очков и 50 монет,
    3 тип: урон – 50 очков и 100 монет.
Реализовать классы с полями, конструкторами и методами.
Создать класс Play с точкой входа, где будут создаваться объекты и пример игрового процесса.
*/


import java.util.ArrayList;
import java.util.List;

public class Play {
    public static void main(String[] args) {
        List<Unit> unitList = new ArrayList<Unit>();
        unitList.add(new Knight());
        unitList.add(new Soldier());
        unitList.add(new Soldier());
        unitList.add(new Knight());
        unitList.add(new Knight());
        unitList.add(new Soldier());
        unitList.add(new Knight());
        King king = new King(300, 1000, unitList);
        List<Enemy> enemyList = new ArrayList<>();
        enemyList.add(new Enemy(1));
        enemyList.add(new Enemy(2));
        enemyList.add(new Enemy(3));
        int damage = 0;
        while (king.army.size() > 0 && enemyList.size()>0) {
            damage = king.army.get(0).attack(enemyList.get(0));
            if (enemyList.get(0).isAlive()) {
                System.out.printf("%s ударил врага %s типа и выбил из него %s здоровья!\n",king.army.get(0).name,enemyList.get(0).enemyType,damage);
            }
            else {
                System.out.printf("%s убил врага %s типа, выбив из него %s здоровья!\n\n",king.army.get(0).name,enemyList.get(0).enemyType,damage);
                enemyList.remove(0);
                if (enemyList.size() == 0)
                {
                    System.out.println("Армия короля победила!");
                    break;
                }
            }
            enemyList.get(0).attack(king);
            if (king.army.get(0).isAlive()) {
            System.out.printf("%s был ударен врагом %s типа и получил урон в %s здоровья!\n",king.army.get(0).name,enemyList.get(0).enemyType,damage);
            }
            else {
                System.out.printf("%s был убит врагом %s типа, получив урон в %s здоровья!\n\n",king.army.get(0).name,enemyList.get(0).enemyType,damage);
                king.army.remove(0);
                if (king.army.size() == 0)
                {
                    System.out.println("Армия врага победила!");
                    break;
                }
            }
        }
    }
}

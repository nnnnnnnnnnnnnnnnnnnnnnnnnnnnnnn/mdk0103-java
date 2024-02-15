/*
В отдельном пакете реализовать программу для формирования групп альпинистов для восхождения на гору:
- альпинист создается с именем, возрастом и адресом проживания
- гора создается с названием, страной и высотой
- группа для восхождения на гору создается со следующими характеристиками:
    - идет набор в группу или нет
    - список альпинистов
    - гора
    - должна быть возможность добавить альпиниста в группу, если набор еще идет
- в точке входа (main) создать:
    - 3 группы для восхождения на 3 разных горы
    - в первой групппе 3 альпиниста (набор закрыт)
    - во второй и третьей группах набор открыт
Необходимо соблюдать модификаторы доступа и выполнения проверок
*/

package mountain_climbing;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Climber> climbers = new ArrayList<>();
        climbers.add(new Climber("Иван", 25, "Невский 14"));
        climbers.add(new Climber("Георгий", 38, "Проспект Космонавтов 7"));
        climbers.add(new Climber("Надежда", 36, "Проспект Космонавтов 7"));

        Group group1 = new Group("1",false, climbers, new Mountain("Эверест", "Непал", 8849));
climbers = new ArrayList<>();
climbers.add(new Climber("Сергей", 15, "Вавилова 32"));
Group group2 = new Group("2", true, climbers, new Mountain("Эльбрус", "Россия", 5642));
Group group3 = new Group("3",true, new ArrayList<>(), new Mountain("Гора Народная", "Россия", 1772));

    group1.addClimber(new Climber("Егор", 47, "адрес"));
        group2.addClimber(new Climber("Егор", 47, "адрес"));
        group3.addClimber(new Climber("Егор", 47, "адрес"));

    group1.showInfo();
        group2.showInfo();
        group3.showInfo();
    }


}

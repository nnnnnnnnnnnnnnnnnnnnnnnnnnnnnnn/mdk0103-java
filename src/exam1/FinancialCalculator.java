package exam1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FinancialCalculator {
static BigDecimal[] spendingList = new BigDecimal[30];
public static Scanner scanner = new Scanner(System.in);
    public static void menu() {
        do {
            boolean correct;
            System.out.println("\n---Меню---");
            System.out.println("1 – Ввести расходы за определенный день");
            System.out.println("2 – Траты за месяц");
            System.out.println("3 – Самая большая сумма расхода за месяц");
            System.out.println("4 – Показать сумму расходов в разных валютах");
            System.out.println("0 – Выход");
            do {
                System.out.print("Для выбора введите номер пункта: ");
                correct = true;
                String input = scanner.next();
                switch (input) {
                    case "1":
                        setDaySpending();
                        break;
                    case "2":
                        showMonthSpending();
                        break;
                    case "3":
                        getBiggestDay();
                        break;
                    case "4":
                        getConvertedSum();
                        break;
                    case "0":
                        exitProgram();
                        break;
                    default:
                        correct = false;
                        System.out.println("Неверная команда, попробуйте еще раз");
                        break;
                }
            }
            while (!correct);
        } while (true);
    }

    public static void setDaySpending() {
        System.out.println("\n---Установка значений---");
        while (true) {
            boolean correct = false;
            int day = 0;
            BigDecimal amount = BigDecimal.ZERO;
            do {
                System.out.print("Введите день (1-30) или 0 для выхода в меню: ");
                try {
                    day = scanner.nextInt();
                    if (day == 0) return;
                    if (day < 1 || day > 30)
                        System.out.println("Неверное значение, попробуйте еще раз");
                    else
                        correct = true;
                } catch (InputMismatchException ex) {
                    System.out.println("Неверное значение, попробуйте еще раз");
                    scanner.nextLine();
                }
            } while (!correct);
            correct = false;
            do {
                System.out.print("Введите потраченную сумму: ");
                try {
                    amount = scanner.nextBigDecimal().setScale(2, RoundingMode.HALF_UP);
                    if (amount.compareTo(BigDecimal.ZERO) < 0 || amount.compareTo(BigDecimal.valueOf(1000000000)) > 0)
                        System.out.println("Неверное значение, попробуйте еще раз");
                    else
                        correct = true;
                } catch (InputMismatchException ex) {
                    System.out.println("Неверное значение, попробуйте еще раз");
                    scanner.nextLine();
                }
            } while (!correct);
            if (spendingList[day - 1].equals(BigDecimal.valueOf(-1)))
                spendingList[day - 1] = amount;
            else {
                System.out.printf("За этот день уже указана сумма %s. Вы хотите перезаписать  ее (1) или оставить предыдущую (0)? ", spendingList[day - 1]);
                String input = scanner.next();
                switch (input) {
                    case "1":
                        spendingList[day - 1] = amount;
                        System.out.println("Сумма была перезаписана"); break;
                    case "0": break;
                    default:
                        System.out.println("Неверное значение, была оставлена изначальная сумма");
                }
            }
        }

    }

    public static void showMonthSpending() {
        String out = "\n---Вывод всех трат по дням за месяц---\n";
        for (int i = 0; i < spendingList.length; i++) {
            out += String.format("%s-й день: ",i+1);
            if (spendingList[i].equals(BigDecimal.valueOf(-1)))
                out += "не установлено\n";
            else
                out += String.format("%s руб\n",spendingList[i].setScale(2, RoundingMode.HALF_UP));
        }
        System.out.print(out);
    }

    public static int getBiggestDecimal() {
        BigDecimal current = spendingList[0];

        for (int i = 1; i < spendingList.length; i++) {
            current = current.max(spendingList[i]);
        }
        if (current.equals(BigDecimal.valueOf(-1)))
            return -1;

        for (int i = 1; i < spendingList.length; i++) {
            if (spendingList[i] == current) return i;
        }
        return -1;
    }

    public static void getBiggestDay() {
        String out = "\n---Самая большая сумма---\n";
        int index = getBiggestDecimal();
        if (index < 0)
            out += "Вы не ввели ни одного значения\n";
        else
            out += String.format("%s-й день: %s руб\n",index+1, spendingList[index]);
        System.out.print(out);
    }

    public static void getConvertedSum() {
        BigDecimal euro = BigDecimal.valueOf(0.010);
        BigDecimal dollar = BigDecimal.valueOf(0.011);
        BigDecimal yuan = BigDecimal.valueOf(0.079);
        BigDecimal sum = BigDecimal.ZERO;
        for(BigDecimal amount : spendingList)
            if (amount.compareTo(BigDecimal.ZERO) > 0)
                sum= sum.add(amount);
        String out = "\n---Сумма затрат в других валютах---\n";
        out += String.format("В долларах: $%s\n",sum.multiply(dollar).setScale(2, RoundingMode.HALF_UP));
        out += String.format("В евро: €%s\n",sum.multiply(euro).setScale(2, RoundingMode.HALF_UP));
        out += String.format("В юанях: ¥%s\n",sum.multiply(yuan).setScale(2, RoundingMode.HALF_UP));
        System.out.print(out);
    }

    public static void exitProgram() {
        System.out.println("\nПрограмма закрывается, до встречи!");
        System.exit(0);
    }

    public static void main(String[] args) {
        Arrays.fill(spendingList, BigDecimal.valueOf(-1));
        menu();

    }

}



package java_base;

import java.util.Scanner;

/*
Программа считывает из консоли значения зарплаты, планируемых затрат на транспорт и еду, а также сумму возможных сбережений. Нужно создать метод, который сравнивает планируемые траты с зарплатой, печатает размер излишка или недостатка средств и выдаёт рекомендации. Объявите метод, который принимает значения переменных из главного метода в качестве аргументов. Дополните строки печати корректными значениями.
*/
public class FinancialManager {

    static Scanner scanner = new Scanner(System.in);

    public static double[] getInput() {
        double[] values = new double[3];
        values[0] = getDouble("Введите зарплату за этот месяц: ");
        values[1] = getDouble("Введите сумму планируемых затрат: ");
        values[2] = getDouble("Введите сумму, которую вы хотите отложить: ");
        return values;
    }

    public static double getDouble(String out) {
        while (true) {
            try {
                System.out.print(out);
                double value = scanner.nextDouble();
                if (value < 0) System.out.println("Неверное значение, попробуйте еще раз.");
                    else return value;
            } catch (Exception InputMismatchException) {
                System.out.println("Неверное значение, попробуйте еще раз.");
            }
        }
    }

    public static void getRecommendations(double[] values) {
        double income = values[0];
        double spending = values[1];
        double saving = values[2];
        if (income < spending)
            System.out.println("Вы или безработный, или транжира. Надо это исправлять!");
        else if (income == spending)
            System.out.println("Вы с трудом сводите концы с концами, пора задуматься о новой работе или немного уменьшить траты");
        else if (income - spending < saving)
            System.out.println("Вы не можете отложить столько денег! Уменьшите сумму сбережений или закупайтесь скромнее.");
        else if (income - spending == saving)
            System.out.println("Продолжайте в том же духе!");
        else if (income - spending > saving) {
            System.out.println("Вы можете перестать экономить на продуктах, деньги останутся даже после того, как немного отложить!");
        }

    }

    public static void main(String[] args) {
        double values[] = getInput();
        getRecommendations(values);
    }
}

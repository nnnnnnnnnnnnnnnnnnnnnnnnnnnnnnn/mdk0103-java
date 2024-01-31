package java_base;

import java.util.Scanner;

public class SavingTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите начальную сумму на счете: ");
        int start_sum = scanner.nextInt();
        double current_sum = start_sum;
        int years = 0;
        while (current_sum < 1000000){
            current_sum += current_sum * 0.1;
            years++;
        }
        System.out.printf("При  открытии накопительного счета со ставкой 10%% и начальной суммой в %s рублей накопить 1 миллион (%s рублей) получится через %s лет.",start_sum,(int)current_sum,years);
    }

}

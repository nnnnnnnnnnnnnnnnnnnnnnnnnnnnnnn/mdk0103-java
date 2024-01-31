package java_base;

import java.util.Random;

public class SpendingTracker {
    public static void main(String[] args) {
        int[] spendingList = new int[7];
        int totalSpending = 0;
        String[] week = {"Понедельник","Вторник","Среда","Четверг","Пятница","Суббота","Воскресенье"};
        Random rand = new Random();
        for (int i = 0; i < spendingList.length;i++) {
            spendingList[i] = rand.nextInt(1000);
            System.out.printf("%s: было потрачено %s рублей\n",week[i],spendingList[i]);
            totalSpending += spendingList[i];
        }
        System.out.printf("В сумме было потрачено %s за неделю\n",totalSpending);
    }
}

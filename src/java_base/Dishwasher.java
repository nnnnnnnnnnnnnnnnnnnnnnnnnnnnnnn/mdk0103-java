package java_base;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько тарелок надо помыть: ");
        int plates_total = scanner.nextInt();
        int washed_plates = 0;
        System.out.print("Сколько капель моющего средства имеется: ");
        double soap_total = scanner.nextDouble();
        double remaining_soap = soap_total;

        for (int i = 0; i < plates_total; i++) {
            if (remaining_soap >= 0.5) {
                washed_plates += 1;
                remaining_soap -= 0.5;
                System.out.printf("Осталось %s капель моющего средства.\n", remaining_soap);
            } else {
                System.out.println("Моющее средство закончилось");
                break;
            }
        }
        System.out.printf("Было помыто %s тарелок из %s. Осталось %s капель моющего средства из %s.\n", washed_plates, plates_total, remaining_soap, soap_total);
    }
}

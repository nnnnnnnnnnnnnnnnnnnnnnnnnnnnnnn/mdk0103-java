package java_base;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(9)+1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Компьютер загадал число от 1 до 9 (включительно). Попробуйте угадать его за 3 попытки!");
        int attempt = 0;
        do {
            System.out.print("Ваше предположение: ");
            int guess = scan.nextInt();
            if (guess == number){
                System.out.println("Вы угадали число!");
                return;
            }
            if (guess > number)
                System.out.println("Введенное число больше загаданного");
            else
                System.out.println("Введенное число меньше загаданного");
            attempt++;
        } while (attempt < 3);
        System.out.println("Вы проиграли :(");
    }
}

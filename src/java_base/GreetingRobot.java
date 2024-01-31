package java_base;

import java.time.LocalTime;

public class GreetingRobot {
    private static String getGreeting(int hour) {
        if (hour < 4 || hour == 23)
            return "Приветствую, ночная птица!";
        if (hour < 12)
            return "Доброе утро!";
        if (hour < 18)
            return "Добрый день!";
        if (hour < 23)
            return "Добрый вечер!";
        return "Произошла ошибка";
    }

    public static void main(String[] args) {
        String greeting = getGreeting(LocalTime.now().getHour());
        System.out.println(greeting);

        for (int i = 0; i < 24; i++) {
            System.out.printf("%s: %s\n", i, getGreeting(i));
        }

    }
}

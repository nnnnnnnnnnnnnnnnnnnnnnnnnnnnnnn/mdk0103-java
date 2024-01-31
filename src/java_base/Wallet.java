package java_base;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Wallet {
        static HashMap<String, Double> wallet = new HashMap<>();
        private static void showWallet() {
            for (Map.Entry<String,Double> entry : wallet.entrySet()) {
                System.out.printf("%s: %s%n", entry.getKey(),entry.getValue());
            }
        }
    public static void main(String[] args) {
        wallet.put("Доллары", 1000.);
        wallet.put("Евро", 2000.);
        wallet.put("Йены", 3000.);
        wallet.put("Рубли", 4000.);
        double euroToKrona = 11.33;
        double yenToYuan = 0.048;
        System.out.println("Изначальные значения в кошельке:");
        showWallet();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Куда направляетесь? ");
        String country = scanner.next().trim();
        switch (country) {
            case "Швеция":
                wallet.put("Кроны", wallet.get("Евро") * euroToKrona);
                wallet.remove("Евро");
                break;
            case "Китай":
                wallet.put("Юани", wallet.get("Йены") * yenToYuan);
                wallet.remove("Йены");
                break;
            default:
                System.out.println("Такой опции пока не существует");
                System.out.println(country);
                break;
        }
        System.out.println("Значения в кошельке после конвертации:");
        showWallet();
    }
}

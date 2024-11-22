package org.example;

/**
 * В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла (Парадокс Монти Холла — Википедия )
 * https://ru.wikipedia.org/wiki/%D0%9F%D0%B0%D1%80%D0%B0%D0%B4%D0%BE%D0%BA%D1%81_%D0%9C%D0%BE%D0%BD%D1%82%D0%B8_%D0%A5%D0%BE%D0%BB%D0%BB%D0%B0
 *  и наглядно убедиться в верности парадокса
 * (запустить игру в цикле на 1000 и вывести итоговый счет).
 * Необходимо:
 * Создать свой Java Maven или Gradle проект;
 * Подключить зависимость lombok.
 * Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой
 * Самостоятельно реализовать прикладную задачу;
 * Сохранить результат в HashMap<шаг теста, результат>
 * Вывести на экран статистику по победам и поражениям
 */


import lombok.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Data
public class Paradox {
    private static final int TOTAL_TRIALS = 1000;
    private static final Random random = new Random();

    public static void main(String[] args) {
        Map<Integer, Boolean> results = new HashMap<>();
        int stayWins = 0;
        int switchWins = 0;

        for (int i = 0; i < TOTAL_TRIALS; i++) {
            boolean win = simulateMontyHall(true);
            if (win) switchWins++;
            results.put(i, win);
        }

        for (int i = 0; i < TOTAL_TRIALS; i++) {
            boolean win = simulateMontyHall(false);
            if (win) stayWins++;
            results.put(i + TOTAL_TRIALS, win);
        }

        System.out.println("Победы при смене выбора: " + switchWins);
        System.out.println("Победы при оставлении выбора: " + stayWins);
    }

    private static boolean simulateMontyHall(boolean switchChoice) {
        int winningDoor = random.nextInt(3);
        int chosenDoor = random.nextInt(3);

        if (switchChoice) {
            return chosenDoor != winningDoor;
        } else {
            return chosenDoor == winningDoor;
        }
    }
}

package CalCount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class StepTracker {

    private static int day = 0;
    private static int month = 0;
    private static int stepsGoal = 10_000;
    private static HashMap<Map.Entry<Integer, Integer>, Integer> stepsInOneDay = new HashMap<>();

    //
    // мне надо делать геттеры и сеттеры в пределах одного класса?
    //
    HashMap<Integer, Integer> monthDay = new HashMap<>();
    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthDay.put(i, 0);
        }
    }

    public static void setSteps() {
        boolean exit;
        Scanner sc;
        int stepsInput;

        exit = false;
        while (!exit) {
            System.out.println("Введите целевое количество шагов в день: ");
            sc = new Scanner(System.in);
            stepsInput = sc.hasNextInt() ? sc.nextInt() : -1;
            if (stepsInput <= 0 || stepsInput > 300_000) {
                System.out.println("Неверный формат числа шагов!");
            } else exit = true;

            StepTracker.stepsGoal = stepsInput;
        }
    }

    public static void monthStat() {
        boolean exit;
        Scanner sc;
        int stepsInMonth = 0;

        exit = false;

        //Вывод меню выбора месяца
        while (!exit) {
            System.out.println("Выберите порядковый номер месяца для получения статистики:\n1.Янв 2.Фев 3.Март 4.Апр 5.Май 6.Июн\n7.Июл 8.Авг 9.Сен 10.Окт 11.Ноя 12.Дек");
            sc = new Scanner(System.in);
            month = sc.hasNextInt() ? sc.nextInt() : -1;
            if (month <= 0 || month > 12) {
                System.out.println("Неверный формат месяца!");
            } else exit = true;
        }

        int current;
        int max = 0;

        int maxSeries = 0;
        int counter = 0;

        for (int i = 1; i <= 30; i++) {
            current = stepsInOneDay.getOrDefault(Map.entry(month, i), 0);
            stepsInMonth += current;
            System.out.print(i + " день: " + current + " шагов\t");
            max = Integer.max(max, current);

            if (current > stepsGoal) {
                counter++;
                maxSeries = Integer.max(maxSeries, counter);
            } else counter = 0;

        }
        System.out.println("\nКоличество шагов за месяц: " + stepsInMonth);
        System.out.println("Среднее количество шагов за месяц: " + stepsInMonth / 30);
        System.out.println("Максимальное количество шагов за месяц: " + max);
        System.out.println("Серия дней с шагами выше цели за месяц: " + maxSeries);
        System.out.println("Пройденная дистанция за месяц: " + new Converter().to_km(stepsInMonth) + " км");
        System.out.println("Количество сожженных ККал: " + new Converter().to_kcal(stepsInMonth));

    }

    public static void enterSteps() {

        boolean exit;
        Scanner sc;

        System.out.println("Введите сегодняшнюю дату");

        exit = false;
        while (!exit) {
            System.out.println("День:");
            sc = new Scanner(System.in);
            day = sc.hasNextInt() ? sc.nextInt() : -1;
            if (day <= 0 || day > 30) {
                System.out.println("Неверный формат числа месяца!");
            } else exit = true;
        }

        exit = false;
        while (!exit) {
            System.out.println("Порядковый номер месяца:\n1.Янв 2.Фев 3.Март 4.Апр 5.Май 6.Июн\n7.Июл 8.Авг 9.Сен 10.Окт 11.Ноя 12.Дек");
            sc = new Scanner(System.in);
            month = sc.hasNextInt() ? sc.nextInt() : -1;
            if (month <= 0 || month > 12) {
                System.out.println("Неверный формат месяца!");
            } else exit = true;
        }

        exit = false;
        while (!exit) {
            System.out.println("Количество шагов за день:");
            sc = new Scanner(System.in);
            stepsGoal = sc.hasNextInt() ? sc.nextInt() : -1;
            if (stepsGoal <= 0 || stepsGoal > 300_000) {
                System.out.println("Неверный формат числа шагов!");
            } else exit = true;
        }
        stepsInOneDay.put(Map.entry(month, day), stepsGoal);
    }

    public static class Converter {
        public static final double KM_PER_STEP = 0.00075;
        public static final double KCAL_PER_STEP = 0.05;

        public double to_km(int steps) {
            return steps * KM_PER_STEP;
        }

        public double to_kcal(int steps) {
            return steps * KCAL_PER_STEP;
        }

    }


}





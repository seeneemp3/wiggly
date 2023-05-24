package CalCount;


import java.util.Scanner;

/* Считывание команд в цикле для управления приложением
1. Ввести количество шагов ща определенный день
2. Напечатать статистику за определенный день
3. Изменение цели по количеству шагов в день
4. выход из приложения

 */
public class Main {

    public static void main(String[] args) {
        printmenu();
    }

    private static void printmenu() {
        boolean exit = false;
        Scanner sc;

        while (!exit) {
            System.out.println("""
                                        
                    Введите нужную команду:
                    1. Ввести количество шагов за определенный день
                    2. Напечатать статистику за определенный месяц
                    3. Изменение цели по количеству шагов в день
                    4. Выход из приложения""");

            int menuOption = 0;
            sc = new Scanner(System.in);

            if (sc.hasNextInt()) menuOption = sc.nextInt();

            switch (menuOption) {
                case 1 -> StepTracker.enterSteps();
                case 2 -> StepTracker.monthStat();
                case 3 -> StepTracker.setSteps();
                case 4 -> exit = true;
                default -> System.out.println("Неверная команда");
            }
        }
    }
}

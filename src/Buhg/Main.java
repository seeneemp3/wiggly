package Buhg;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;



public class Main {
    public static void main(String[] args) {
        printMenu();
    }


    private static void printMenu() {
        String userHome = System.getProperty("user.dir");
        boolean exit = false;
        Scanner sc;

        MonthReport m = new MonthReport();
        YearReport y=new YearReport();

        while (!exit) {
            System.out.println("""
                                        
                    Введите нужную команду:
                    1. Считать все месячные отчеты
                    2. Считать годовой отчет
                    3. Сверить отчеты
                    4. Вывести информацию о всех месячных отчетах
                    5. Вывести информацию о годовом отчете
                    6. Выход из приложения""");

            int menuOption = 0;
            sc = new Scanner(System.in);

            if (sc.hasNextInt()) menuOption = sc.nextInt();

            switch (menuOption) {
                case 1 -> {
                    Path file1 = Path.of(userHome + "/data/m.202101.csv");
                    Path file2 = Path.of(userHome + "/data/m.202102.csv");
                    Path file3 = Path.of(userHome + "/data/m.202103.csv");
                    m = new MonthReport(initMonthsMap(new Path[]{file1, file2, file3}));
                }
                case 2 -> {
                    Path file4 = Path.of(userHome +"/data/y.2021.csv");
                    y = new YearReport(linesToYearObjList(file4));
                }
                case 3 -> {
                    if (m.getMonthsDataList() != null && y.getYearDataList() != null) {
                        Reports.compute(y, m);
                    } else System.out.println("Need to read both reports first");
                }

                case 4 -> {
                    if (m.getMonthsDataList() != null) {
                        m.monthInfo();
                    } else System.out.println("Need to read month report first");
                }

                case 5 -> {
                    if (y.getYearDataList() != null) {
                        y.yearInfo();
                    } else System.out.println("Need to read year report first");
                }
                case 6 -> exit = true;
                default -> System.out.println("Wrong option!");
            }
        }
    }


    public static HashMap<Integer, ArrayList<MonthObj>> initMonthsMap(Path[] monthPaths) {
        HashMap<Integer, ArrayList<MonthObj>> mapMonth = new HashMap<>();
        for (Path p : monthPaths) {
            mapMonth.put(toMonthsMap(p).getKey(), toMonthsMap(p).getValue());
        }
        return mapMonth;
    }

    private static Map.Entry<Integer, ArrayList<MonthObj>> toMonthsMap(Path path) {
        return Map.entry(parseNameToMY(path).getKey(), linesToMonthObjList(Objects.requireNonNull(parseToLines(path))));
    }

    private static ArrayList<MonthObj> linesToMonthObjList(ArrayList<String> list) {
        int ITEM_NAME=0;
        int IS_EXPENSE=1;
        int QUANTITY = 2;
        int SUM_OF_ONE = 3;
        ArrayList<MonthObj> monthCategory = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            String[] arr = list.get(i).split(",");
            monthCategory.add(new MonthObj(arr[ITEM_NAME], Boolean.parseBoolean(arr[IS_EXPENSE]), Integer.parseInt(arr[QUANTITY]), Integer.parseInt(arr[SUM_OF_ONE])));
        }
        return monthCategory;
    }

    private static ArrayList<String> parseToLines(Path path) {
        ArrayList<String> list;
        try {
            list = (ArrayList<String>) Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private static ArrayList<YearObj> linesToYearObjList(Path path) {
        int YEAR=0;
        int MONTH=1;
        int IS_EXPENSE=2;

        ArrayList<YearObj> yearList = new ArrayList<>();

        ArrayList<String> list = Objects.requireNonNull(parseToLines(path));
        for (int i = 1; i < list.size(); i++) {
            String[] arr = list.get(i).split(",");
            yearList.add(new YearObj(parseNameToMY(path).getValue(), Integer.parseInt(arr[YEAR]), Integer.parseInt(arr[MONTH]), Boolean.parseBoolean(arr[IS_EXPENSE])));
        }
        return yearList;
    }


    private static Map.Entry<Integer, Integer> parseNameToMY(Path path) {
        Map.Entry<Integer, Integer> data = null;
        if (path.getFileName().toString().startsWith("y")) {
            data = Map.entry(0, Integer.parseInt(path.getFileName().toString().substring(2, 6)));
        } else if (path.getFileName().toString().startsWith("m")) {
            data = Map.entry(Integer.parseInt(path.getFileName().toString().substring(6, 8)),
                    Integer.parseInt(path.getFileName().toString().substring(2, 6)));
        }

        return data;
    }
}

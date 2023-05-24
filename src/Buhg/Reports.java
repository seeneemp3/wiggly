package Buhg;

import java.util.ArrayList;
import java.util.Map;

public class Reports {

    public static final String[] MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public static void compute(YearReport yearReport, MonthReport monthReport) {
        System.out.println("\nRevise data:\n");
        int expM, expY, profM, profY;

        for (Map.Entry<Integer, ArrayList<MonthObj>> m : monthReport.getMonthsDataList().entrySet()) {
            expM = monthReport.getMonthExpenses(m.getValue());
            expY = yearReport.getYearExpenses(m.getKey(), yearReport.getYearDataList());
            profM = monthReport.getMonthProfit(m.getValue());
            profY = yearReport.getYearProfit(m.getKey(), yearReport.getYearDataList());

            if (expM != expY || profM != profY) {
                System.out.println("Mismatch in " + m.getKey() + "-th month");
            }

            System.out.println("In " + m.getKey() + "-th month expenses are " + expM + " " + expY);
            System.out.println("In " + m.getKey() + "-th month profit is " + profM + " " + profY);
        }
    }


}

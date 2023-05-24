package Buhg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MonthReport extends Reports {
    private HashMap<Integer, ArrayList<MonthObj>> monthsDataList;

    public MonthReport(HashMap<Integer, ArrayList<MonthObj>> monthsDataList) {
        this.monthsDataList = monthsDataList;
    }


    public HashMap<Integer, ArrayList<MonthObj>> getMonthsDataList() {
        return monthsDataList;
    }

    public MonthReport(){
    }

    public int getMonthExpenses(ArrayList<MonthObj> arr) {
        //System.out.println("in this month expenses are "+calculateMonth(arr,true));
        return calculateMonth(arr, true);
    }

    public int getMonthProfit(ArrayList<MonthObj> arr) {
        //System.out.println("in this month profit is "+calculateMonth(arr,true));
        return calculateMonth(arr, false);
    }

    private int calculateMonth(ArrayList<MonthObj> arr, boolean expense) {
        int total = 0;
        for (MonthObj m : arr) {
            if (m.isExpenseM() == expense) {
                total += m.getQuantity() * m.getSumOfOne();
            }
        }
        return total;
    }

    public void monthInfo() {
        System.out.println("\nMonth information:\n");

        HashMap<Integer, String> maxProfit;
        HashMap<Integer, String> maxExpense;

        for (Map.Entry<Integer, ArrayList<MonthObj>> m : monthsDataList.entrySet()) {
            System.out.println("Month: " + MONTHS[m.getKey() - 1]);

            maxProfit = new HashMap<>();
            for (MonthObj obj : m.getValue()) {
                if (!obj.isExpenseM()) {
                    maxProfit.put(obj.getSumOfOne() * obj.getQuantity(), obj.getItemName());
                }
            }
            Integer maxProf = Collections.max(maxProfit.keySet());
            System.out.println("Max profit from: " + maxProfit.get(maxProf) + " - " + maxProf);

            maxExpense = new HashMap<>();
            for (MonthObj obj : m.getValue()) {
                if (obj.isExpenseM()) {
                    maxExpense.put(obj.getSumOfOne() * obj.getQuantity(), obj.getItemName());
                }
            }
            Integer maxExp = Collections.max(maxExpense.keySet());
            System.out.println("Max expense from: " + maxExpense.get(maxExp) + " - " + maxExp);

        }
    }

}

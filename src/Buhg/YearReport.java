package Buhg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class YearReport extends Reports {
    private ArrayList<YearObj> yearDataList;

    public YearReport(ArrayList<YearObj> yearDataList) {
        this.yearDataList = yearDataList;
    }
    public YearReport(){
    }

    public ArrayList<YearObj> getYearDataList() {
        return yearDataList;
    }

    public int getYearExpenses(int month, ArrayList<YearObj> arr) {
        //System.out.println("in "+month+"-th month expenses "+calculateYear(month,arr,true));
        return calculateYear(month, arr, true);
    }

    public int getYearProfit(int month, ArrayList<YearObj> arr) {
        //System.out.println("in "+month+"-th month profit is "+calculateYear(month,arr,true));
        return calculateYear(month, arr, false);
    }

    private int calculateYear(int month, ArrayList<YearObj> arr, boolean expense) {
        int total = 0;
        for (YearObj yearobj : arr) {
            if (yearobj.isExpenseY() == expense && yearobj.getMonth() == month) {
                total = yearobj.getAmount();
            }
        }
        return total;
    }

    public void yearInfo() {
        System.out.println("\nYear information:\n");
        System.out.println("Year: " + yearDataList.get(0).getYear());
        HashSet<Integer> monthCounter = new HashSet<>();
        int profit;
        for (int i = 0; i < yearDataList.size(); i++) {
            monthCounter.add(yearDataList.get(i).getMonth());

            System.out.println("Month: " + MONTHS[yearDataList.get(i).getMonth() - 1]);
            profit = 0;
            if (yearDataList.get(i).isExpenseY()) {
                profit -= yearDataList.get(i).getAmount();
            }
            i++;
            if (!yearDataList.get(i).isExpenseY()) {
                profit += yearDataList.get(i).getAmount();
            }
            System.out.println("Profit: " + profit);
        }
        int avgE = 0;
        int avgP = 0;
        for (YearObj yo : yearDataList) {
            if (yo.isExpenseY()) {
                avgE += yo.getAmount();
            } else avgP += yo.getAmount();
        }
        System.out.println("Average expense per month: " + avgE / Collections.max(monthCounter));
        System.out.println("Average profit per month: " + avgP / Collections.max(monthCounter));
    }


}

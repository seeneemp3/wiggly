package Buhg;

public class YearObj {

    private int year;
    private int month;
    private boolean isExpenseY;
    private int amount;



    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public boolean isExpenseY() {
        return isExpenseY;
    }

    public int getAmount() {
        return amount;
    }



    public YearObj(int year, int month, int amount, boolean isExpense) {
        this.year = year;
        this.month = month;
        this.isExpenseY = isExpense;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "YearObj{" +
                "year=" + year +
                ", month=" + month +
                ", isExpense=" + isExpenseY +
                ", amount=" + amount +
                '}';
    }
}

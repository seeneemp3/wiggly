package Buhg;

public class MonthObj {
    private String itemName;
    private boolean isExpenseM;
    private int quantity;
    private int sumOfOne;

    public String getItemName() {
        return itemName;
    }

    public boolean isExpenseM() {
        return isExpenseM;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getSumOfOne() {
        return sumOfOne;
    }

    public MonthObj(String itemName, boolean isExpense, int quantity, int sumOfOne) {
        this.itemName = itemName;
        this.isExpenseM = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }

    @Override
    public String toString() {
        return "MonthCategoryData{" +
                "itemName='" + itemName + '\'' +
                ", isExpense=" + isExpenseM +
                ", quantity=" + quantity +
                ", sumOfOne=" + sumOfOne +
                '}';
    }
}

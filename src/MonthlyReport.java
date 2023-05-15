public class MonthlyReport { // Хранение месячных данных.
    public String itemName;
    public boolean isExpense;
    public int quantity;
    public int sumOfOne;

    public MonthlyReport(String itemName, boolean isExpense, int quantity, int sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
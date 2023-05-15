public class YearlyReport { // Хранение годовых данных.
    public String month;
    public int amount;
    public boolean isExpense;

    public YearlyReport(String month, int amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }
}
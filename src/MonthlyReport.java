public class MonthlyReport { // Хранение месячных данных.
    public String item_name;
    public boolean is_expense;
    public int quantity;
    public int sum_of_one;

    public MonthlyReport(String item_name, boolean is_expense, int quantity, int sum_of_one) {
        this.item_name = item_name;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }
}
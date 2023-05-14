import java.util.ArrayList;

public class Transaction { // Класс для сверки годового и месячных отчётов.
public ReportEngine reportEngine;

public Transaction(ReportEngine reportEngine) {
    this.reportEngine = reportEngine;
}
public boolean check() { // Поиск несоответствий.
    boolean check = true;
    if (reportEngine.yearlyReports.isEmpty() || reportEngine.monthlyReport.size() == 0) {
        System.out.println("Нет данных, нужно считать файлы!");
        return false;
    } else {
        for (Integer integer : reportEngine.monthlyReport.keySet()) {
            ArrayList<MonthlyReport> monthlyReports = reportEngine.monthlyReport.get(integer);
            int allSumTrue = 0;
            int allSumFalse = 0;
            boolean test = true;
            for (MonthlyReport month : monthlyReports) {
                int sum;
                if (month.is_expense) {
                    sum = month.sum_of_one * month.quantity;
                    allSumTrue += sum;
                } else {
                    sum = month.sum_of_one * month.quantity;
                    allSumFalse += sum;
                }
                    }
            for (YearlyReport yearlyReport : reportEngine.yearlyReports) {
                if (yearlyReport.month.equals("0" + integer)){
                    if (yearlyReport.is_expense) {
                        test = yearlyReport.amount == allSumTrue;
                    } else {
                        test = yearlyReport.amount == allSumFalse;
                    }
                    if (!test) {
                        System.out.println("В " + yearlyReport.month + " месяце найдены несоответствия!");
                    }
                }
                if (check) {
                    check = test;
                }
            }
                }
            }
    return check;
        }
    }

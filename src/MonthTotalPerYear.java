import java.util.ArrayList;

public class MonthTotalPerYear { // Класс для расчётов и вывода годовых и месячных данных.
    private final ReportEngine reportEngine;

    public MonthTotalPerYear(ReportEngine reportEngine) {
        this.reportEngine = reportEngine;
    }

    public void conclusionYear(){ // Вывод информации из годового отчёта.
        if (reportEngine.yearlyReports.isEmpty()) {
            System.out.println("Нет данных, нужно считать файлы!");
        } else {
            System.out.println("Данные за 2021 год:");
            int sumTru = 0;
            int sumFal = 0;
            for (int i = 1; i < 4; i++) {
                int tru = 0;
                int fal = 0;
                for (YearlyReport yearlyReport : reportEngine.yearlyReports) {
                    if (yearlyReport.month.equals("0" + i)){
                        if (yearlyReport.isExpense) {
                            tru = yearlyReport.amount;
                            sumTru += tru;
                        } else {
                            fal = yearlyReport.amount;
                            sumFal += fal;
                        }
                    }
                }
                System.out.println("В 0" + i + " месяце прибыль составила: " + (fal - tru) + ".");
            }
            System.out.println("Cредний расход за все имеющиеся операции в году составил: " + (sumTru / 3) + ".");
            System.out.println("Cредний доход за все имеющиеся операции в году составил: " + (sumFal / 3) + ".");
        }
    }
    public void conclusionMonth(){ // Вывод информации из месячных отчётов.
        if (reportEngine.monthlyReport.isEmpty()) {
            System.out.println("Нет данных, нужно считать файлы!");
        } else {
            for (Integer numberMonth : reportEngine.monthlyReport.keySet()) {
                int maxTru = 0;
                int maxFal = 0;
                String nameTru = null;
                String nameFal = null;
                ArrayList<MonthlyReport> monthlyReports = reportEngine.monthlyReport.get(numberMonth);
                for (MonthlyReport month : monthlyReports) {
                    int sum = month.quantity * month.sumOfOne;
                    if (month.isExpense){
                        if (maxTru < sum) {
                            maxTru = sum;
                            nameTru = month.itemName;
                        }
                    } else {
                        if (maxFal < sum) {
                            maxFal = sum;
                            nameFal = month.itemName;
                        }
                    }
                }
                if (numberMonth == 1) {
                    System.out.println("Январь:");
                    System.out.println("Cамый прибыльный товар: " + nameFal + " - " + maxFal + ".");
                    System.out.println("Cамая большая трата: " + nameTru + " - " + maxTru + ".");
                } else if (numberMonth == 2) {
                    System.out.println("Февраль:");
                    System.out.println("Cамый прибыльный товар: " + nameFal + " - " + maxFal + ".");
                    System.out.println("Cамая большая трата: " + nameTru + " - " + maxTru + ".");
                } else  {
                    System.out.println("Март:");
                    System.out.println("Cамый прибыльный товар: " + nameFal + " - " + maxFal + ".");
                    System.out.println("Cамая большая трата: " + nameTru + " - " + maxTru + ".");
                }
            }
        }
    }
}

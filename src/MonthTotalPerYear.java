import java.util.ArrayList;

public class MonthTotalPerYear { // Класс для расчётов и вывода годовых и месячных данных.
    public ReportEngine reportEngine;

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
                        if (yearlyReport.is_expense) {
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
        if (reportEngine.monthlyReport.size() == 0) {
            System.out.println("Нет данных, нужно считать файлы!");
        } else {
            for (Integer integer : reportEngine.monthlyReport.keySet()) {
                int maxTru = 0;
                int maxFal = 0;
                String nameTru = null;
                String nameFal = null;
                ArrayList<MonthlyReport> monthlyReports = reportEngine.monthlyReport.get(integer);
                for (MonthlyReport month : monthlyReports) {
                    int sum = month.quantity * month.sum_of_one;
                    if (month.is_expense){
                        if (maxTru < sum) {
                            maxTru = sum;
                            nameTru = month.item_name;
                        }
                    } else {
                        if (maxFal < sum) {
                            maxFal = sum;
                            nameFal = month.item_name;
                        }
                    }
                }
                if (integer == 1) {
                    System.out.println("Январь:");
                    System.out.println("Cамый прибыльный товар: " + nameFal + " - " + maxFal + ".");
                    System.out.println("Cамая большая трата: " + nameTru + " - " + maxTru + ".");
                } else if (integer == 2) {
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

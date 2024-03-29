import java.util.ArrayList;
import java.util.HashMap;

public class ReportEngine { // Класс считывания файлов.
    private final FileReader fileReader = new FileReader();

    public ArrayList<YearlyReport> yearlyReports = new ArrayList<>();
    public HashMap<Integer, ArrayList<MonthlyReport>> monthlyReport = new HashMap<>();

    public void readYearlyReports() { // Считывание годового файла.
        ArrayList<String> lines = fileReader.readFileContents("y.2021.csv");
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            String month = parts[0];
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);

            YearlyReport yearlyReport = new YearlyReport(month, amount, isExpense); // Сохранение данных в новый объект.
            yearlyReports.add(yearlyReport); // Добавление объекта в список.
        }
    }

    public void readMonthlyReports() { // Считывание месячных файлов.
        for (int i = 1; i < 4; i++) {
            ArrayList<String> lines = fileReader.readFileContents("m.20210" + i + ".csv");
            ArrayList<MonthlyReport> month = new ArrayList<>();
            for (int j = 1; j < lines.size(); j++) {
                String line = lines.get(j);
                String[] parts = line.split(",");
                String itemName = parts[0];
                boolean isExpense = Boolean.parseBoolean(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                int sumOfOne = Integer.parseInt(parts[3]);

                MonthlyReport monthlyReport = new MonthlyReport(itemName, isExpense, quantity, sumOfOne); // Сохранение данных в новый объект.
                month.add(monthlyReport); // Добавление объекта в список.
            }
            monthlyReport.put(i, month); // Добавление ключа со списком в таблицу.
        }
    }
}

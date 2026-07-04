public class CreditCalculatorV02 {
    public static void main(String[] args) {
        // Параметры по умолчанию
        double amount = 3_000_000;      // сумма в рублях
        double annualRate = 15.0;       // годовая ставка в %
        int months = 120;               // срок в месяцах

        // Если переданы аргументы, переопределяем параметры
        if (args.length >= 3) {
            try {
                amount = Double.parseDouble(args[0]);
                annualRate = Double.parseDouble(args[1]);
                months = Integer.parseInt(args[2]);
                System.out.println("Использованы параметры из командной строки.");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: аргументы должны быть числами. Использую значения по умолчанию.");
            }
        } else {
            System.out.println("Аргументы не заданы (или заданы не все). Использую значения по умолчанию.");
            System.out.println("Формат: java CreditCalculatorV02 <сумма> <ставка> <срок_в_месяцах>");
        }

        // Расчёт (без изменений)
        double monthlyRate = annualRate / 100 / 12;
        double F = Math.pow(1 + monthlyRate, months);
        double annuityFactor = (monthlyRate * F) / (F - 1);
        double monthlyPayment = amount * annuityFactor;
        double totalPayment = monthlyPayment * months;
        double overpayment = totalPayment - amount;

        // Вывод результатов
        System.out.println("=== КРЕДИТНЫЙ КАЛЬКУЛЯТОР (V02) ===");
        System.out.printf("Сумма кредита:   %,13.2f руб.%n", amount);
        System.out.printf("Годовая ставка:  %,13.2f %% %n", annualRate);
        System.out.printf("Срок:            %10d месяцев%n", months);
        System.out.println();
        System.out.printf("Ежемесячный платёж: %,13.2f руб.%n", monthlyPayment);
        System.out.printf("Общая сумма выплат: %,13.2f руб.%n", totalPayment);
        System.out.printf("Переплата:          %,13.2f руб.%n", overpayment);
    }
}
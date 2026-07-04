public class CreditCalculatorV01 {
    public static void main(String[] args) {
        // Параметры кредита (заданы в коде)
        double amount = 3_000_000;          // сумма в рублях
        double annualRate = 15.0;           // годовая ставка в %
        int months = 120;                   // срок в месяцах (10 лет)

        // Расчёт
        double monthlyRate = annualRate / 100 / 12;
        double pow = Math.pow(1 + monthlyRate, months);
        double annuityFactor = (monthlyRate * pow) / (pow - 1);
        double monthlyPayment = amount * annuityFactor;
        double totalPayment = monthlyPayment * months;
        double overpayment = totalPayment - amount;

        // Вывод результатов
        System.out.println("=== КРЕДИТНЫЙ КАЛЬКУЛЯТОР ===");
        System.out.printf("Сумма кредита:   %,13.2f руб.%n", amount);
        System.out.printf("Годовая ставка:  %,13.2f %% %n", annualRate);
        System.out.printf("Срок:            %10d месяцев%n", months);
        System.out.println();
        System.out.printf("Ежемесячный платёж: %,13.2f руб.%n", monthlyPayment);
        System.out.printf("Общая сумма выплат: %,13.2f руб.%n", totalPayment);
        System.out.printf("Переплата:          %,13.2f руб.%n", overpayment);
    }
}
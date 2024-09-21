import java.util.Scanner;

public abstract class calculator {
    // абстрактный класс для переопределения в других классах
    public abstract int calculate(String num1, String num2, String operator);

    // Метод для того, что бы пользователь вводил свои числа
    public String[] InsertNumsAndOperator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        String num1 = scanner.nextLine();
        // regex для проверки вводных данных пользователем с целью защиты от ввода других символов и слов
        while (!num1.matches("\\d+") && !num1.matches("[IVXLCDMivxlcdm]+")) {
            System.out.println("Ошибка: введено не число. Пожалуйста, введите число:");
            num1 = scanner.nextLine();
        }

        System.out.println("Введите второе число:");
        String num2 = scanner.nextLine();
        // regex для проверки вводных данных пользователем с целью защиты от ввода других символов и слов
        while (!num2.matches("\\d+") && !num2.matches("[IVXLCDMivxlcdm]+")) {
            System.out.println("Ошибка: введено не число. Пожалуйста, введите число:");
            num2 = scanner.nextLine();
        }

        System.out.println("Введите оператор (+, -, *, /):");
        String operator = scanner.nextLine();
        // regex для проверки вводных данных пользователем с целью защиты от ввода других символов
        while (!operator.matches("[+\\-*/]")) {
            System.out.println("Ошибка: введен не оператор. Пожалуйста, введите оператор (+, -, *, /):");
            operator = scanner.nextLine();
        }

        if (num1.matches("\\d+") && !num2.matches("\\d+")){
            System.out.println("Разная систма счисления");
        }

        return new String[] {num1, num2, operator};
    }
}


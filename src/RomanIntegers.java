import java.util.HashMap;
import java.util.Map;

public class RomanIntegers extends calculator {
    // Создание коллекции
    private static final Map<String, Integer> romanMap = new HashMap<>();
    // список ключей и значений для перевода из одной системы счисления в другую
    static {
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);
    }

    @Override
    public int calculate(String num1, String num2, String operator) {
        // Проверка на наличие числа в коллекции romanMap что бы пользователь не мог ввести арабские числа
        if(romanMap.containsKey(num1) && romanMap.containsKey(num2)){
            int a = romanToArabic(num1);
            int b = romanToArabic(num2);

            switch (operator) {
                case "+":
                    System.out.println(arabicToRoman(a + b));
                    break;
                case "-":
                    System.out.println(arabicToRoman(a - b));
                    break;
                case "*":
                    System.out.println(arabicToRoman(a * b));
                    break;
                case "/":
                    System.out.println(arabicToRoman(a / b));
                    break;
                default:
                    System.out.println("Ошибка: неизвестный оператор");
                    break;
            }
        }
        else{
            System.out.println("Вы выбрали римскую систему счисления");
            return 0;
        }
        return 0;

    }
    // перевод римских цифр в арабские
    private int romanToArabic(String roman) {
        int result = 0;
        // цикл который сравнивает число с коллекцией и создает переменную с арабскими числами
        for (int i = 0; i < roman.length(); i++) {
            // Разбивает переменную из римских чисел и сравнивает их с коллекцией переводя в арабские
            String current = roman.substring(i, i + 1);
            int currentValue = romanMap.get(current);
            if (i + 1 < roman.length()) {
                String next = roman.substring(i + 1, i + 2);
                int nextValue = romanMap.get(next);
                if (currentValue < nextValue) {
                    result -= currentValue;
                } else {
                    result += currentValue;
                }
            } else {
                result += currentValue;
            }
        }
        return result;
    }

    private String arabicToRoman(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Число должно быть положительным");
        }

        StringBuilder result = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        // сравнивает арабские числа в массива Values сравнивая по индексу с symbols и подставляет в переменную result значение из Римской цифры
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                // добавляет в строку римскую цифру
                result.append(symbols[i]);
                number -= values[i];
            }
        }

        return result.toString();
    }

    public void RomanSum(){
        String[] RomanNums = InsertNumsAndOperator();
        calculate(RomanNums[0],RomanNums[1],RomanNums[2]);
    }

}

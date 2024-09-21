public class ArabicIntegers extends calculator {

    @Override
    public int calculate(String num1, String num2, String operator) {
        try { //через try идет обработка ошибка на то что бы пользователь не вводил римские числа пока считает в арабской системе счисления
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            //Выбор математической операции
            switch (operator) {
                case "+":
                    System.out.println(a + b);
                    break;
                case "-":
                    System.out.println(a - b);
                    break;
                case "*":
                    System.out.println(a * b);
                    break;
                case "/":
                    // в случае если при делении остается дробная часть она выводилась, в случае если целое то показывалось без дроби .0
                    if (b != 0) {
                        double result = (double) a / b;
                        if (result % 1 == 0) {
                            System.out.println((int) result);
                        } else {
                            System.out.println(result);
                        }
                    } else {
                        System.out.println("Ошибка: деление на ноль");
                    }
                    break;
                default:
                    System.out.println("Ошибка: неизвестный оператор");
                    break;
            }
        }
        catch (Exception e){
            System.out.println("Вы выбрали арабскую систему счисления");
        }
        return 0;
    }

    public void SumArabic() {
        String[] nums = InsertNumsAndOperator();
        calculate(nums[0],nums[1],nums[2]);
    }
}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("В какой системе счисления будем считать?");
        System.out.println("1. Арабские цифры \n2. Римские цифры");

        byte choose = in.nextByte();

        //Выбор через переменную тип счисления для калькулятора
        if (choose == 1){
            ArabicIntegers ArabicIntegers = new ArabicIntegers();
            ArabicIntegers.SumArabic();
        }
        else if (choose ==2){
            RomanIntegers RomanIntegers = new RomanIntegers();
            RomanIntegers.RomanSum();
        }
        else {
            System.out.println("Такого выбора нету");
        }
    }
}
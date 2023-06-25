package hw_less_03.additional;

import java.util.Scanner;

/**
 * 2. Дано целое число. Определить, является ли последняя цифра этого числа – цифрой 3.
 */

public class LastNumber3 {
    public static void main(String[] args) {

        System.out.print("Введите число: ");
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextLong()) {
            System.out.println("Нужно вводить только целые числа. Начните заново");
        } else {
            long number = sc.nextLong();

            if (number % 10 == 3) {
                System.out.println("Последняя цифра числа " + number + " = 3");
            } else {
                System.out.println("Последняя цифра числа " + number + " НЕ 3");
            }
        }
    }
}

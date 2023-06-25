package hw_less_03.additional;

import java.util.Scanner;

/**
 * 3. Имеется целое число, вводимое пользователем с консоли. Это число - сумма денег в рублях.
 * -Вывести это число, добавив к нему слово "рубль" в правильном падеже ("рубль", "рублей", "рубля")
 */
public class AmountOfMoney {
    public static void main(String[] args) {

        System.out.print("Введите сумму денег: ");
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            System.out.println("Введите сумму цифрами и без копеек. Начните заново");
        } else {
            int money = sc.nextInt();

            if ((money % 100 >= 11) && (money % 100 <= 14)) {
                System.out.println(money + " рублей");
            } else {

                switch (money % 10) {
                    case 1:
                        System.out.println(money + " рубль");
                        break;
                    case 2, 3, 4:
                        System.out.println(money + " рубля");
                        break;
                    case 0, 5, 6, 7, 8, 9:
                        System.out.println(money + " рублей");
                        break;
                    default:
                        System.out.println("Мы не знаем что это такое");
                }
            }
        }
    }
}

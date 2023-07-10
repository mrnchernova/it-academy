package homework03.additional;

import java.util.Scanner;

/**
 * 1. Дан порядковый номер месяца. Вывести на консоль пору года, к которой относится месяц.
 */

public class Month {
    public static void main(String[] args) {
        int month;
        System.out.print("Введите порядковый номер месяца: ");
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            System.out.println("Нужно вводить только целые числа. Начните заново");
        } else {
            month = sc.nextInt();

            switch (month) {
                case 12, 1, 2:
                    System.out.println("Зима");
                    break;
                case 3, 4, 5:
                    System.out.println("Весна");
                    break;
                case 6, 7, 8:
                    System.out.println("Лето");
                    break;
                case 9, 10, 11:
                    System.out.println("Осень");
                    break;
                default:
                    System.out.println("Нет месяца с таким порядковым номером!");
            }
        }
    }
}

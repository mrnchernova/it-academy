package hw_less_03.additional;

import java.util.Scanner;

/**
 * 4. Написать программу, которая считывает год, введённый пользователем, и определяет,
 * является ли этот год високосным.
 * Год считается високосным, если он делится без остатка на 4. Однако, если год также делится на 100,
 * то этот год не високосный, за исключением годов, делящихся на 400.
 */

public class LeapYear {
    public static void main(String[] args) {

        System.out.print("Введите год: ");
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            System.out.println("Введите целое число. Начните заново");
        } else {
            int year = sc.nextInt();

            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                System.out.println("Високосный год");
            } else {
                System.out.println("Невисокосный год");
            }
        }
    }
}
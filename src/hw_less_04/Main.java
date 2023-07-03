package hw_less_04;

import java.util.Arrays;
import java.util.Random;

/**
 * 1.  Создаем два класса. Класс Cat и класс для запуска приложения (Main, Runner).
 * 2.  У кота есть имя и возраст. Есть дефолтное значение имени и возраста.
 * 3.  При запуске приложения используем четыре цикла.
 * 4.  Первый while создает 10 котиков и выводит на консоль дефолтное имя и возраст.
 * 5.  Во втором цикле for создаем 10 котиков, вводим их возраст и имя через сеттер, и
 * выводим в консоль через геттер.
 * 6.  Третий цикл do while создает 10 котиков вводит имя и возраст через конструктор. Выводим в консоль.
 * 7.  В четвертом цикле foreach выводим  массив из пяти котиков, у них выводим имя и возраст.
 */

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        Cat cat = new Cat();
        String[] catName = {"Ариса", "Ариэль", "Ария", "Aрланда", "Арника", "Арата", "Арфа", "Ассоль", "Аста", "Аура", "Афина", "Ачча", "Ая"};

        System.out.println("1. Цикл while");
        int i = 1;
        while (i <= 10) {
            System.out.println(i + " " + cat);
            i++;
        }

        System.out.println("\n2. Цикл for");
        for (i = 1; i <= 10; i++) {
            int randomName = random.nextInt(catName.length);
            cat.setName(catName[randomName]);
            cat.setAge((int) (Math.random() * 29));
            System.out.println("котик " + cat.getName() + " " + cat.getAge());
        }

        System.out.println("\n3. Цикл do while");
        i = 1;
        do {
            int randomName = random.nextInt(catName.length);
            System.out.println(new Cat(catName[randomName], (int) (Math.random() * 29)));
            i++;
        } while (i <= 10);

        System.out.println("\n4. цикл foreach");
        Cat[] kitty = new Cat[5];
        for (i = 0; i < kitty.length; i++) {
            int randomName = random.nextInt(catName.length);
            kitty[i] = new Cat(catName[randomName], (int) (Math.random() * 29));
        }

        for (Cat c : kitty) {
            System.out.println(c);
        }
    }
}

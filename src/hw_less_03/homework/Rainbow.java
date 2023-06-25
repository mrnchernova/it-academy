package hw_less_03.homework;

import java.util.Scanner;

public class Rainbow {
    private static final String RED = "красный";
    private static final String ORANGE = "оранжевый";
    private static final String YELLOW = "желтый";
    private static final String GREEN = "зеленый";
    private static final String CYAN = "голубой";
    private static final String BLUE = "синий";
    private static final String VIOLET = "фиолетовый";

    private static final String ERROR = "Ошибка. Нет цвета под таким номером";

    String firstColor = "";
    int firstDigit;
    int secondDigit;

    public void Colors() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер цвета 1-7 " +
                "или введите две цифры от 1 до 7 каждая, для получения сложного цвета");

        /*Проверка на символы и вещественный тип*/
        if (!sc.hasNextInt()) {
            System.out.println("Что-то пошло не так. Попробуйте заново");
        } else {
            int color = sc.nextInt();
            /*Проверка на количество символов*/
            if (color < 1 || color > 99) {
                System.out.println(ERROR);
            } else {
                /*Блок выполняется при вводе двух цифр*/
                if (color >= 10 && color <= 99) {
                    firstDigit = color / 10;
                    firstColor = MultiColors(firstDigit);
                }
                /*Сравнивается первая и вторая цифа. При их совпадении, цвет будет выводиться со словом Очень*/
                if (!firstColor.equals(ERROR)) {
                    secondDigit = color % 10;
                    if (firstDigit == secondDigit) {
                        firstColor = "Очень ";
                    }

                    switch (secondDigit) {
                        case 1:
                            System.out.println(firstColor + RED);
                            break;
                        case 2:
                            System.out.println(firstColor + ORANGE);
                            break;
                        case 3:
                            System.out.println(firstColor + YELLOW);
                            break;
                        case 4:
                            System.out.println(firstColor + GREEN);
                            break;
                        case 5:
                            System.out.println(firstColor + CYAN);
                            break;
                        case 6:
                            System.out.println(firstColor + BLUE);
                            break;
                        case 7:
                            System.out.println(firstColor + VIOLET);
                            break;
                        default:
                            System.out.println(ERROR);
                    }
                } else {
                    System.out.println(ERROR);
                }
            }
        }
    }

    public String MultiColors(int x) {
        switch (x) {
            case 1:
                return "красно-";
            case 2:
                return "оранжево-";
            case 3:
                return "желто-";
            case 4:
                return "зелено-";
            case 5:
                return "голубо-";
            case 6:
                return "сине-";
            case 7:
                return "фиолетово-";
            default:
                return ERROR;
        }
    }
}

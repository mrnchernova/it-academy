package homework03.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        simpleCalc();
    }

    public static double a;
    public static double b;
    public static String operator;
    public static boolean binary = true;

    public static void simpleCalc() {
        Calculator calc = new Calculator();

        System.out.println("Выберите операцию и введите команду записанную в скобках" +
                "\n сложение (+)" +
                "\n вычитание (-)" +
                "\n умножение (*)" +
                "\n деление (/)" +
                "\n остаток от деления (mod)" +
                "\n процент от числа (%)" +
                "\n квадратный корень (sqrt)" +
                "\n перевод в двоичную систему счисления из десятичной (to2)" +
                "\n перевод в десятичную систему счисления из двоичной (to10)");

        operator = inputOperator();
        /* Разделение на унарные и бинаарные оператороы */
        /* Выполнение унарных операций */
        if (operator.equals("sqrt") || operator.equals("to10") || operator.equals("to2")) {
            System.out.println("Введите число: ");
            a = inputDigit();
            switch (operator) {
                case "sqrt":
                    prettyResult(Math.sqrt(a));
                    break;
                case "to2":
                    System.out.println("Внимание! Дробная часть числа не учитывается");
                    calc.fromDecToBin(a);
                    break;
                case "to10":
                    if (checkBinary(a)) {
                        calc.fromBinToDec(a);
                        break;
                    } else {
                        System.out.println("Ошибка! Число введено не в двоичной системе счисления");
                        break;
                    }
            }
        } else {
            /* Выполнение бинарных операций */
            if (operator.equals("%")) {
                System.out.println("Введите число: ");
                a = inputDigit();
                System.out.print("Введите процент от числа, который вы хотели бы узнать: ");
                b = inputDigit();

                prettyResult(calc.percent(a, b));
                System.out.println("%");
            } else {
                System.out.print("Введите первое число: ");
                a = inputDigit();
                System.out.print("Введите второе число: ");
                b = inputDigit();

                switch (operator) {
                    case "+":
                        prettyResult(calc.sum(a, b));
                        break;
                    case "-":
                        prettyResult(calc.minus(a, b));
                        break;
                    case "*":
                        prettyResult(calc.mult(a, b));
                        break;
                    case "/":
                        if (b == 0) {
                            System.out.println("На 0 делить нельзя!");
                        } else {
                            prettyResult(calc.div(a, b));
                        }
                        break;
                    case "mod":
                        prettyResult(calc.mod(a, b));
                        break;
                }
            }
        }
        System.out.println("\nХотите продолжить? y/n");
        Scanner sc = new Scanner(System.in);
        if (sc.next().charAt(0) == 'y') {
            simpleCalc();
        }
    }


    /* Убираем нули после точки для красивого вывода*/
    public static void prettyResult(double result) {
        if (result % 1 == 0) {
            System.out.print("Ответ: " + (int) result);
        } else {
            System.out.print("Ответ: " + result);
        }
    }

    /* Проверка числа на ввод в двоичной системе */
    public static boolean checkBinary(double a) {
        String s = Integer.toString((int) a);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                binary = false;
            }
        }
        return binary;
    }

    /* Ввод числа с клавиатуры */
    public static double inputDigit() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextDouble()) {
            System.out.println("Введено не число или введено с ошибкой. Еще попытка");
            sc.next();
        }
        return sc.nextDouble();
    }

    /* Ввод команды математической операции с клавиатуры */
    public static String inputOperator() {
        Scanner sc = new Scanner(System.in);
        operator = sc.nextLine();
        /* Проверка на существование операторов */
        while (!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("mod") ||
                operator.equals("%") || operator.equals("sqrt") || operator.equals("to10") || operator.equals("to2"))) {
            System.out.println("Неизвестный оператор");
            operator = sc.nextLine();
        }
        return operator;
    }
}
    

        

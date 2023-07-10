package homework05;

import java.util.Arrays;

/**
 * 1. Создать матрицу состоящую из строк 10х10.
 * 1.1 Все значения рандом  (число - 1.89345, строка - JkldTha)
 * 1.2 Каждое значение имеет по 7 символов
 * 1.3 Каждый третий элемент Double
 * 2. Взять её прямую и побочную диагональ сравнить их, являются ли они одинаковыми.
 * 2.1 Положить диагонали в новый массив.
 * (Про преобразования почитать. String.valueOf(), Double.parseDouble())
 * 3. Из нового массива:
 * 3.1 Если элемент является строкой то взять из нее со 2 по 4 элемент и положить в SB и
 * просто вывести их на экран через запятую.
 * 3.2 Если же числом то нужно округлить каждое число.
 * Если число ( 1,7 и больше то в большую сторону, если меньше то в меньшую сторону).
 * после сложить эти числа в массив. И этот массив вывести на экран, через знак подчеркивания.
 * 4 . также вывести на экран первоначальную матрицу.
 */
public class Main {
    private static String[][] matrix = new String[10][10];

    public static void main(String[] args) {
        initMatrix();
        System.out.println("Main diagonal:      " + Arrays.toString(mainDiagonal()));
        System.out.println("Secondary diagonal: " + Arrays.toString(secondaryDiagonal()));
        System.out.println("Are these diagonals equal? " + Arrays.equals(mainDiagonal(), secondaryDiagonal()));
        System.out.println("Common array: " + Arrays.toString(commonArray()));
        finalStringBuilderIfElementString(commonArray());
        finalArrayIfElementNumber(commonArray());
        printMatrix();
    }

    private static void initMatrix() {
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (count % 3 == 0) {
                    matrix[i][j] = String.format("%.5f", Math.random() * 5);
                } else {
                    matrix[i][j] = randomString();
                }
                count++;
            }
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String randomString() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        StringBuilder generatedString = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            int index = (int) (letters.length() * Math.random());
            generatedString.append(letters.charAt(index));
        }
        return generatedString.toString();
    }

    private static String[] mainDiagonal() {
        String[] mainArray = new String[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            mainArray[i] = matrix[i][i];
        }
        return mainArray;
    }

    private static String[] secondaryDiagonal() {
        String[] secondaryArray = new String[matrix.length];
        int j = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            j--;
            secondaryArray[i] = matrix[i][j];
        }
        return secondaryArray;
    }

    private static String[] commonArray() {
        String[] commonArray = new String[mainDiagonal().length + secondaryDiagonal().length];
        System.arraycopy(mainDiagonal(), 0, commonArray, 0, mainDiagonal().length);
        System.arraycopy(secondaryDiagonal(), 0, commonArray, mainDiagonal().length, secondaryDiagonal().length);
        return commonArray;
    }

    private static void finalStringBuilderIfElementString(String[] commonArray) {
        StringBuilder finalString = new StringBuilder();
        for (String s : commonArray) {
            if ((int) s.charAt(0) >= 65 && (int) s.charAt(0) <= 122) {   //65=A 122=z
                finalString.append(s.substring(1, 4));
                finalString.append(", ");
            }
        }
        System.out.println("Final string: " + finalString.delete(finalString.length() - 2, finalString.length() - 1));
    }

    private static void finalArrayIfElementNumber(String[] commonArray) {
        //узнаем сколько числовых типов будет в массиве
        int count = 0;
        for (String s : commonArray) {
            if ((int) s.charAt(0) >= 48 && (int) s.charAt(0) <= 57) {   //48=0 57=9
                count++;
            }
        }
        int[] finalArray = new int[count];
        int i = 0;
        for (String s : commonArray) {
            if ((int) s.charAt(0) >= 48 && (int) s.charAt(0) <= 57) {   //48=0 57=9
                String normalDoubleView = s.replace(',', '.');
                String firstDigitAfterPoint = normalDoubleView.substring(normalDoubleView.indexOf(".") + 1, 3);
                if (firstDigitAfterPoint.charAt(0) >= 55) {    //55=7
                    //округление в большую сторону
                    finalArray[i] = (int) Math.ceil(Double.parseDouble(normalDoubleView));
                    i++;
                } else {
                    //округление в меньшую сторону
                    finalArray[i] = (int) Math.floor(Double.parseDouble(normalDoubleView));
                    i++;
                }
            }
        }
        System.out.print("Final array:  ");
        for (i = 0; i < finalArray.length - 1; i++) {
            System.out.print(finalArray[i] + "_");
        }
        System.out.println(finalArray[i]);
    }

}
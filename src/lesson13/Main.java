package lesson13;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        extracted();
        extractedLambda();
        extractedLambda2();
        extractedLambda3();
        extractedMethodRefernce();
    }


    private static void extracted() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            /** КЛАССИЧЕСКАЯ РЕАЛИЗАЦИЯ АНОНИМНОГО КЛАССА
             * тут переопределяем компар в анонимно классе */
            @Override

            // модификатор доступа возвр тип (параметры) - это потом уберем
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparator.compare(25, 100));
    }


    private static void extractedLambda() {
        Comparator<Integer> comparator = (Integer o1, Integer o2) -> {
            return Integer.compare(o1, o2);
        };
        System.out.println(comparator.compare(25, 100));
    }

    private static void extractedLambda2() {
        Comparator<Integer> comparator = (Integer o1, Integer o2) -> Integer.compare(o1, o2);
        System.out.println(comparator.compare(25, 100));
    }

    private static void extractedLambda3() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator.compare(25, 100));
    }

    //сокращение до метод референс
    // дак делают когда сигнатура метода и ... совпадают
    private static void extractedMethodRefernce() {
        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(25, 100));
    }


}//Main

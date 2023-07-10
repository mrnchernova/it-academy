package homework02;

/**
 * 1. Создать два класса.
 * 2. Создать метод для запуска в одном классе. (метод main)
 * 3. Во втором классе создать глобальные переменные всех типов (примитивы и обертки).
 * 3.1 И для каждой глобальной переменной геттеры и сеттеры.
 * 4. В классе с методом для запуска создать глобальные переменные с различными типами (примитивами и обертками).
 * А также в методе (main) создать локальные переменные (примитивы и обертки).
 * 5. Поэкспериментировать с присвоением переменных друг в друга и приведением типов, посмотреть какие ошибки получаться.
 * 6. Геттеры и сеттеры обязательно использовать, т.е. установить и получить значение.
 * 7. Вывести все переменные на консоль. (вывод на экран)
 * 8. Создавать классы, методы, переменные со всеми правилами именования. (code convention)
 */

public class Main {
    public static byte simpleByte = 100;
    public static int simpleInt = 100;
    public static long simpleLong = 100L;
    public static float simpleFloat = 100.1F;
    public static boolean simpleBoolean = true;
    public static char simpleChar = 'A';
    public static String simpleString = "global string";

    public static Integer wrapperInteger = 200;
    public static Long wrapperLong = 200L;
    public static Double wrapperDouble = 200.20;
    public static Boolean wrapperBoolean = false;
    public static Character wrapperCharacter = 'W';

    public static void main(String[] args) {

        byte localSimpleByte = 100;
        int localSimpleInt = 1;
        long localSimpleLong = 1L;
        double localSimpleDouble = 1.3;
        boolean localSimpleBoolean = true;
        char localSimpleChar = 'c';
        String localSimpleString = "local string";


        Integer localWrapperInteger = 35;
        Long localWrapperLong = 2L;
        Float localWrapperFloat = 2.2F;
        Boolean localWrapperBoolean = true;
        Character localWrapperCharacter = 'w';


        System.out.println("\nЦелочисленные переменные");
        var x = 0;
        x = (byte) (localSimpleByte + localWrapperInteger); //100 + 35 = -121. Результат вышел за пределы диапазона byte
        System.out.println("byte 100 + 35 = " + x);

        x = localSimpleByte + localWrapperInteger; //100 + 35 = 135. Получен результат типа int
        System.out.println("Integer 100 + 35 = " + x);

        SecondClass secondClass = new SecondClass();
        secondClass.setSimpleByte((byte) 3);
        secondClass.setWrapperFloat(2.3F);
        System.out.println("getter and setter: " + (secondClass.getSimpleByte() + secondClass.getWrapperFloat()));

        int i = (int) (localSimpleLong + simpleInt); //нужно привести выражение к типу int
        long l = localSimpleLong + simpleInt;        //не нужно ничего приводить
        System.out.println("i = " + i + "\nl = " + l);


        System.out.println("\nВещественные переменные");
        float f = (float) (simpleFloat + localSimpleDouble);
        System.out.println("f = " + f);

        double d = simpleFloat + localSimpleDouble;
        System.out.println("d = " + d);

        System.out.println("\nСложение целочисленных и вещественных переменных");
        secondClass.setSimpleLong(100L);
        secondClass.setWrapperDouble(0.500);
        long l1 = (long) (localSimpleInt + secondClass.getWrapperDouble());
        System.out.println("long l1 = " + l1); //получим 1 т.к. приводим к целочисленному типу
        Double d1 = localSimpleInt + secondClass.getWrapperDouble();
        System.out.println("Double d1 = " + d1); // по умолчанию выражение будет типа double

        System.out.println("\nСтроки и символы");
        secondClass.setSimpleChar('Y');
        simpleChar = secondClass.getSimpleChar();
        System.out.println("Получаем и выводим символ из другого класса: " + secondClass.getSimpleChar());

        secondClass.setSimpleString("example");
        simpleString = localSimpleString + " --- " + secondClass.getSimpleString();
        System.out.println("Сложение строк: " + simpleString);

//        simpleChar = secondClass.getSimpleString();  //Ошибка! Нельзя присвоить типу char целую строку

        secondClass.setSimpleString(String.valueOf(simpleChar)); //можно присвоить символ строке
        System.out.println("Строка \"example\" заменена на \"" + secondClass.getSimpleString() + "\"");



    }
}

package homework11.order;

import java.io.File;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

public class Utils {
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static File fileOrder = Path.of("src", "homework11", "order", "order.txt").toFile();
    public static File fileProduct = Path.of("src", "homework11", "order", "product.txt").toFile();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static final String MENU = ANSI_YELLOW + "1. Список товаров\n" +
            "2. Добавить товар\n" +
            "3. Удалить товар\n" +
            "4. Список заказов\n" +
            "5. Добавить заказ\n" +
            "6. Удалить заказ\n" +
            "0. Выход" + ANSI_RESET;
    public static final String UNKNOWN_ITEM = ANSI_RED + "Неверный пункт" + ANSI_RESET;
    public static final String PRODUCT_REMOVED_BY_ID = ANSI_GREEN + "Товар с id=%d удален\n" + ANSI_RESET;
    public static final String ORDER_REMOVED_BY_ID = ANSI_GREEN + "Заказ с id=%d удален\n" + ANSI_RESET;
    public static final String UNKNOWN_PRODUCT_BY_ID = ANSI_RED + "Товар с id=%d не был найден\n" + ANSI_RESET;
    public static final String UNKNOWN_ORDER_BY_ID = ANSI_RED + "Заказ с id=%d не был найден\n" + ANSI_RESET;
    public static final String ENTER_PRODUCT_ID = ANSI_YELLOW + "Укажите id товара" + ANSI_RESET;
    public static final String ENTER_ORDER_ID = ANSI_YELLOW + "Укажите id заказа" + ANSI_RESET;


}

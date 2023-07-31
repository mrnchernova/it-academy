package homework11.order;

import java.io.*;
import java.nio.file.Path;
import java.util.Random;

/**
 * 1. В программе должно быть  две сущности Заказ и Товар.
 * 2. Должно быть два файла для заказов и товаров
 * 3. Каждый товар должен иметь как минимум следующие поля:
 * идентификатор
 * название товара
 * дату изготовления
 * 4. Каждый заказ должен иметь:
 * идентификатор
 * список товаров
 * дату оформления заказа
 * 5. Продумать консольное меню.
 * С консоли нужно иметь возможность:
 * выводить список товаров на экран,
 * добавить товар.
 * удалить товар
 * 6. Тоже самое с заказами.
 * <p>
 * Использовать все что знаете.
 * В файлах должны остатся изменения после окончания работы программы.
 * Программа не закончит работу пока этого не захочет пользователь (написать условия выхода из программы)
 */
public class Main {
    public static File fileOrder = Path.of("src", "homework11", "order", "order.txt").toFile();
    public static File fileProduct = Path.of("src", "homework11", "order", "product.txt").toFile();
    public static Random rand = new Random();
    public static int lastId = 0;
    public static void main(String[] args) {
        
        // Читает product.txt, переносит его в ArrayList и запоминает последний id
        lastId = Product.initFile(fileProduct);
        
        Menu.menu();
    }
}

package homework11.order;

import java.io.*;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    public static final String MENU = "1. Список товаров\n" +
            "2. Добавить товар\n" +
            "3. Удалить товар\n" +
            "4. Список заказов\n" +
            "5. Добавить заказ\n" +
            "6. Удалить заказ\n" +
            "0. Выход";
    public static final String UNKNOWN_ITEM = "Неверный пункт";
    static Scanner sc = new Scanner(System.in);

    public static void menu() {

        int item = -1;
        while (item != 0) {
            System.out.println(MENU);
            try {
                item = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(UNKNOWN_ITEM);
                sc.next();
            }
            switch (item) {
                case 1:
                    readFile(Main.fileProduct);
                    break;
                case 2:
                    writeFile(Main.fileProduct);
                    break;
                case 3:
                    Product.removeProduct(Main.fileProduct, sc.nextInt());
                    break;
                case 0:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println(UNKNOWN_ITEM);
                    break;
            }
        }


    }

    public static void readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str = reader.lines().collect(Collectors.joining("\n"));
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---");
    }

    public static void writeFile(File file){
        Product.addProduct(file);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // todo: for(T smth: T.listOfSmth){writer.append(smth.toString());}
            for (Product product: Product.listOfProducts) {
                writer.append(product.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void removeItem(File file){
        
    }
    
}

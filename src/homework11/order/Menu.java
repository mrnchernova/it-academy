package homework11.order;

import java.util.InputMismatchException;

public class Menu {
    public static int lastProductId = 0;
    public static int lastOrderId = 0;

    public static void menu() {
        // Читает txt, переносит его в массив и передает последний id
        lastProductId = FileService.initFile(Utils.fileProduct, Product.listOfProducts);
        lastOrderId = FileService.initFile(Utils.fileOrder, Order.listOfOrders);

        int item = -1;
        while (item != 0) {
            System.out.println(Utils.MENU);
            try {
                item = Utils.sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(Utils.UNKNOWN_ITEM);
                Utils.sc.next();
            }
            switch (item) {
                case 1:
                    FileService.readFile(Utils.fileProduct);
                    break;
                case 2:
                    Product.addProduct();                                                   // добавляется новый продукт
                    FileService.writeToFile(Utils.fileProduct, Product.listOfProducts);     // перезаписывается файл txt
                    break;
                case 3:
                    System.out.println(Utils.ENTER_PRODUCT_ID);
                    Product.removeProduct(checkId());                                       // удаляется продукт
                    FileService.writeToFile(Utils.fileProduct, Product.listOfProducts);     // из массива записывается все в txt
                    break;
                case 4:
                    FileService.readFile(Utils.fileOrder);
                    break;
                case 5:
                    Order.addOrder();                                               // добавляется новый продукт
                    FileService.writeToFile(Utils.fileOrder, Order.listOfOrders);   // перезаписывается файл txt
                    break;
                case 6:
                    System.out.println(Utils.ENTER_ORDER_ID);
                    Order.removeOrder(checkId());                                   // удаляется продукт
                    FileService.writeToFile(Utils.fileOrder, Order.listOfOrders);   // из массива записывается все в txt
                    break;
                case 0:
                    Utils.sc.close();
                    System.exit(0);
                default:
                    System.out.println(Utils.UNKNOWN_ITEM);
                    break;
            }
        }
    }
    public static int checkId(){
        while (!Utils.sc.hasNextInt()){
            System.out.println(Utils.UNKNOWN_ITEM);
            Utils.sc.next();
        }
       return Utils.sc.nextInt();
    }
}

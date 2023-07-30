package homework11.order;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Product {

    private static int counter = Main.lastId;

    private int productId;
    private String product;
    private Date dateOfManufacture;


    static List<Product> listOfProducts = new ArrayList<>();

    public static void addProduct(File file) {
        listOfProducts.add(new Product("product" + Main.rand.nextInt(100),
                new Date(120, Main.rand.nextInt(13) + 1, Main.rand.nextInt(32) + 1)));
    }

    public static int initProduct(File file) {
        int id = 0;
        // если файл не пустой, то парсить
        if (file.length() != 0L) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String str;
                while ((str = reader.readLine()) != null) {

                    String[] productItem = str.split("\\|");
                    id = Integer.parseInt(productItem[0].trim());
                    productItem[1] = productItem[1].trim();

                    SimpleDateFormat format = new SimpleDateFormat();
                    format.applyPattern("dd.MM.yyyy");

                    try {
                        Date date = format.parse(productItem[2].trim());
                        listOfProducts.add(new Product(id, productItem[1], date));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return id;
    }


    public Product() {
    }

    public Product(String product, Date dateOfManufacture) {
//        this.productId = ++counter;
        this.productId = ++Main.lastId;
        this.product = product;
        this.dateOfManufacture = dateOfManufacture;
    }

    public Product(int productId, String product, Date dateOfManufacture) {
        this.productId = productId;
        this.product = product;
        this.dateOfManufacture = dateOfManufacture;
    }

    public int getProductId() {
        return productId++;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product1 = (Product) o;
        return Objects.equals(product, product1.product) && Objects.equals(dateOfManufacture, product1.dateOfManufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, dateOfManufacture);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return productId + " | " + product + " | " + sdf.format(dateOfManufacture);
    }
}

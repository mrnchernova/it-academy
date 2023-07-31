package homework11.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Product {
    private int productId;
    private String product;
    private Date dateOfManufacture;

    private static int counter = Menu.lastProductId;
    static List<Product> listOfProducts = new ArrayList<>();

    public static void addProduct() {
        listOfProducts.add(new Product("product" + Utils.rand.nextInt(100),
                new Date(120, Utils.rand.nextInt(13) + 1, Utils.rand.nextInt(32) + 1)));
    }

    public static void removeProduct(int id) {
        boolean isRemoved = false;
        for (int i = 0; i < listOfProducts.size(); i++) {
            if (listOfProducts.get(i).productId == id) {
                listOfProducts.remove(i);
                System.out.printf(Utils.PRODUCT_REMOVED_BY_ID, id);
                isRemoved = true;
            }
        }
        if (!isRemoved) {
            System.out.printf(Utils.UNKNOWN_PRODUCT_BY_ID, id);
        }
        for (Product p : listOfProducts) {
            System.out.println(p);
        }
        System.out.println();
    }

    public Product() {
    }

    public Product(String product, Date dateOfManufacture) {
        this.productId = ++Menu.lastProductId;
        this.product = product;
        this.dateOfManufacture = dateOfManufacture;
    }

    public Product(int productId, String product, Date dateOfManufacture) {
        this.productId = productId;
        this.product = product;
        this.dateOfManufacture = dateOfManufacture;
    }

    public int getId() {
        return productId++;
    }

    public void setId(int productId) {
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

        return productId + " | " + product + " | " + Utils.simpleDateFormat.format(dateOfManufacture);
    }
}

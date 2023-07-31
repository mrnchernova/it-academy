package homework11.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {
    private int orderId;
    private String order;
    private Date dateOfRegistration;

    private static int counter = Menu.lastOrderId;
    static List<Order> listOfOrders = new ArrayList<>();

    public static void addOrder() {
        listOfOrders.add(new Order("order" + Utils.rand.nextInt(100),
                new Date(122, Utils.rand.nextInt(13) + 1, Utils.rand.nextInt(32) + 1)));
    }

    public static void removeOrder(int id) {
        boolean isRemoved = false;
        for (int i = 0; i < listOfOrders.size(); i++) {
            if (listOfOrders.get(i).orderId == id) {
                listOfOrders.remove(i);
                System.out.printf(Utils.ORDER_REMOVED_BY_ID, id);
                isRemoved = true;
            }
        }
        if (!isRemoved) {
            System.out.printf(Utils.UNKNOWN_ORDER_BY_ID, id);
        }
        for (Order o : listOfOrders) {
            System.out.println(o);
        }
        System.out.println();
    }

    public Order() {
    }

    public Order(String order, Date dateOfRegistration) {
        this.orderId = ++Menu.lastOrderId;
        this.order = order;
        this.dateOfRegistration = dateOfRegistration;
    }

    public Order(int orderId, String order, Date dateOfRegistration) {
        this.orderId = orderId;
        this.order = order;
        this.dateOfRegistration = dateOfRegistration;
    }

    public int getOrderId() {
        return orderId++;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(this.order, order.order) && Objects.equals(dateOfRegistration, order.dateOfRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, dateOfRegistration);
    }

    @Override
    public String toString() {
        return orderId + " | " + order + " | " + Utils.simpleDateFormat.format(dateOfRegistration);
    }
}

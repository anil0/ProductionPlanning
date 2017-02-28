import java.util.Date;

/**
 * Created by anil on 27/02/2017.
 */
public class Order {
    private int orderNumber;
    private Date latestStartDate;

    public Order(int orderNumber, Date latestStartDate) {
        this.orderNumber = orderNumber;
        this.latestStartDate = latestStartDate;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Date getLatestStartDate() {
        return latestStartDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", latestStartDate=" + latestStartDate +
                '}';
    }
}

import java.util.Arrays;

/**
 * Created by anil on 27/02/2017.
 */
public class Order {
    private int orderNumber;
    private String latestStartDate;
    private Worker workers;

    public Order(int orderNumber, String latestStartDate) {
        this.orderNumber = orderNumber;
        this.latestStartDate = latestStartDate;
    }

    public Order(int orderNumber, String latestStartDate, Worker workers) {
        this.orderNumber = orderNumber;
        this.latestStartDate = latestStartDate;
        this.workers = workers;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getLatestStartDate() {
        return latestStartDate;
    }

    public Worker getWorkers() {
        return workers;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", latestStartDate=" + latestStartDate +
                '}';
    }
}

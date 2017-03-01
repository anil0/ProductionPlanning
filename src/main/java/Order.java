import java.util.Arrays;
import java.util.Date;

/**
 * Created by anil on 27/02/2017.
 */
public class Order {
    private int orderNumber;
    private Date latestStartDate;
    private Worker[] workers;

    public Order(int orderNumber, Date latestStartDate) {
        this.orderNumber = orderNumber;
        this.latestStartDate = latestStartDate;
    }

    public Order(int orderNumber, Date latestStartDate, Worker[] workers) {
        this.orderNumber = orderNumber;
        this.latestStartDate = latestStartDate;
        this.workers = workers;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Date getLatestStartDate() {
        return latestStartDate;
    }

    public Worker[] getWorkers() {
        return workers;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", latestStartDate=" + latestStartDate +
                ", workers=" + Arrays.toString(workers) +
                '}';
    }
}

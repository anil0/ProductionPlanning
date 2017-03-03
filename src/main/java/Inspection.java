/**
 * Created by anil on 02/03/2017.
 */
public class Inspection {
    //date of inspection
    //item being inspected
    //order number
    //the inspector
    //cause of rejection

    private String dateOfInspection;
    private Item item;
    private Order order;
    private Worker worker;
    private String causeOfRejection;

    public Inspection(String dateOfInspection, Item item, Order order, Worker worker, String causeOfRejection) {
        this.dateOfInspection = dateOfInspection;
        this.item = item;
        this.order = order;
        this.worker = worker;
        this.causeOfRejection = causeOfRejection;
    }

    public String getDateOfInspection() {
        return dateOfInspection;
    }

    public Item getItem() {
        return item;
    }

    public Order getOrder() {
        return order;
    }

    public Worker getWorker() {
        return worker;
    }

    public String getCauseOfRejection() {
        return causeOfRejection;
    }

    @Override
    public String toString() {
        return "Inspection{" +
                "dateOfInspection='" + dateOfInspection + '\'' +
                ", item=" + item +
                ", order=" + order +
                ", worker=" + worker +
                ", causeOfRejection='" + causeOfRejection + '\'' +
                '}';
    }
}

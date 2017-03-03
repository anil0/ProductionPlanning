import java.util.List;

/**
 * Created by anil on 02/03/2017.
 */
public class Material
{
    private Order order;
    private List<Quantity> items;

    public Material(Order order, List<Quantity> items) {
        this.order = order;
        this.items = items;
    }

    public Order getOrder() {
        return order;
    }

    public List<Quantity> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "{" +
                "orderNumber = " + order.getOrderNumber() +
                ", \n items: " + "\n " + items + "\n" +
                '}';
    }
}

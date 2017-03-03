/**
 * Created by anil on 02/03/2017.
 */
public class Quantity
{
    private Item item;
    private int quantity;

    public Quantity(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "item=" + item.getItemName() +
                ", quantity=" + quantity +
                '}' + "\n";
    }
}

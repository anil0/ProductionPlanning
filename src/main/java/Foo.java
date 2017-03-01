/**
 * Created by anilrahman on 01/03/2017.
 */
public class Foo
{
    private int orderId;
    private int week;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public Foo(int orderId, int week) {
        this.orderId = orderId;
        this.week = week;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "orderId=" + orderId +
                ", week=" + week +
                '}';
    }
}

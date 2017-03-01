import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by anil on 27/02/2017.
 */
public class Day {
    Date date;
    String month;
    String day;
    Order[] order;
    int weekNum;
    Worker[] workers;

    List<Foo> foo = new ArrayList<>();


//    String dayName;
//    Order order;


    public Day(Date date, Order[] order, int weekNum) {
        this.date = date;
        this.order = order;
        this.weekNum = weekNum;

    }

    public Day(Date date, int weekNum) {
        this.date = date;
        this.weekNum = weekNum;
    }

    public Day(Date date, int weekNum, Worker[] workers) {
        this.date = date;
        this.weekNum = weekNum;
        this.workers = workers;
    }

    public Day(Date date, int weekNum, Order[] orders) {
        this.date = date;
        this.weekNum = weekNum;
        this.order = orders;
    }

    public Day(Date date, String month, String day) {
        this.date = date;
        this.month = month;
        this.day = day;
    }

    public Day(Date date, String month, String day, Order[] order) {
        this.date = date;
        this.month = month;
        this.day = day;
        this.order = order;
    }

    public Date getDate() {
        return date;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public Order[] getOrder() {
        return order;
    }

    public int getWeekNum() {
        return weekNum;
    }

    public Worker[] getWorkers() {
        return workers;
    }


    public List<Foo> getFoo() {
        return foo;
    }

    public void setFoo(List<Foo> foo) {
        this.foo = foo;
    }

    @Override
    public String toString() {
        return "Day: " + date +
                "\t" + weekNum +
                "\t order = " + foo;
    }
}

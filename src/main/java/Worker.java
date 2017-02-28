/**
 * Created by anil on 28/02/2017.
 */
public class Worker {
    private int id;
    private String type; //full or contract
    private boolean isOnHoliday;

    public Worker(int id, String type, boolean isOnHoliday) {
        this.id = id;
        this.type = type;
        this.isOnHoliday = isOnHoliday;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isOnHoliday() {
        return isOnHoliday;
    }
}

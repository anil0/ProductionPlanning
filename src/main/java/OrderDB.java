/**
 * Created by anilrahman on 28/04/2017.
 */
public class OrderDB {
    private String id;
    private int dateCreated;
    private int estimatedTimeArrival;
    private int weekNum;
    private String bikeType;
    private String type;
    private Status status;
    private String customerId;

    public OrderDB(String id, int dateCreated, int estimatedTimeArrival, int weekNum, String bikeType, String type, Status status, String customerId) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.estimatedTimeArrival = estimatedTimeArrival;
        this.weekNum = weekNum;
        this.bikeType = bikeType;
        this.type = type;
        this.status = status;
        this.customerId = customerId;
    }

    public OrderDB(String id, String bikeType, Status status, String customerId) {
        this.id = id;
        this.bikeType = bikeType;
        this.status = status;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(int dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getEstimatedTimeArrival() {
        return estimatedTimeArrival;
    }

    public void setEstimatedTimeArrival(int estimatedTimeArrival) {
        this.estimatedTimeArrival = estimatedTimeArrival;
    }

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "OrderDB{" +
                "id='" + id + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", estimatedTimeArrival='" + estimatedTimeArrival + '\'' +
                ", weekNum=" + weekNum +
                ", bikeType='" + bikeType + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}

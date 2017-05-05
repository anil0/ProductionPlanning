import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/**
 * Created by anilrahman on 28/04/2017.
 */
public class Parser {

    public OrderDB parseJson(String s)
    {
        return parseObj( s );
    }

    public OrderDB parseObj(String s)
    {
        //final JsonArray jsonArray = new JsonArray( s );
        //JsonElement jsonElement = s;

        JsonElement jelement = new JsonParser().parse( s );
        JsonObject  jobject = jelement.getAsJsonObject();

        JsonElement id = jobject.get("_id");
        JsonObject jobject2 = jobject.getAsJsonObject("data");

        //jObject2 gives all data object
        //id gives _id of each

        String id2 = jobject.get("_id").toString();
        int dateCreated = Integer.parseInt(jobject2.get("dateCreated").toString());
        int eta = Integer.parseInt(jobject2.get("eta").toString());
        int forWeek = Integer.parseInt(jobject2.get("forWeek").toString());
        String bikeType = jobject2.get("bikeType").toString();
        String type = jobject2.get("type").toString();
        String status = jobject2.get("status").toString();
        String customerId = jobject2.get("customer").toString();

        return parseOrder( id, jobject2 );
    }

    private OrderDB parseOrder(JsonElement id, JsonObject jobject)
    {
        //String id2 = jobject.get("_id").toString();
        int dateCreated = Integer.parseInt(jobject.get("dateCreated").toString());
        int eta = Integer.parseInt(jobject.get("eta").toString());
        int forWeek = Integer.parseInt(jobject.get("forWeek").toString());
        String bikeType = jobject.get("bikeType").toString();
        String type = jobject.get("type").toString();
        Status status = checkStatusType( jobject.get("status").toString() );
        String customerId = jobject.get("customer").toString();

        return new OrderDB( id.toString(), dateCreated, eta, forWeek, bikeType, type, status, customerId );
    }

    private Status checkStatusType(String status)
    {
        if(status.equals("\"Awaiting Materials\""))
        {
            return Status.AWAITINGMATERIALS;
        }
        else if(status.equals("\"In Production\""))
        {
            return Status.INPRODUCTION;
        }
        else if(status.equals("\"Complete\""))
        {
            return Status.COMPLETE;
        }
        else if(status.equals("\"Awaiting Production\""))
        {
            return Status.AWAITINGPRODUCTION;
        }

        return null;
    }

}

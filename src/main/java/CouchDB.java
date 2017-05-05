import com.google.gson.JsonObject;
import org.lightcouch.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anilrahman on 28/04/2017.
 */
public class CouchDB {
    List<OrderDB> orderListFromMaterials = new ArrayList<>();

    CouchDbProperties properties = new CouchDbProperties()
//            .setDbName("bikesystem")
//            .setProtocol("http")
//            .setHost("e0111b55.ngrok.io")
            //.setHost("10.188.68.112")
            //.setPort(5984)
            .setDbName("bikesystem")
            .setProtocol("http")
            .setHost("o.tcp.eu.ngrok.io")
            .setPort( 14725 )
//            .setUsername("admin")
//            .setPassword("9999567890")
            .setMaxConnections(100)
            .setConnectionTimeout(0);

    CouchDbClient dbClient = new CouchDbClient(properties);

    // Client is ready to use

    public void showView()
    {

        // views
        List<JsonObject> list = dbClient.view("orders/ordersByIdForProduction")//transactions/transactionsByProduction")
                .includeDocs(true)
                .query(JsonObject.class);

        System.out.println(list.size());
        Parser parser = new Parser();

        for (JsonObject foo : list)
        {
            System.out.println("doc : " + foo);
            orderListFromMaterials.add( parser.parseJson(foo.toString()) );
        }

    }

    public void shutdown()
    {
        // shutdown the client
        dbClient.shutdown();
    }

    public List<OrderDB> getOrderListFromMaterials() {
        return orderListFromMaterials;
    }

}

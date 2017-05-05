import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by anil on 04/05/2017.
 */
public class MainFx extends Application {

    private List<OrderDB> newListOrders = new ArrayList<>();
    TableView<OrderDB> table;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Hello World!");

        //CouchDB couchDB = new CouchDB();
        //couchDB.showView();
        //newListOrders = couchDB.getOrderListFromMaterials();

        //sort the list based on week number of order
        //Collections.sort(newListOrders, (p1, p2) -> p1.getWeekNum() - p2.getWeekNum());

        Label label0 = new Label("Awaiting Materials");
        label0.setTranslateX(0); //centre
        label0.setTranslateY(-80); // go up 60px
        label0.setFont(new Font("Helvetica",30));


        Label label1 = new Label("");
        label1.setTranslateX(0); //centre
        label1.setTranslateY(-40); // go up 60px
        label1.setFont(new Font("Helvetica",24));
        label1.setStyle("-fx-border-color: white; -fx-background-color: white;");
        //Awaiting materials
        label1.setText(String.valueOf( countStatus("materials") ) + " / " + newListOrders.size());

        Label label2 = new Label("Awaiting Production");
        label2.setTranslateX(0); //centre
        label2.setTranslateY(20); // go up 60px
        label2.setFont(new Font("Helvetica",30));

        Label label3 = new Label("");
        label3.setTranslateX(0); //centre
        label3.setTranslateY(60); // go up 60px
        label3.setFont(new Font("Helvetica",24));
        label3.setStyle("-fx-border-color: white; -fx-background-color: white;");
        //Awaiting materials
        label3.setText(String.valueOf( countStatus("production") ) + " / " + newListOrders.size());

        Label label4 = new Label("Orders");
        label4.setTranslateY(-190); // go up 60px
        label4.setFont(new Font("Helvetica",32));

        Label label5 = new Label("Week 1");
        label5.setTranslateX(-100); //centre
        label5.setTranslateY(-150); // go up 60px
        label5.setFont(new Font("Helvetica",24));
        label5.setStyle("-fx-border-color: white; -fx-background-color: white;");
        //Awaiting materials
        //label5.setText( String.valueOf( countWeekOrders( 1 ) + " / " + newListOrders.size() ) );

        Label label6 = new Label("");
        label6.setTranslateX(-100); //centre
        label6.setTranslateY(-120); // go up 60px
        label6.setFont(new Font("Helvetica",24));
        label6.setStyle("-fx-border-color: white; -fx-background-color: white;");
        label6.setText( String.valueOf( countWeekOrders( 1 ) ) );

        Label label7 = new Label("Week 2");
        label7.setTranslateX(0); //centre
        label7.setTranslateY(-150); // go up 60px
        label7.setFont(new Font("Helvetica",24));
        label7.setStyle("-fx-border-color: white; -fx-background-color: white;");
        //Awaiting materials
        //label5.setText( String.valueOf( countWeekOrders( 1 ) + " / " + newListOrders.size() ) );

        Label label8 = new Label("");
        label8.setTranslateX(0); //centre
        label8.setTranslateY(-120); // go up 60px
        label8.setFont(new Font("Helvetica",24));
        label8.setStyle("-fx-border-color: white; -fx-background-color: white;");
        label8.setText( String.valueOf( countWeekOrders( 2 ) ) );

        Label label9 = new Label("Week 3");
        label9.setTranslateX(97); //centre
        label9.setTranslateY(-150); // go up 60px
        label9.setFont(new Font("Helvetica",24));
        label9.setStyle("-fx-border-color: white; -fx-background-color: white;");
        //Awaiting materials
        //label5.setText( String.valueOf( countWeekOrders( 1 ) + " / " + newListOrders.size() ) );

        Label label10 = new Label("");
        label10.setTranslateX(97); //centre
        label10.setTranslateY(-120); // go up 60px
        label10.setFont(new Font("Helvetica",24));
        label10.setStyle("-fx-border-color: white; -fx-background-color: white;");
        label10.setText( String.valueOf( countWeekOrders( 3 ) ) );


        //table view
        table = new TableView();
        TableColumn<OrderDB, String> idCol = new TableColumn<>("ID");
        idCol.setMinWidth(200);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<OrderDB, String> bikeCol = new TableColumn<>("BikeType");
        bikeCol.setMinWidth(200);
        bikeCol.setCellValueFactory(new PropertyValueFactory<>("bikeType"));

        TableColumn<OrderDB, Status> statusCol = new TableColumn<>("Status");
        statusCol.setMinWidth(200);
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<OrderDB, String> customerCol = new TableColumn<>("CustomerID");
        customerCol.setMinWidth(200);
        customerCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        table.setItems(getObservableList());
        table.getColumns().addAll(idCol, bikeCol, statusCol, customerCol);
        //table.setTranslateX(0);
        table.setTranslateY(450);
        table.resize(100,100);


//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>()
//        {
//            @Override
//            public void handle(ActionEvent event)
//            {
//                System.out.println("---------------------------");
//                for (OrderDB orderDB : newListOrders)
//                {
//                    System.out.println(orderDB);
//                }
//            }
//        });

        StackPane root = new StackPane();
        //root.getChildren().add(btn);
        root.getChildren().add(label0);
        root.getChildren().add(label1);
        root.getChildren().add(label2);
        root.getChildren().add(label3);
        root.getChildren().add(label4);
        root.getChildren().add(label5);
        root.getChildren().add(label6);
        root.getChildren().add(label7);
        root.getChildren().add(label8);
        root.getChildren().add(label9);
        root.getChildren().add(label10);
        root.getChildren().add(table);


        primaryStage.setScene(new Scene(root, 800, 700));
        primaryStage.show();
    }

    public int countStatus(String type)
    {
        int count = 0;
        if(type.equals("materials"))
        {
            for (OrderDB newListOrder : newListOrders)
            {
                if (newListOrder != null)
                {
                    if (newListOrder.getStatus().equals(Status.AWAITINGMATERIALS))
                    {
                        count++;
                    }
                }
            }
        }
        else if(type.equals("production"))
        {
            for (OrderDB newListOrder : newListOrders)
            {
                if (newListOrder != null)
                {
                    if (newListOrder.getStatus().equals(Status.AWAITINGPRODUCTION))
                    {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public int countWeekOrders(int week)
    {
        int count = 0;

        for (OrderDB newListOrder : newListOrders)
        {
            if(newListOrder.getWeekNum() == week)
            {
                count++;
            }
        }

        return count;
    }

    public ObservableList<OrderDB> getObservableList()
    {
        ObservableList<OrderDB> observableList = FXCollections.observableArrayList();
        for (OrderDB newListOrder : newListOrders)
        {
            observableList.add( newListOrder );
        }
        return observableList;
    }
}

package restaurant.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class EntryController implements Initializable {
    private double x, y;
    private Map<Integer, Button> tableId = new HashMap<Integer, Button>();

    @FXML private Button table1;
    @FXML private Button table2;
    @FXML private Button table3;
    @FXML private Button table4;
    @FXML private Button table5;
    @FXML private Button table6;
    @FXML private Button table7;
    @FXML private Button table8;
    @FXML private Button table9;
    @FXML private Button table10;
    @FXML private Button table11;
    @FXML private Button table12;
    @FXML private Button btnLogin;

    @FXML
    public void onDragTopBar(MouseEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    public void onPressTopBar(MouseEvent event){
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    public void onCloseWindow(MouseEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onHideWindow(MouseEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void onTableSelect(MouseEvent event){
        Button table = (Button)event.getSource();
        table.setStyle("-fx-background-color: #E40000");
        table.setDisable(true);
        System.out.println("Customer in! Table full." + table.getId());
    }

    @FXML
    public void onRedirectLogin(MouseEvent event){
        System.out.println("Go to login and WORK");
    }

    //TO-DO: add Integer id parameter and update with tableId.get(id)
    //just testing
    public void onTableFree(){
        Button table = tableId.get(2);
        table.setStyle("-fx-background-color: #00C64F");
        table.setDisable(false);
        System.out.println("Customer out! Table free." );
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        tableId.put(1, table1);
        tableId.put(2, table2);
        tableId.put(3, table3);
        tableId.put(4, table4);
        tableId.put(5, table5);
        tableId.put(6, table6);
        tableId.put(7, table7);
        tableId.put(8, table8);
        tableId.put(9, table9);
        tableId.put(10, table10);
        tableId.put(11, table11);
        tableId.put(12, table12);
    }
}

package restaurant.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class WaiterViewController implements Initializable {
    private double x, y;
    private Map<Integer, Button> tablesMap = new HashMap<Integer, Button>();

    @FXML private Button waiterT1;
    @FXML private Button waiterT2;
    @FXML private Button waiterT3;
    @FXML private Button waiterT4;
    @FXML private Button waiterT5;
    @FXML private Button waiterT6;
    @FXML private Button waiterT7;
    @FXML private Button waiterT8;
    @FXML private Button waiterT9;
    @FXML private Button waiterT10;
    @FXML private Button waiterT11;
    @FXML private Button waiterT12;

    @FXML private Label waiterName;

    //top bar methods
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

    //content methods
    @FXML
    public void createReceipt() {
        //TO-DO: delete after mocks are no longer necessary
        System.out.println("Create receipt.");
        setUser("Mada");
        changeTableStatus(2, false);
    }

    @FXML
    public void modifyOrder() {
        //TO-DO: delete after mocks are no longer necessary
        System.out.println("Modify order.");
        changeTableStatus(2, true);
    }

    @FXML
    public void logout() {
        //TO-DO: delete after mocks are no longer necessary
        System.out.println("Logout.");
        mockSetDesignatedTables();
    }

    public void setUser(String name) {
        waiterName.setText("Logged as " + name);
    }

    public void setDesignatedTables(List<Integer> list){
        list.forEach(i -> {
            tablesMap.get(i).setDisable(false);
        } );
    }

    public void changeTableStatus(Integer table, boolean isEmpty) {
        if (isEmpty) {
            tablesMap.get(table).setStyle("-fx-background-color: #00C64F");
        } else {
            tablesMap.get(table).setStyle("-fx-background-color: #E40000");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        waiterName.setAlignment(Pos.CENTER);
        initializeMap();
        tablesMap.forEach((k,v) -> v.setDisable(true));
    }

    //mocked methods
    //TO-DO: delete after mocks are no longer necessary
    public void mockSetDesignatedTables() {
        ArrayList<Integer> mockList = new ArrayList<Integer>();
        mockList.add(1);
        mockList.add(2);
        mockList.add(4);
        setDesignatedTables(mockList);
    }

    public void initializeMap(){
        tablesMap.put(1, waiterT1);
        tablesMap.put(2, waiterT2);
        tablesMap.put(3, waiterT3);
        tablesMap.put(4, waiterT4);
        tablesMap.put(5, waiterT5);
        tablesMap.put(6, waiterT6);
        tablesMap.put(7, waiterT7);
        tablesMap.put(8, waiterT8);
        tablesMap.put(9, waiterT9);
        tablesMap.put(10, waiterT10);
        tablesMap.put(11, waiterT11);
        tablesMap.put(12, waiterT12);

    }

}

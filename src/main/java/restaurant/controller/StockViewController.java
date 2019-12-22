package restaurant.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

import restaurant.entity.menu.Menu;

public class StockViewController implements Initializable {
    private double x, y;

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
    public void addItems() {
        System.out.println("Add items.");
    }

    @FXML
    public void deleteItems() {
        System.out.println("Delete items.");
    }

    @FXML
    public void saveChanges() {
        System.out.println("Save changes");
    }

    @FXML
    public void actionBack() {
        System.out.println("Go back.");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
    }
}

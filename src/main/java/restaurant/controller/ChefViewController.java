package restaurant.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class ChefViewController implements Initializable {
    private double x, y;
    private EntryViewController mainController;

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
    public void setReady() {
        System.out.println("Order ready. Notify table x and waiter y.");
    }

    @FXML
    public void setDeclined() {
        System.out.println("Order declined. Notify table x and waiter y.");
    }

    @FXML
    public void saveChanges() {
        System.out.println("Save changes");
    }

    @FXML
    public void logoutChef() {
        System.out.println("Go back.");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
    }

    public EntryViewController getMainController() {
        return mainController;
    }

    public void setMainController(EntryViewController mainController) {
        this.mainController = mainController;
    }
}

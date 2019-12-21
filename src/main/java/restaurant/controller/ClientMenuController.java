package restaurant.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    private double x, y;
    private boolean hasOrdered = false;

    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Button login;
    @FXML private Button btnRequestWaiter;
    @FXML private Button btnOrderFood;
    @FXML private Button btnRequestReceipt;
    @FXML private Button btnOk;
    @FXML private Button btnLeaveTable;
    @FXML private Pane customDialog;
    @FXML private Label dialogMessage;


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
    public void askWaiterAction(MouseEvent event) {
        showDialogBox("The waiter is on his way. Please wait.");
    }

    @FXML
    public void orderFoodAction(MouseEvent event) {
        showDialogBox("Your order will be ready as soon as possible.");
        btnLeaveTable.setDisable(true);
        hasOrdered = true;
    }

    @FXML
    public void requestReceiptAction(MouseEvent event) {
        if (hasOrdered) {
            showDialogBox("Receipt requested. Please wait.");
            System.out.println("Receipt requested. Please wait.");
        } else {
            showDialogBox("You have to order first.");
            hasOrdered = false;
        }
        btnLeaveTable.setDisable(false);
    }

    @FXML
    public void leaveTableAction(MouseEvent event) {
        showDialogBox("Have a nice day!");
    }

    @FXML
    public void showDialogBox(String message) {
        customDialog.setVisible(true);
        btnOk.setDisable(false);
        btnOk.setVisible(true);

        dialogMessage.setText(message);
    }

    @FXML
    public void dialogBoxAction(MouseEvent event) {
        hideDialogBox();
    }

    @FXML
    public void hideDialogBox() {
        customDialog.setVisible(false);
        btnOk.setDisable(true);
        btnOk.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        hideDialogBox();
    }
}

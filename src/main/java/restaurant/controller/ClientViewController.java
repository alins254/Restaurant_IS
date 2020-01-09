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
import java.util.List;
import java.util.ResourceBundle;

import restaurant.entity.menu.Menu;

public class ClientViewController implements Initializable {
    private double x, y;
    private boolean hasOrdered = false;
    private EntryViewController mainController;

    @FXML private VBox mainBox;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Button login;
    @FXML private Button btnRequestWaiter;
    @FXML private Button btnOrderFood;
    @FXML private Button btnRequestReceipt;
    @FXML private Button btnOk;
    @FXML private Button btnLeaveTable;
    @FXML private DialogPane customDialog;
    @FXML private Label dialogMessage;
    @FXML private Pane tablePane;
    @FXML private Pane buttonsPane;
    @FXML private TableView menuItemsTable;

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
        showDialogBox("The waiter is on his way.");
    }

    @FXML
    public void orderFoodAction(MouseEvent event) {
        showDialogBox("Order placed.");
        btnLeaveTable.setDisable(true);
        hasOrdered = true;
    }

    @FXML
    public void requestReceiptAction(MouseEvent event) {
        if (hasOrdered) {
            showDialogBox("Receipt requested.");
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

        tablePane.setDisable(true);
        buttonsPane.setDisable(true);

        dialogMessage.setText(message);
        dialogMessage.setAlignment(Pos.CENTER);
    }

    @FXML
    public void hideDialogBox() {
        customDialog.setVisible(false);

        tablePane.setDisable(false);
        buttonsPane.setDisable(false);

        btnOk.setDisable(true);
        btnOk.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        hideDialogBox();
    }

    public void addMenuItems(List<Menu> menuItemsList) {
    }

    public EntryViewController getMainController() {
        return mainController;
    }

    public void setMainController(EntryViewController mainController) {
        this.mainController = mainController;
    }
}

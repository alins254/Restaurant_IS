package restaurant.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class StockViewController implements Initializable {
    private double x, y;
    private boolean isValid = false;
    private String name = "";
    private Double price = 0.0;
    private Double quantity = 0.0;
    private List<String> typeList = new ArrayList<>(Arrays.asList("dish","drink"));
    private EntryViewController mainController;


    @FXML private Pane buttonsPane;
    @FXML private Pane tablePane;
    @FXML private DialogPane customDialog;
    @FXML private TextField nameField;
    @FXML private TextField priceField;
    @FXML private TextField quantityField;
    @FXML private ChoiceBox typeChoice;
    @FXML private Button btnCreateItem;

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
        showAddItemsPanel();
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



    @FXML public void createItem() {
        System.out.println("Item " + nameField.getText() + ", " + quantityField.getText()
                + ", type: " + typeList.get(typeChoice.getSelectionModel().getSelectedIndex()) +
                ", price: " + priceField.getText() + " created.");
        clearFields();
        hideAddItemsPanel();
    }

    @FXML public void discard() {
        System.out.println("Discard.");
        hideAddItemsPanel();
        clearFields();
        hideAddItemsPanel();
    }

    @FXML public void onNameFieldChange(){
        name = nameField.getText();
        isItemValid();
    }

    @FXML public void onPriceFieldChange(){
        try {
            price = Double.parseDouble(priceField.getText());
        } catch (NullPointerException npe) {
            System.out.println("Price field is mandatory.");
            price = 0.0;
        } catch (NumberFormatException nfe) {
            System.out.println("Price field must be a number.");
            price = 0.0;
        }
        isItemValid();
    }

    @FXML public void onQuantityFieldChange(){
        try {
            quantity = Double.parseDouble(quantityField.getText());
        } catch (NullPointerException npe) {
            System.out.println("Quantity field is mandatory.");
            quantity = 0.0;
        } catch (NumberFormatException nfe) {
            System.out.println("Quantity field must be a number.");
            quantity = 0.0;
        }
        isItemValid();
    }


    public void showAddItemsPanel() {
        customDialog.setVisible(true);
        tablePane.setDisable(true);
        buttonsPane.setDisable(true);
    }

    public void hideAddItemsPanel (){
        customDialog.setVisible(false);
        tablePane.setDisable(false);
        buttonsPane.setDisable(false);
    }

    public void clearFields() {
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
        typeChoice.setValue(typeList.get(0));
    }


    public boolean isItemValid() {
        if (price < 0.001) {
            isValid = false;
        } else if (name.equals("")) {
            isValid = false;
        } else if (quantity < 0.001) {
            isValid = false;
        } else {
            isValid = true;
        }

        System.out.println("Is valid: "+ isValid);
        btnCreateItem.setDisable(!isValid);
        return isValid;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        customDialog.setVisible(false);
        btnCreateItem.setDisable(!isValid);
        typeChoice.getItems().addAll(typeList);
        typeChoice.setValue(typeList.get(0));
    }

    public EntryViewController getMainController() {
        return mainController;
    }

    public void setMainController(EntryViewController mainController) {
        this.mainController = mainController;
    }
}

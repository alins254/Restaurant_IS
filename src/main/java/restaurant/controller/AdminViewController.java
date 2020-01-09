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

public class AdminViewController implements Initializable {
    private double x, y;
    private EntryViewController mainController;

    private String name = "";
    private String username = "";
    private Double salary = 0.0;
    private String role = "";
    private boolean isValid = false;
    private List<String> roleList = new ArrayList<String>(Arrays.asList("waiter", "admin", "chef"));

    @FXML private Pane buttonsPane;
    @FXML private Pane tablePane;
    @FXML private DialogPane customDialog;
    @FXML private TextField nameField;
    @FXML private TextField usernameField;
    @FXML private ChoiceBox roleChoice;
    @FXML private TextField salaryField;
    @FXML private Button btnCreateUser;


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
    public void hireStaff() {
        System.out.println("Hire");
        showHirePanel();
    }

    @FXML
    public void fireStaff() {
        System.out.println("Fire");
    }

    @FXML
    public void saveChanges() {
        System.out.println("Save changes");
    }

    @FXML
    public void logout() {
        System.out.println("Logout");
    }

    @FXML
    public void inspectStock() {
        System.out.println("Inspect Stock");
    }

    @FXML public void createUser() {
        System.out.println("User " + nameField.getText() + ", " + usernameField.getText() +
                        ", " + ", role: " + roleList.get(roleChoice.getSelectionModel().getSelectedIndex()) +
                        ", salary: " + salaryField.getText() + " created.");
        hideHirePanel();
        clearFields();
    }

    @FXML public void discard() {
        System.out.println("Discard.");
        hideHirePanel();
        clearFields();
    }

    @FXML public void onNameFieldChange(){
        name = nameField.getText();
        isUserValid();
    }

    @FXML public void onUsernameFieldChange(){
        username = usernameField.getText();
        isUserValid();
    }

    @FXML public void onSalaryFieldChange(){
        try {
            salary = Double.parseDouble(salaryField.getText());
        } catch (NullPointerException npe) {
            System.out.println("Salary field is mandatory.");
            salary = 0.0;
        } catch (NumberFormatException nfe) {
            System.out.println("Salary field must be a number.");
            salary = 0.0;
        }
        isUserValid();
    }

    public boolean isUserValid() {
        if (salary < 0.001) {
            isValid = false;
        } else if (name.equals("")) {
            isValid = false;
        } else if (username.equals("")) {
            isValid = false;
        } else {
            isValid = true;
        }

        System.out.println("Is valid: "+ isValid);
        btnCreateUser.setDisable(!isValid);
        return isValid;
    }

    public void showHirePanel() {
        customDialog.setVisible(true);
        tablePane.setDisable(true);
        buttonsPane.setDisable(true);
    }

    public void hideHirePanel (){
        customDialog.setVisible(false);
        tablePane.setDisable(false);
        buttonsPane.setDisable(false);
    }

    public void clearFields() {
        nameField.setText("");
        usernameField.setText("");
        salaryField.setText("");
        roleChoice.setValue(roleList.get(0));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customDialog.setVisible(false);
        btnCreateUser.setDisable(!isValid);
        roleChoice.getItems().addAll(roleList);
        roleChoice.setValue(roleList.get(0));
    }

    public EntryViewController getMainController() {
        return mainController;
    }

    public void setMainController(EntryViewController mainController) {
        this.mainController = mainController;
    }
}

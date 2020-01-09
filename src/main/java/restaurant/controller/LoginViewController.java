package restaurant.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import restaurant.entity.personal.Chef;
import restaurant.entity.personal.Personal;
import restaurant.entity.personal.Waiter;
import restaurant.service.LoginService;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable {
    private double x, y;
    private LoginService loginService = new LoginService();
    private EntryViewController mainController;


    @FXML TextField username;
    @FXML PasswordField password;
    @FXML Button login;

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
    public void onLogin(MouseEvent event){
        if (username.getText().equals("")!=true && password.getText().equals("")!=true){
            Personal p = loginService.checkAccount(username.getText(), password.getText());
            if (p != null) {
                System.out.println("Succes");
                username.setText("");
                password.setText("");
                if (p instanceof Waiter) {
                    mainController.initializeWaiterView();
                    onCloseWindow(event);
                } else if ( p instanceof Chef) {
                    mainController.initializeChefView();
                    onCloseWindow(event);
                }
            } else if (username.getText().equals("admin") == true && password.getText().equals("admin") == true){
                System.out.println("Succes");
                username.setText("");
                password.setText("");
                mainController.initializeAdminView();
                onCloseWindow(event);
            } else {
                System.out.println("Credentiale nereusite");
            }
        } else {
            System.out.println("Ambele sunt necesare");
        }
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

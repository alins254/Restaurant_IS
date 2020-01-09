package restaurant.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class EntryViewController implements Initializable {
    private EntryViewController mainController = this;
    private AdminViewController adminViewController = null;
    private ChefViewController chefViewController = null;
    private ClientViewController clientViewController = null;
    private EntryViewController entryViewController = null;
    private LoginViewController loginViewController = null;
    private StockViewController stockViewController = null;
    private WaiterViewController waiterViewController = null;

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
        initializeLoginView();
    }

    public void initializeLoginView(){
        try {
            FXMLLoader loader = new FXMLLoader((getClass().getResource("/ui-components/login.fxml")));
            Parent root = (Parent) loader.load();

            loginViewController = loader.getController();
            loginViewController.setMainController(mainController);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeAdminView(){
        try {
            FXMLLoader loader = new FXMLLoader((getClass().getResource("/ui-components/admin.fxml")));
            Parent root = (Parent) loader.load();

            adminViewController = loader.getController();
            adminViewController.setMainController(mainController);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeChefView(){
        try {
            FXMLLoader loader = new FXMLLoader((getClass().getResource("/ui-components/chef.fxml")));
            Parent root = (Parent) loader.load();

            chefViewController = loader.getController();
            chefViewController.setMainController(mainController);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeClientView(){
        try {
            FXMLLoader loader = new FXMLLoader((getClass().getResource("/ui-components/chef.fxml")));
            Parent root = (Parent) loader.load();

            clientViewController = loader.getController();
            clientViewController.setMainController(mainController);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeStockView(){
        try {
            FXMLLoader loader = new FXMLLoader((getClass().getResource("/ui-components/stock.fxml")));
            Parent root = (Parent) loader.load();

            stockViewController = loader.getController();
            stockViewController.setMainController(mainController);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeWaiterView(){
        try {
            FXMLLoader loader = new FXMLLoader((getClass().getResource("/ui-components/waiter.fxml")));
            Parent root = (Parent) loader.load();

            waiterViewController = loader.getController();
            waiterViewController.setMainController(mainController);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
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

    public AdminViewController getAdminViewController() {
        return adminViewController;
    }

    public void setAdminViewController(AdminViewController adminViewController) {
        this.adminViewController = adminViewController;
    }

    public ChefViewController getChefViewController() {
        return chefViewController;
    }

    public void setChefViewController(ChefViewController chefViewController) {
        this.chefViewController = chefViewController;
    }

    public ClientViewController getClientViewController() {
        return clientViewController;
    }

    public void setClientViewController(ClientViewController clientViewController) {
        this.clientViewController = clientViewController;
    }

    public LoginViewController getLoginViewController() {
        return loginViewController;
    }

    public void setLoginViewController(LoginViewController loginViewController) {
        this.loginViewController = loginViewController;
    }

    public StockViewController getStockViewController() {
        return stockViewController;
    }

    public void setStockViewController(StockViewController stockViewController) {
        this.stockViewController = stockViewController;
    }

    public WaiterViewController getWaiterViewController() {
        return waiterViewController;
    }

    public void setWaiterViewController(WaiterViewController waiterViewController) {
        this.waiterViewController = waiterViewController;
    }
}

package restaurant.service;
import restaurant.entity.personal.Waiter;

public class Table {

    private String id;
    private Waiter waiter;

    public Table(){}

    public Table(Waiter waiter){this.waiter = waiter;}

    public String getId(){return id;}

    public Waiter getPersonal(){return waiter;}

    public void setPersonal(Waiter personal) {this.waiter = personal;}
}

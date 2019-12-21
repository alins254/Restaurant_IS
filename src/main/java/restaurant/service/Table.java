package restaurant.service;
import restaurant.entity.personal.Waiter;

public class Table {

    private String id;
    private Waiter waiter;
    private boolean isOccupied = false;

    public Table(){}

    public Table(Waiter waiter) {this.waiter = waiter;}

    public String getId(){return id;}

    public Waiter getWaiter(){return waiter;}

    public void setWaiter(Waiter waiter) {this.waiter = waiter;}

    public boolean getOccupied() {return isOccupied;}

    public void setOccupied(boolean occupied) {isOccupied = occupied;}
}

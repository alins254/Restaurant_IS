package restaurant.service;
import restaurant.entity.personal.Waiter;

import java.util.Objects;
import java.util.Observable;

public class Table extends Observable {

    private String id;
    private Waiter waiter;
    private boolean isOccupied = false;

    public Table(){}

    public Table(Waiter waiter) {this.waiter = waiter;}

    public void requestWaiter(){
        this.setOccupied(true);
        setChanged();
        notifyObservers(waiter);
    }

    public void orderFood(){

    }

    public void requestReceipt(){
        waiter.generateReceipt(this);
    }

    public void leaveTable(){
        this.setOccupied(false);
        setChanged();
        notifyObservers(waiter);
    }
    public String getId(){return id;}

    public Waiter getWaiter(){return waiter;}

    public void setWaiter(Waiter waiter) {this.waiter = waiter;}

    public boolean getOccupied() {return isOccupied;}

    public void setOccupied(boolean occupied) {isOccupied = occupied;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return isOccupied == table.isOccupied &&
                id.equals(table.id) &&
                waiter.equals(table.waiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, waiter, isOccupied);
    }
}

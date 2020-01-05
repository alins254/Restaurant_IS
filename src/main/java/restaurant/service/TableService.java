package restaurant.service;
import restaurant.entity.orders.OrdersTable;
import restaurant.entity.personal.Waiter;
import restaurant.entity.table.Table;

import java.util.Observable;

public class TableService extends Observable{
    /*
    ----- Table is OBSERVABLE -----
    table notifies waiter he was requested            -> requestWaiter method
    table notifies waiter that clients left           -> leaveTable method
    table notifies chef that a new order was placed   -> orderFood method

     */

    private Table table;
    public void orderFood(OrdersTable orderedFood){
        table.setOccupied(true);
        setChanged();
        notifyObservers(orderedFood); //chef?
    }

    public void requestReceipt(){
        Waiter w = table.getWaiter();
        w.generateReceipt(table);
    }

    public void leaveTable(){
        table.setOccupied(false);
        setChanged();
        notifyObservers(new String("left"));
    }

    public void requestWaiter(){
        table.setOccupied(true);
        setChanged();
        notifyObservers(new String("request"));
    }
}

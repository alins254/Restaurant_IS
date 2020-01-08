package restaurant.service;
import restaurant.entity.menu.MenuItem;

import restaurant.entity.orders.Orders;
import restaurant.entity.personal.Waiter;
import restaurant.entity.table.Table;


import java.util.ArrayList;

import java.util.Objects;
import java.util.Observable;

public class TableService{
    /*
    ----- Table is OBSERVABLE -----
    table notifies waiter he was requested            -> requestWaiter method
    table notifies waiter that clients left           -> leaveTable method
    table notifies chef that a new order was placed   -> orderFood method

     */

    private Table table;
    //private TableRepo repo = new TableRepo();

    public TableService(Table table){
        this.table = table;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void orderFood(Orders orderedFood){
        table.orderFood(orderedFood);

    }

    public void requestReceipt(){
        Waiter w = table.getWaiter();
        w.generateReceipt(table);
    }

    public void leaveTable(){
        table.leaveTable();
    }

    public void requestWaiter(){
        table.requestWaiter();
    }

    public ArrayList<MenuItem> showAllMenuItems(){
        ArrayList<MenuItem> accounts = null ;//= (ArrayList<MenuItem>) repo.showAllMenuItems();
        if(accounts == null)
            return new ArrayList<MenuItem>();
        return accounts;
    }

}

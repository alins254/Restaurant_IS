package restaurant.service;
import restaurant.entity.menu.MenuItem;
import restaurant.entity.personal.Waiter;
import restaurant.entity.table.Table;

import java.util.ArrayList;

import restaurant.entity.orders.Orders;
import restaurant.repository.TableRepo;

public class TableService {


    private Table table;
    private TableRepo repo = new TableRepo();

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
        ArrayList<MenuItem> accounts = (ArrayList<MenuItem>) repo.showAllMenuItems();
        if(accounts == null)
            return new ArrayList<MenuItem>();
        return accounts;
    }

}

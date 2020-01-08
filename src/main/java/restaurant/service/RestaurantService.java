package restaurant.service;

import restaurant.entity.personal.Waiter;
import restaurant.entity.table.Table;

import java.util.ArrayList;

public class RestaurantService {

    private ArrayList<Table> tables;
    private ArrayList<Waiter> activeWaiters = new ArrayList<Waiter>();

    public RestaurantService(int numberOfTables){
        if(numberOfTables<=0)
            return;
        tables = new ArrayList<>();
        for(int i = 0; i < numberOfTables; i++){
            Table t = new Table();
            t.setId(""+i);
            tables.add(new Table());
        }
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void assignTables(Waiter waiter){
        ArrayList<Table> t = new ArrayList<>();
        if(!activeWaiters.contains(waiter))
            activeWaiters.add(waiter);
        for(Table table:tables){
            if(t.size() >= 6)
                break;
            if(table.getWaiter() == null){
                t.add(table);
                table.setWaiter(waiter);
            }
        }
        waiter.setTables(t);
    }

    public void removeWaiter(Waiter waiter){
        if(!activeWaiters.contains(waiter))
            return;
        for(Table table:(ArrayList<Table>)waiter.getTables()){
            table.setWaiter(null);

        }
    }


}

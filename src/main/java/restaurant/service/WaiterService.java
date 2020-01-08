package restaurant.service;

import restaurant.entity.orders.Orders;
import restaurant.entity.personal.Waiter;
import restaurant.entity.table.Table;

public class WaiterService {
    Waiter waiter;

    public WaiterService(Waiter waiter){
        this.waiter = waiter;
        RestaurantService.assignTables(this.waiter);
    }

    public String createReceipt(Table t){
        waiter.generateReceipt(t);
        return "Receipt Created";
    }

    public void waiterLogOut(){
        RestaurantService.removeWaiter(waiter);
    }

    public String assignMeTables(){
        if(waiter.getTables().size()<6){
            RestaurantService.assignTables(waiter);
            return "Tables Assigned";
        }
        return "You already reached your maximum number of tables!";
    }

}

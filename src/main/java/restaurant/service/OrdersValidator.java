package restaurant.service;

import restaurant.entity.menu.MenuItem;
import restaurant.entity.personal.Waiter;
import restaurant.entity.table.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrdersValidator {

    public static String orderTableValidation(String table){
        String message = new String("");
        if (Integer.parseInt(table) < 0 || Integer.parseInt(table) > 13)
            message += "Table is not in range 1 to 12.";
        return message;
    }

    public static String orderWaiterValidation(Waiter waiter){
        String message = new String("");
        if (waiter == null)
            message += "Waiter does not exist.";
        return message;
    }

    public static String orderListValidation(ArrayList<MenuItem> menuItems){
        String message = new String("");
        if (menuItems.isEmpty())
            message += "Order should have at least one menu item.";
        return message;
    }
}

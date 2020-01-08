package restaurant.service;

import restaurant.entity.menu.MenuItem;
import restaurant.entity.orders.Orders;
import restaurant.entity.personal.Waiter;
import restaurant.repository.OrdersRepo;

import java.util.*;

public class OrdersService {

    private OrdersRepo ordersRepo;

    public OrdersService(){
        ordersRepo = new OrdersRepo();
    }

    public String addNewOrder(String table, Waiter waiter, ArrayList<MenuItem> menuItems){

        Float totalPrice = 0.0f;
        String message = OrdersValidator.orderTableValidation(table);
        message += OrdersValidator.orderWaiterValidation(waiter);
        message += OrdersValidator.orderListValidation(menuItems);

        for (MenuItem m : menuItems){
            totalPrice += m.getPrice();
        }

        if(!message.equals(""))
            return message;

        Orders order = new Orders(table, waiter, menuItems, totalPrice);
        order.setId(UUID.randomUUID().toString());
        for(MenuItem m: menuItems){
            m.getOrders().add(order);
        }
        ordersRepo.addNewOrder(order);

        return message;
    }

    public String removeOrder(String id){

        String message = ordersRepo.removeOrder(id);
        return message;

    }

    public ArrayList<Orders> showAllOrders(){
        ArrayList<Orders> orders = (ArrayList<Orders>) ordersRepo.showAllOrders();

        if (orders == null)
            return new ArrayList<Orders>();

        return orders;
    }

}

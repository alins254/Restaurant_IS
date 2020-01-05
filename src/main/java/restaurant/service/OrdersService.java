package restaurant.service;

import restaurant.entity.menu.MenuItem;
import restaurant.entity.orders.OrdersTable;
import restaurant.entity.personal.Personal;
import restaurant.entity.personal.Waiter;
import restaurant.repository.OrdersRepo;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class OrdersService {

    private OrdersRepo ordersRepo;

    public OrdersService(){
        ordersRepo = new OrdersRepo();
    }

    public String addNewOrder(Integer table, Waiter waiter, List<MenuItem> menuItems){

        Float totalPrice = 0.0f;
        String message = OrdersValidator.orderTableValidation(table);
        message += OrdersValidator.orderWaiterValidation(waiter);
        message += OrdersValidator.orderListValidation(menuItems);

        for (MenuItem m : menuItems)
            totalPrice += m.getPrice();

        if(!message.equals(""))
            return message;

        OrdersTable order = new OrdersTable(table, waiter, menuItems, totalPrice);
        order.setId(UUID.randomUUID().toString());
        ordersRepo.addNewOrder(order);
        return message;
    }

    public String removeOrder(String id){

        String message = ordersRepo.removeOrder(id);
        return message;

    }

    public ArrayList<OrdersTable> showAllOrders(){
        ArrayList<OrdersTable> orders = (ArrayList<OrdersTable>) ordersRepo.showAllOrders();

        if (orders == null)
            return new ArrayList<OrdersTable>();

        return orders;
    }

}

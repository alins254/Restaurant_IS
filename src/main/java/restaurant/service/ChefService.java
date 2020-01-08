package restaurant.service;

import restaurant.entity.orders.Orders;
import restaurant.entity.personal.Chef;

public class ChefService {

    Chef chef;

    public ChefService(Chef chef) {this.chef = chef;}

    public String orderDone(Orders order){
        chef.notifyObservers(order);
        return "Notified!";
    }
}

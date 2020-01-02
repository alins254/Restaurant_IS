package restaurant.entity.menu;

import java.util.ArrayList;

public class Dishes extends MenuItem {

    public Dishes(String name, Float price){
        this.setName(name);
        this.setPrice(price);
        this.setType("Dish ");
    }

    @Override
    public String showMenuItemDetails() {
            return "Dish " + this.getName() + " has price " + this.getPrice() ;
    }
}

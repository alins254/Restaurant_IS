package restaurant.entity.menu;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Dishes extends MenuItem {

    public Dishes(){};

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

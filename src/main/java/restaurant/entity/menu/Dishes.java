package restaurant.entity.menu;

import java.util.ArrayList;

public class Dishes implements MenuItem {
    private String name;
    private Float price;

    public Dishes(String name, Float price){
        this.name = name;
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String showMenuItemDetails() {
            return name + " has price " + price ;

    }
}

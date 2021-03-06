package restaurant.entity.menu;

import javax.persistence.Entity;

@Entity
public class Drinks extends MenuItem{

    public Drinks(){};

    public Drinks(String name, Float price){
        this.setName(name);
        this.setPrice(price);
        this.setType("Drink ");
    }

    @Override
    public java.lang.String showMenuItemDetails() {
        return this.getType() + this.getName() + " has price " + this.getPrice() ;
    }
}

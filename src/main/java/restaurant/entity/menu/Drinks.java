package restaurant.entity.menu;

public class Drinks implements MenuItem{
    private String name;
    private Float price;

    public Drinks(String name, Float price){
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
    public java.lang.String showMenuItemDetails() {
        return name + " has price " + price ;
    }
}

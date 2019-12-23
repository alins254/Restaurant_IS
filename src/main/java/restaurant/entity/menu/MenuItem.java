package restaurant.entity.menu;

import javax.persistence.*;

public abstract class MenuItem {
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private Float price;
    @Column
    private String type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String showMenuItemDetails(){
        String s = "";
        return s;
    }
}

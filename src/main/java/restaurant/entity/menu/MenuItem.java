package restaurant.entity.menu;

import javax.persistence.*;

@Entity
public abstract class MenuItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Integer menuId;

    @Column
    private String name;
    @Column
    private Float price;
    @Column
    private String type;

    public MenuItem(){}

    public MenuItem(String name, float price){
        this.name = name;
        this.price = price;
    }

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
        return menuId;
    }

    public String showMenuItemDetails(){
        return this.type + this.name + " has price " + this.price;
    }
}

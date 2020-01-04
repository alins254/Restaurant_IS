package restaurant.entity.menu;

import restaurant.entity.stock.Stock;

import javax.persistence.*;

@Entity
public abstract class MenuItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;
    @Column
    private Float price;
    @Column
    private String type;

//    @OneToOne(mappedBy = "MenuItem", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY)
//    private Stock stock;

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
        return this.type + this.name + " has price " + this.price;
    }
}

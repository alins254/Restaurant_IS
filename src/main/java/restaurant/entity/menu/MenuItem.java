package restaurant.entity.menu;

import restaurant.entity.stock.Stock;

import javax.persistence.*;

@Entity(name = "Menu")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MenuItem {
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    @Column
    private String name;
    @Column
    private Float price;
    @Column
    private String type;


    @OneToOne
    @JoinColumn(name="STOCK_ID")
            //@OneToOne(mappedBy = "MenuItem", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Stock stock;

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

    public String getId() {
        return id;
    }

    public void setId(String id){ this.id = id; }

    public String showMenuItemDetails(){
        return this.type + this.name + " has price " + this.price;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", stock=" + stock +
                '}';
    }
}

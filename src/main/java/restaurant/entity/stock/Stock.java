package restaurant.entity.stock;

import restaurant.entity.menu.MenuItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//scoatem composite. menuitem abstracta(nume, pret , tip ,id). stock(id, id menu, quant).
@Entity
public class Stock {
    @Id
    private String id;

    @Column
    private Integer quantity;

    @OneToOne(mappedBy = "stock", cascade = CascadeType.ALL)
    private MenuItem menuItem;

    public Stock(){};

    public Stock(int quantity){
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }


}

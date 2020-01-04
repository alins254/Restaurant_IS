package restaurant.entity.stock;

import restaurant.entity.menu.MenuItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//scoatem composite. menuitem abstracta(nume, pret , tip ,id). stock(id, id menu, quant).
@Entity
public class Stock {
    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

    @OneToOne(mappedBy = "stock")//(fetch = FetchType.EAGER)
    //@JoinColumn(name = "menu_id")
    private MenuItem menuItem;

    @Column
    private Integer quantity;

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

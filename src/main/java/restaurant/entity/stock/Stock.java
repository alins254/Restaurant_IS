package restaurant.entity.stock;

import restaurant.entity.menu.MenuItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//scoatem composite. menuitem abstracta(nume, pret , tip ,id). stock(id, id menu, quant).
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private MenuItem menuItem;

    @Column
    private Integer menuId;

    @Column
    private Integer quantity;

    public Stock(int menuId, int quantity){
        this.menuId = menuId;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

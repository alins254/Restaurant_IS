package restaurant.entity.orders;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import restaurant.entity.menu.Menu;
import restaurant.entity.menu.MenuItem;
import restaurant.entity.personal.Waiter;

import javax.persistence.*;

@Entity
public class Orders {

	@Id
	private String id;

	@Column
	private String tableOfOrder;

	@Column
	private Float totalPrice;

	@Column
	private Date placedAt;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
		name = "Orders_Menu",
		joinColumns = { @JoinColumn(name = "orders_id") },
		inverseJoinColumns = { @JoinColumn(name = "menu_id") })
	private List<MenuItem> menuItems;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Waiter.class)
	@JoinColumn(name="waiter_id")
	private Waiter waiter;

	private Boolean completed;

	public Orders(String table, Waiter waiter, List<MenuItem> menuItems) {
		this.tableOfOrder = table;
		this.waiter = waiter;
		this.menuItems = menuItems;
		this.placedAt = new Date((new java.util.Date()).getTime());
	}

	public Orders() {}

	public Orders(String table, Waiter waiter, List<MenuItem> menuItems, Float price) {
		this.tableOfOrder = table;
		this.waiter = waiter;
		this.menuItems = menuItems;
		this.placedAt = new Date((new java.util.Date()).getTime());
		this.totalPrice = price;
	}

	public String getId(){return id;}

    public void setId(String id) {
        this.id = id;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTable() {return tableOfOrder;}

	public void setTable(String table) {this.tableOfOrder = table;}

	public Waiter getWaiter() {return waiter;}

	public void setWaiter(Waiter waiter) {this.waiter = waiter;}

	public Float getPrice() {return totalPrice;}

	public void setPrice(Float price) {this.totalPrice = price;}

	public Date getPlacedAt() {return placedAt;}

	public List<MenuItem> getMenuItems() {return menuItems;}

	public void setMenuItems(List<MenuItem> menuItems) {this.menuItems = menuItems;}
	

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Orders orders = (Orders) o;
		return id.equals(orders.id) &&
				waiter.equals(orders.waiter) &&
				tableOfOrder.equals(orders.tableOfOrder) &&
				Objects.equals(totalPrice, orders.totalPrice) &&
				placedAt.equals(orders.placedAt) &&
				menuItems.equals(orders.menuItems) &&
				Objects.equals(completed, orders.completed);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, waiter, tableOfOrder, totalPrice, placedAt, menuItems, completed);
	}
}

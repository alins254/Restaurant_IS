package restaurant.entity.orders;

import java.util.Date;
import java.util.List;

import restaurant.entity.menu.MenuItem;
import restaurant.entity.personal.Waiter;

//import javax.persistence.*;

//@Entity
public class Orders {

//	@Id
	private String id;

//	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Waiter.class)
//	@JoinColumn(name="waiter_id")
	private Waiter waiter;

//	@Column
	private Integer table;

//	@Column
	private Float totalPrice;

//	@Column
	private Date placedAt;

//	@ManyToMany(cascade = { CascadeType.ALL })
//  @JoinTable(
//    name = "Orders_MenuItem",
//    joinColumns = { @JoinColumn(name = "orders_id") },
//    inverseJoinColumns = { @JoinColumn(name = "menuitem_id") }
//  )
	private List<MenuItem> menuItems;

	public Orders() {}

	public Orders(Integer table, Waiter waiter, List<MenuItem> menuItems) {
		this.table = table;
		this.waiter = waiter;
		this.menuItems = menuItems;
		this.placedAt = new Date();
	}

	public String getId(){return id;}

	public Integer getTable() {return table;}

	public void setTable(Integer table) {this.table = table;}

	public Waiter getWaiter() {return waiter;}

	public void setWaiter(Waiter waiter) {this.waiter = waiter;}

	public Float getPrice() {return totalPrice;}

	public void setPrice(Float price) {this.totalPrice = price;}

	public Date getPlacedAt() {return placedAt;}

	public List<MenuItem> getMenuItems() {return menuItems;}

	public void setMenuItems(List<MenuItem> menuItems) {this.menuItems = menuItems;}

}

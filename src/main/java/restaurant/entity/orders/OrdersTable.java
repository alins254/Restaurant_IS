package restaurant.entity.orders;

import java.sql.Date;
import java.util.List;

import restaurant.entity.menu.MenuItem;
import restaurant.entity.personal.Waiter;

import javax.persistence.*;

@Entity
public class OrdersTable {

	@Id
	private String id;

	@Column
	private Integer tableOfOrder;

	@Column
	private Float totalPrice;

	@Column
	private Date placedAt;

	//	@ManyToMany(cascade = { CascadeType.ALL })
//  @JoinTable(
//    name = "Orders_MenuItem",
//    joinColumns = { @JoinColumn(name = "orders_id") },
//    inverseJoinColumns = { @JoinColumn(name = "menuitem_id") }
//  )
	@Transient
	private List<MenuItem> menuItems;

//	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Waiter.class)
//	@JoinColumn(name="waiter_id")
	@Transient
	private Waiter waiter;

	public OrdersTable() {}

	public OrdersTable(Integer table, Waiter waiter, List<MenuItem> menuItems, Float price) {
		this.tableOfOrder = table;
		this.waiter = waiter;
		this.menuItems = menuItems;
		this.placedAt = new Date((new java.util.Date()).getTime());
		this.totalPrice = price;
	}

	public String getId(){return id;}

	public void setId(String id){this.id = id;}

	public Integer getTable() {return tableOfOrder;}

	public void setTable(Integer table) {this.tableOfOrder = table;}

	public Waiter getWaiter() {return waiter;}

	public void setWaiter(Waiter waiter) {this.waiter = waiter;}

	public Float getPrice() {return totalPrice;}

	public void setPrice(Float price) {this.totalPrice = price;}

	public Date getPlacedAt() {return placedAt;}

	public List<MenuItem> getMenuItems() {return menuItems;}

	public void setMenuItems(List<MenuItem> menuItems) {this.menuItems = menuItems;}

}
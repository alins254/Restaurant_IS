package restaurant.entity.orders;

import java.util.Date;
import java.util.List;

import restaurant.entity.menu.Menu;
import restaurant.entity.personal.Waiter;

public class Orders {

//	@Id
	private String id;

//	@Column
	private Waiter waiter;

//	@Column
	private Integer table;

//	@Column
	private Double totalPrice;

//	@Column
	private Date placedAt;

//	@ManyToMany(mappedBy = "order",fetch = FetchType.EAGER)
	private List<Menu> menuItems;

	public Orders() {}

	public Orders(Integer table, Waiter waiter, List<Menu> menuItems) {
		this.table = table;
		this.waiter = waiter;
		this.menuItems = menuItems;
	}

	public String getId(){return id;}

	public Integer getTable() {return table;}

	public void setTable(Integer table) {this.table = table;}

	public Waiter getWaiter() {return waiter;}

	public void setWaiter(Waiter waiter) {this.waiter = waiter;}

	public Double getPrice() {return totalPrice;}

	public void setPrice(Double price) {this.totalPrice = price;}

	public Date getPlacedAt() {return placedAt;}

	public void setPlacedAt(Date placedAt) {this.placedAt = placedAt;}

	public List<Menu> getMenuItems() {return menuItems;}

	public void setMenuItems(List<Menu> menuItems) {this.menuItems = menuItems;}

}

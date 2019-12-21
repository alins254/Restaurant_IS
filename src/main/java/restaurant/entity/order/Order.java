package restaurant.entity.order;

import java.util.Date;
import java.util.List;

import restaurant.entity.menu.MenuItem;
import restaurant.entity.personal.Personal;

public class Order {

//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

//	@Column
	private Integer table;

//	@Column
	private Personal waiter;

//	@Column
	private String status; //Ordered - Processing - Delivered

//	@Column
	private Double price;

//	@Column
	private Date placedAt;

//	@OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
	private List<MenuItem> menuItems;

	public Order() {}

	public Order(Integer table, Personal waiter, List<MenuItem> menuItems) {
		this.table = table;
		this.waiter = waiter;
		this.menuItems = menuItems;
	}

	public Integer getTable() {
		return table;
	}

	public void setTable(Integer table) {
		this.table = table;
	}

	public Personal getWaiter() {
		return waiter;
	}

	public void setWaiter(Personal waiter) {
		this.waiter = waiter;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getPlacedAt() {
		return placedAt;
	}

	public void setPlacedAt(Date placedAt) {
		this.placedAt = placedAt;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

}

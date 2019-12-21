package restaurant.entity.orders;

import java.util.Date;
import java.util.List;

import restaurant.entity.menu.Menu;
import restaurant.entity.personal.Waiter;

//import javax.persistence.*;

//@Entity
public class Orders {

//	@Id
	private String id;

//	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Waiter.class)
//	@JoinColumn(name="waiter_id")
//	@Transient
	private Waiter waiter;

//	@Column
	private Integer table;

//	@Column
	private Float totalPrice;

//	@Column
	private Date placedAt;

//	@ManyToMany(mappedBy = "order",fetch = FetchType.EAGER)
//	@Transient
	private List<Menu> menuItems;

	public Orders() {}

	public Orders(Integer table, Waiter waiter, List<Menu> menuItems) {
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

	public List<Menu> getMenuItems() {return menuItems;}

	public void setMenuItems(List<Menu> menuItems) {this.menuItems = menuItems;}

}

package restaurant.entity.orders;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Observable;

import restaurant.entity.menu.Menu;
import restaurant.entity.personal.Waiter;

//import javax.persistence.*;

//@Entity
public class Orders extends Observable {

//	@Id
	private String id;

//	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Waiter.class)
//	@JoinColumn(name="waiter_id")
//	@Transient
	private Waiter waiter;

//	@Column
	private String table; //integer?

//	@Column
	private Float totalPrice;

//	@Column
	private Date placedAt;

//	@ManyToMany(mappedBy = "order",fetch = FetchType.EAGER)
//	@Transient
	private List<Menu> menuItems;
	/*
	astea nu sunt instantiate in constructor, o sa-mi dea eroare (zic eu) cand o sa fac
	getMenuItems in invoice
	 */

	private Boolean completed;

	public Orders() {}

	public Orders(String table, Waiter waiter, List<Menu> menuItems) {
		this.table = table;
		this.waiter = waiter;
		this.menuItems = menuItems;
		this.placedAt = new Date();
		this.completed = false;
	}

	public String getId(){return id;}

	public String getTable() {return table;}

	public void setTable(String table) {this.table = table;}

	public Waiter getWaiter() {return waiter;}

	public void setWaiter(Waiter waiter) {this.waiter = waiter;}

	public Float getPrice() {return totalPrice;}

	public void setPrice(Float price) {this.totalPrice = price;}

	public Date getPlacedAt() {return placedAt;}

	public List<Menu> getMenuItems() {return menuItems;}

	public void setMenuItems(List<Menu> menuItems) {this.menuItems = menuItems;}

	public void prepared(){
		setChanged();
		notifyObservers(waiter);
	}

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
				table.equals(orders.table) &&
				Objects.equals(totalPrice, orders.totalPrice) &&
				placedAt.equals(orders.placedAt) &&
				menuItems.equals(orders.menuItems) &&
				Objects.equals(completed, orders.completed);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, waiter, table, totalPrice, placedAt, menuItems, completed);
	}
}

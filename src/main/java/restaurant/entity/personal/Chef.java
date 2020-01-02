package restaurant.entity.personal;

import restaurant.entity.orders.Orders;

import java.util.*;

public class Chef extends Personal implements Observer {

	/* table notifies chef when new order is placed  */

	List orders;

	public Chef() {
		super();
		orders = new ArrayList<Orders>();
	}

	public Chef(String name, Double salary){
		super(name, salary);
		super.setDateOfEmployment(new Date());
		orders = new ArrayList<String>();
	}

	public List getOrders() {
		return orders;
	}

	public void setOrders(List orders) {
		this.orders = orders;
	}

	public void orderIsPrepared(Orders currentOrder){
		for(Object o: orders){
			if(o instanceof Orders){
				if(currentOrder.equals(o)){
					((Orders) o).setCompleted(true);
					((Orders) o).prepared();
				}
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {

	}

	public void orderPrepared(){
		orders.remove(0);
		setChanged();
		notifyObservers();
	}

	}

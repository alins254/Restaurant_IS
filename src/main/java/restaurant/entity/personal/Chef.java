package restaurant.entity.personal;

import restaurant.entity.orders.OrdersTable;

import java.util.*;

public class Chef extends Personal implements Observer {

	/*
	----- Chef is OBSERVER -----
	table notifies chef when new order is placed 	-> update method
	----- Chef is OBSERVABLE -----
	chef notifies waiter that the order is ready	-> orderPlaced method
	*/

	List orders;

	public Chef() {
		super();
		orders = new ArrayList<OrdersTable>();
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

	/*
	//method for random order prepared
	public void orderIsPrepared(Orders currentOrder){
		for(Object o: orders){
			if(o instanceof Orders){
				if(currentOrder.equals(o)){
					((Orders) o).setCompleted(true);
					////////##################################################################((Orders) o).prepared();
				}
			}
		}
	}

	 */

	@Override
	public void update(Observable o, Object arg) {
		if(arg == null)
			System.out.println("NULL ORDER -- update in Chef");
		else
			if(arg instanceof OrdersTable){
				OrdersTable newOrder = (OrdersTable)arg;
				orders.add(newOrder);
		}
	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
	}

	//#####################
	public void orderPrepared(){
		if(orders == null)
			System.out.println("No orders to prepare");
		else{
			OrdersTable doneOrder = (OrdersTable)orders.get(0);
			orders.remove(0);
			setChanged();
			notifyObservers(doneOrder);
		}

	}
    //#####################
}

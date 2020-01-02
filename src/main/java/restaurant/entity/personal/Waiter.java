package restaurant.entity.personal;

import java.util.*;

import restaurant.entity.orders.Orders;
import restaurant.service.Table;

public class Waiter extends Personal implements Observer { //informed when table has a new order

	List tables;
	List orders;

	public Waiter() {

		super();
	}

	public Waiter(String name, Double salary) {
		super(name,salary);
		super.setDateOfEmployment(new Date());
		tables = new ArrayList<Table>();
		orders = new ArrayList<Orders>();
	}

	public List getTables() {
		return tables;
	}

	public List getInvoices() {
		return orders;
	}

	public void setTables(List tables) {
		this.tables = tables;
	}

	public void setInvoices(List invoices) {
		this.orders = invoices;
	}

	public void addOrder(Orders o){
		this.orders.add(o);
		/*

		NOTIFY CHEF

		 */
	}

	public void generateReceipt(Table table){
		Table thisTable = new Table();
		for(Object t: this.tables){
			if(t instanceof Table)
				if(t.equals(table))
					thisTable = (Table)t;
		}
		Orders thisOrder = new Orders();
		for(Object o: this.orders){
			if(o instanceof Orders)
				if(((Orders) o).getTable().equals(thisTable.getId()))
					thisOrder = (Orders)o;
		}
		Invoice i = new Invoice();
		i.generate(thisOrder);

	}
	@Override
	public void update(Observable o, Object arg) {
		///to do
	}
}

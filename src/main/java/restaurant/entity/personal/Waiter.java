package restaurant.entity.personal;

import java.util.*;
import restaurant.entity.orders.Orders;
import restaurant.entity.table.Table;
import restaurant.service.TableService;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity(name = "Waiter")
public class Waiter extends Personal implements Observer {

    /*
    ----- Waiter is OBSERVER -----
    table notifies waiter when clients leave the table  -> update method -> "left" string
    table notifies waiter when he's requested			-> update method -> "request" string
    chef notifies waiter when the order is ready		-> update method -> Orders type object
     */

    @Transient
	List tables;
    @Transient
	List orders;

	public Waiter() {

		super();
	}

	public Waiter(String name, Double salary) {
		super(name,salary);
		super.setDateOfEmployment(new Date());
		//setType("waiter");
		tables = new ArrayList<Table>();
		orders = new ArrayList<Orders>();

	}

	public List getTables() {
		return tables;
	}

	public void setTables(List tables) {
		this.tables = tables;
	}

	public void addOrder(Orders o) {
		this.orders.add(o);
		/*

		NOTIFY CHEF

		 */
	}
	public List getInvoices() {
		return orders;
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
		if (arg == null) {
			System.out.println("NULL STRING -- update in Waiter");
		} else {
			if (arg instanceof String) {
				String message = (String) arg;
				if (message.toLowerCase().equals("left"))
					System.out.println("Thank you! Goodbye!");
				else if (message.toLowerCase().equals("request"))
					System.out.println("On my way!");
			} else if (arg instanceof Orders) {
				Orders doneOrder = (Orders) arg;
				for (Object ord : orders)
					if (ord instanceof Orders)
						if (((Orders) ord).equals(doneOrder))
							orders.remove(doneOrder);
			}
		}
	}

	public void setInvoices(List invoices) {
		this.orders = invoices;
	}

}

package restaurant.entity.personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Waiter extends Personal {

	List tables;
	List orders;

	public Waiter() {

		super();
	}

	public Waiter(String name, Double salary) {
		super(name,salary);
		super.setDateOfEmployment(new Date());
		//default lista de mese
		tables = new ArrayList<String>();
		orders = new ArrayList<String>();
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

}

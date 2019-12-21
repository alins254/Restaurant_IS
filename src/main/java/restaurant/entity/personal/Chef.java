package restaurant.entity.personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Chef extends Personal {

	List orders;

	public Chef() {
		super();
		orders = new ArrayList<String>();
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
}

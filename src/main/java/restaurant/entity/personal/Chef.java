package restaurant.entity.personal;

import java.util.ArrayList;
import java.util.List;

public class Chef extends Personal {

	List orders;

	public Chef() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Chef(String name, Double salary) {
		super(name, salary);
		// TODO Auto-generated constructor stub
		orders = new ArrayList<String>();
	}
	
	
}

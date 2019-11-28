package restaurant.entity.personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Waiter extends Personal {

	
		List tables;
		
	public Waiter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Waiter(String name, Double salary) {
		super(name, salary);
		// TODO Auto-generated constructor stub
		tables = new ArrayList<String>();
	}


	
}

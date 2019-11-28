package restaurant.entity.personal;

import java.util.Date;

public abstract class Personal {

    private String name;
    private Date dateOfEmployment;
    private Double salary;

    public Personal(){
        super();
    }

    
    
	public Personal(String name, Double salary) {
		super();
		this.name = name;
		this.dateOfEmployment = new Date();
		this.salary = salary;
	}



	public Personal(String name, Double salary, String role){
        	if(role.toLowerCase().equals("waiter"))
        		new Waiter(name, salary);
        	if(role.toLowerCase().equals("chef"));
        		new Chef(name, salary);
    }
	
	public Personal newWaiter(String name, Double salary) {
		return (Personal)(new Waiter(name, salary));
	}

}

package restaurant.entity.personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Chef implements Personal {

	private String name;
	private Date dateOfEmployment;
	private Double salary;
	List orders;

	public Chef() {
		dateOfEmployment = new Date();
		orders = new ArrayList<String>();
	}

	public Chef(String name, Double salary){
		this.name = name;
		this.salary = salary;
		dateOfEmployment = new Date();
		orders = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public Double getSalary() {
		return salary;
	}

	public List getOrders() {
		return orders;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public void setOrders(List orders) {
		this.orders = orders;
	}
}

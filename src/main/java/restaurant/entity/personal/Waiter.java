package restaurant.entity.personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Waiter implements Personal {

	private String name;
	private Date dateOfEmployment;
	private Double salary;
	List tables;
	List invoices;

	public Waiter() {
		this.dateOfEmployment = new Date();
	}

	public Waiter(String name, Double salary) {
		this.name = name;
		this.salary = salary;
		this.dateOfEmployment = new Date();
		tables = new ArrayList<String>();
		invoices = new ArrayList<String>();
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

	public List getTables() {
		return tables;
	}

	public List getInvoices() {
		return invoices;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public void setTables(List tables) {
		this.tables = tables;
	}

	public void setInvoices(List invoices) {
		this.invoices = invoices;
	}
}
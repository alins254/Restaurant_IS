package restaurant.entity.personal;

import java.util.Date;

public abstract class Personal {

    private String id;
    private String name;
    private Date dateOfEmployment;
    private Double salary;
    private String type;

    public Personal(){
        dateOfEmployment = new Date();
    }

    public Personal(String name, Double salary){
        this.name = name;
        this.salary = salary;
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

    public String getId() {

        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setSalary(Double salary) {

        this.salary = salary;
    }

    public void setDateOfEmployment(Date d){
        this.dateOfEmployment = d;
    }

    public void setType(String type) {
        this.type = type;
    }
}

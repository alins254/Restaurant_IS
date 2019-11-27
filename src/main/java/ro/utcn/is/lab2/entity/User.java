package ro.utcn.is.lab2.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Fiecare entitate (care reprezinta un tabel in baza de date) trebuie sa aiba obligatoriu:
 * 
 * 		1. "@Entity" - pentru a stii EntityManager-ul ce clase din aplicatie sunt tabelele din BD.
 * 		2. "@Id" - ce reprezinta cheia primara a tabelului. Orice tabel are nevoie de un PRIMARY KEY (PK).
 * 		3. "@Column" - celelalte coloane din tabel.
 */

@Entity
public class User {

	/**
	 * PK-ul este de tip int si autogenerat.
	 */
	@Id
	private String id;
	
	@Column
	private String name;
	
	@Column
	private Integer age;
	
	@Column
	private Date createdAt;
	
    public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
	private Address address;
    
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Phone> phoneNumbers;
    
	public User() {}
	
	public User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Phone> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<Phone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", phoneNumbers=" + phoneNumbers + "]";
	}
	
	
	
}

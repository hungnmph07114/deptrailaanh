package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Table(name = "customer")
@Entity
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String phone;
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	@Column(name = "contact", columnDefinition = "TEXT")
	private String contact;
	private String addess;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_customer", //Tạo ra một join Table tên là "users_roles"
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),// TRong đó, khóa ngoại chính là address_id trỏ tới class hiện tại (user)
            inverseJoinColumns = @JoinColumn(
                    name = "customer_id", referencedColumnName = "id")) //Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (customer)
    private Collection<User> users;

	@OneToMany(mappedBy = "customer" ,cascade = CascadeType.ALL)
	private List<Advertisement> advertisements;

	public Customer(long id, String name, String phone, String description, String contact, String addess) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.description = description;
		this.contact = contact;
		this.addess = addess;
	}

	public Customer(long id, String name, String phone, String description, String contact, String addess,List<Advertisement> advertisements) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.description = description;
		this.contact = contact;
		this.addess = addess;
		this.advertisements = advertisements;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddess() {
		return addess;
	}
	public void setAddess(String addess) {
		this.addess = addess;
	}
	
	

}

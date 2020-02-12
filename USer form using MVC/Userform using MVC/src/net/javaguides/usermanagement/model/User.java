package net.javaguides.usermanagement.model;


public class User {
	protected int id;
	protected String name;
	protected String address;
	protected String phone;
	protected String salary;
	protected String net;
	protected String total;
	public User(int id2, String name2, String address2, String phone2, String salary2, String net2, String total2) 
	{
		super();
		this.id = id2;
		this.name = name2;
		this.address = address2;
		this.phone=phone2;
		this.salary = salary2;
		this.net = net2;
		this.total = total2;
	}
	
public void User1(int id2, String name2, String address2, String phone2, String salary2, String net2, String total2) {
	
	this.id = id2;
	this.name = name2;
	this.address = address2;
	this.phone=phone2;
	this.salary = salary2;
	this.net = net2;
	this.total = total2;
	}

	/*	public User(String name, String address, String salary,String net,String total) {
		super();
		
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.net = net;
		this.total = total;
		
	}

	public User(int id, String name,String address, String salary,String net,String total) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.net = net;
		this.total = total;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getNet() {
		return net;
	}
	public void setNet(String net) {
		this.net = net;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
}

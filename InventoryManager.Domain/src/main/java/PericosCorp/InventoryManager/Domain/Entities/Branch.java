package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;



public class Branch implements Serializable{	
	private static final long serialVersionUID = 1L;
	private int Id;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	private String Name;
	private String Address;
	private String Phone;
	
	public Branch()
	{
		
	}
	public Branch(String name,String address,String phone)
	{
		Name=name;
		Address=address;
		Phone=phone;
	}
}

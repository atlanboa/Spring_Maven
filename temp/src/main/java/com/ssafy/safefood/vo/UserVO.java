package com.ssafy.safefood.vo;

public class UserVO {
	private String id;
	private String pass;
	private String name;
	private String address;
	private String phone;
	private String[] allergy;
	public UserVO(String id, String pass, String name, String address, String phone, String[] allergy) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.allergy = allergy;
	}
	public UserVO(String id, String pass, String name, String address, String phone, String allergy) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.address = address;
		this.phone = phone;
		setAllergy(allergy);
	}
	public UserVO(String id, String pass, String name, String address, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.allergy = null;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	public String getAllergy() {
		if(allergy == null)return "";
		StringBuilder sb = new StringBuilder();
		for (String a : allergy) {
			sb.append(a);
			sb.append(" ");
		}
		return sb.toString();
	}
	public void setAllergy(String[] allergy) {
		this.allergy = allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy.split(" ");
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", allergy=" + allergy + "]";
	}
}

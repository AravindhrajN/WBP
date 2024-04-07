package com.example.demo.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DAO.Customerdatadao;
import com.example.demo.Entity.CustomerDetails;

@Component
public class Customersavedata {
	private String name;
	private String mobile;
	private String city;
	private String address;
	private String state;
	private String ref_id;

	@Autowired
	Customerdatadao dao;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private int pincode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public void adddetails(CustomerData customer, String ref_id2) {
		// TODO Auto-generated method stub

		CustomerDetails cd = new CustomerDetails();

		cd.setRef_id(ref_id2);
		cd.setPincode(customer.getPincode());
		cd.setAddress(customer.getAddress());
		cd.setCity(customer.getCity());
		cd.setMobile(customer.getMobile());
		cd.setName(customer.getName());
		cd.setState(customer.getState());

		dao.save(cd);

	}

	public String getRef_id() {
		return ref_id;
	}

	public void setRef_id(String ref_id) {
		this.ref_id = ref_id;
	}

}

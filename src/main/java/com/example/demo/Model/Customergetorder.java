package com.example.demo.Model;

import org.springframework.stereotype.Component;

@Component
public class Customergetorder {

	private String mode;
	private int quant;
	private long id;
	private CustomerData cusdata;

	public CustomerData getCusdata() {
		return cusdata;
	}

	public void setCusdata(CustomerData cusdata) {
		this.cusdata = cusdata;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

package com.example.demo.Entity;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "Bodyproducts")
public class Bodyproducts {
	@Id
	private Long id;
	private String Name;
	private String des;
	private int price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void save(Product pro) {

		this.id = pro.getId();
		Name = pro.getName();
		this.des = pro.getDes();
		this.price = pro.getPrice();
	}

}

package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.DAO.Bodyprodao;
import com.example.demo.DAO.Faceprodao;
import com.example.demo.Entity.Bodyproducts;
import com.example.demo.Entity.Faceproducts;

@Component
public class Product {

	private Long id;
	private String Name;
	private String des;
	private int price;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Faceproducts faceProduct) {
		this.id = faceProduct.getId();
		this.Name = faceProduct.getName();
		this.price = faceProduct.getPrice();
		this.des = faceProduct.getDes();
	}

	public Product(Bodyproducts bProduct) {
		// TODO Auto-generated constructor stub
		this.id = bProduct.getId();
		this.Name = bProduct.getName();
		this.price = bProduct.getPrice();
		this.des = bProduct.getDes();
	}

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

	public void getProduct(Long id, String name, String des, int price) {

		this.id = id;
		Name = name;
		this.des = des;
		this.price = price;
	}

	public List<Product> getfaceproduct(Faceproducts fpro, Faceprodao fpdao, long id) {

		fpro = fpdao.getReferenceById(id);
		Product p = new Product();
		p.setId(fpro.getId());
		p.setDes(fpro.getDes());
		p.setName(fpro.getName());
		p.setPrice(fpro.getPrice());
		List<Product> list = new ArrayList<>();
		list.add(p);
		return list;
	}

	public List<Product> getbodyproduct(Bodyproducts bpro, Bodyprodao bpdao, long id) {

		bpro = bpdao.getReferenceById(id);
		Product p = new Product();
		p.setId(bpro.getId());
		p.setDes(bpro.getDes());
		p.setName(bpro.getName());
		p.setPrice(bpro.getPrice());
		List<Product> list = new ArrayList<>();
		list.add(p);
		return list;
	}

	public List<Product> getallfaceproduct(List<Faceproducts> fpro, Faceprodao fpdao) {

		fpro = fpdao.findAll();

		List<Product> list = fpro.stream().map(fproduct -> new Product(fproduct)).collect(Collectors.toList());

		return list;
	}

	public List<Product> getallbodyproduct(List<Bodyproducts> bpro, Bodyprodao bpdao) {

		bpro = bpdao.findAll();

		List<Product> list = bpro.stream().map(bproduct -> new Product(bproduct)).collect(Collectors.toList());

		return list;
	}

}

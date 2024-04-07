package com.example.demo.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DAO.Customerorderdao;
import com.example.demo.Entity.CustomerOrders;

@Component
public class Customersaveorders {
	private String order_id;
	private String ref_id;
	private long id;
	private int quant;
	private String mode;

	@Autowired
	Customerorderdao cdao;

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

	public String getRef_id() {
		return ref_id;
	}

	public void setRef_id(String ref_id) {
		this.ref_id = ref_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void adddetails(String order_id2, String ref_id2, long id2, String mode2, int quant2) {
		// TODO Auto-generated method stub

		CustomerOrders ord = new CustomerOrders();
		ord.setId(id2);
		ord.setOrder_id(order_id2);
		ord.setRef_id(ref_id2);
		ord.setMode(mode2);
		ord.setQuant(quant2);
		cdao.save(ord);

	}

}

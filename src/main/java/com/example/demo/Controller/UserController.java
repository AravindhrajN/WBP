package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Faceproducts;
import com.example.demo.Model.CustomerData;
import com.example.demo.Model.Product;
import com.example.demo.services.service;

@RestController
@CrossOrigin(origins = "https://motherbeauty.vercel.app/")
@RequestMapping("api")
public class UserController {

	@Autowired
	service service;

	@GetMapping("fproduct")
	public List<Faceproducts> getfproduct() {

		return service.getproduct("face");

	}

	@GetMapping("getproduct")
	public List<Product> getproduct(@RequestParam("id") long id, @RequestParam("product") String name) {

		return service.gettingproduct(id, name);

	}

	@PostMapping("savedata")
	public List<String> savedata(@RequestParam("id") long id, @RequestParam("mode") String mode,
			@RequestParam("quant") int quant, @ModelAttribute CustomerData customer) {
		List<String> list = new ArrayList<>();
		String order_id, ref_id = null;
		try {
			if ((quant != 0) && (id != 0) && (mode != null) && (customer != null)) {

				order_id = service.orderid();
				ref_id = service.referenceid();

				service.savecustomer_order(customer, quant, mode, id, order_id, ref_id);

				list.add(ref_id);
				list.add(order_id);
				return list;
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		return list;

	}

}

package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Customergetorder;
import com.example.demo.Model.Downloadimage;
import com.example.demo.Model.Product;
import com.example.demo.services.service;

@RestController
@CrossOrigin(origins = "https://motherbeauty.vercel.app/")
@RequestMapping("api")
public class UserController {

	@Autowired
	service service;

	@GetMapping("fproduct")
	public List<Product> getfproduct() {

		return service.getproduct("face");

	}

	@GetMapping("bproduct")
	public List<Product> getbproduct() {

		return service.getproduct("body");

	}

	@GetMapping("getproduct")
	public List<Product> getproduct(@RequestParam("id") long id, @RequestParam("product") String name) {

		return service.gettingproduct(id, name);

	}

	@PostMapping("savedata")
	public List<String> savedata(@RequestBody Customergetorder customer) {
		List<String> list = new ArrayList<>();

		String order_id, ref_id = null;
		try {
			if ((customer.getQuant() != 0) && (customer.getId() != 0) && (customer.getMode() != null)
					&& (customer != null)) {

				order_id = service.orderid();
				ref_id = service.referenceid();

				service.savecustomer_order(customer.getUserdata(), customer.getQuant(), customer.getMode(),
						customer.getId(), order_id, ref_id);

				list.add(ref_id);
				list.add(order_id);

				return list;
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		return list;

	}

	@GetMapping("getimage/{id}/{name}")
	public ResponseEntity<byte[]> getimage(@PathVariable("id") long id, @PathVariable("name") String name,
			Downloadimage dimg) {

		try {
			System.out.println(((Object) id).getClass().getName());
			dimg = service.gettingImage(id, name);
			String content = dimg.getImg_content();

			return ResponseEntity.ok().contentType(MediaType.parseMediaType(content)).body(dimg.getData());
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

}

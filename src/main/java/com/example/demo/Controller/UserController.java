package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Faceproducts;
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

}

package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Product;
import com.example.demo.services.service;

@Controller
public class AdminController {

	@Autowired
	service service;

	@GetMapping("/WBPadmin")
	public String Admin() {
		return "admin";
	}

	@PostMapping("/add_details")
	public ResponseEntity<?> addproducts(@ModelAttribute Product pro, @RequestParam("product") String product,
			@RequestParam("file") MultipartFile file) {

		try {
			if ("face".equals(product)) {

				service.saveFpro(pro);
				service.savefimg(file, pro.getId());
				return ResponseEntity.ok("sucess");
			}

			else if ("body".equals(product)) {

				service.saveBpro(pro);
				service.savebimg(file, pro.getId());
				return ResponseEntity.ok("sucess");
			} else {
				System.out.print("false");
			}

		} catch (Exception e) {
			System.out.print(e);
		}

		return ResponseEntity.ok(null);

	}
}

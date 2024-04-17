package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PutMapping("/change")
	public ResponseEntity<?> update(@RequestParam("id") long id, @RequestParam("selected") String select,
			@RequestParam("change") String change, @RequestParam("selectpro") String product) {
		try {
			if ("face".equals(product)) {

				service.updateface(id, select, change);
				return ResponseEntity.ok("sucess");
			}

			else if ("body".equals(product)) {

				service.updatebody(id, select, change);
				ResponseEntity.accepted();
			} else {
				System.out.print("false");
			}

		} catch (Exception e) {
			System.out.print(e);
		}
		return (ResponseEntity<?>) ResponseEntity.notFound();
	}

//DELETE THE PRODUCT
	@DeleteMapping("/deleteproduct")
	public ResponseEntity<?> delete(@RequestParam("id") String id, @RequestParam("selectproduct") String select) {
		try {
			service.deleteproduct(id, select);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}

package com.example.demo.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.DAO.Bodyprodao;
import com.example.demo.DAO.Bpimgdao;
import com.example.demo.DAO.Faceprodao;
import com.example.demo.DAO.Fp_img_dao;
import com.example.demo.Entity.Bodyproducts;
import com.example.demo.Entity.Bodyproimages;
import com.example.demo.Entity.Faceproducts;
import com.example.demo.Entity.Faceproimages;
import com.example.demo.Model.CustomerData;
import com.example.demo.Model.Customersavedata;
import com.example.demo.Model.Customersaveorders;
import com.example.demo.Model.Downloadimage;
import com.example.demo.Model.Product;

@Service
public class service {

	@Autowired
	private Bodyprodao bpdao;
	@Autowired
	private Bodyproducts bpro;
	@Autowired
	private Bpimgdao bdao;
	@Autowired
	private Bodyproimages bimg;

	@Autowired
	private Faceprodao fpdao;
	@Autowired
	private Faceproducts fpro;
	@Autowired
	private Fp_img_dao fdao;
	@Autowired
	private Faceproimages fimg;
	@Autowired
	private Product pro;
	@Autowired
	private Customersavedata custdet;
	@Autowired
	private Customersaveorders custor;
	@Autowired
	private Downloadimage dimg;

	public void saveFpro(Product pro) {
		// TODO Auto-generated method stub
		try {
			fpro.save(pro);
			fpdao.save(fpro);
			System.out.println(fpdao.findAll());
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public void saveBpro(Product pro) {
		// TODO Auto-generated method stub
		try {
			bpro.save(pro);
			bpdao.save(bpro);
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public void savefimg(MultipartFile file, long id) {
		// TODO Auto-generated method stub

		try {
			fimg.setImg_id(id);
			String originalFilename = file.getOriginalFilename();
			fimg.setImg_name(originalFilename);

			String contentType = file.getContentType();
			fimg.setImg_content(contentType);

			byte[] data = file.getBytes();
			fimg.setData(data);

			// Save the image entity to the database
			fdao.save(fimg);

		} catch (Exception e) {
			System.out.print(e);
		}

	}

	public void savebimg(MultipartFile file, long id) {
		// TODO Auto-generated method stub

		try {
			bimg.setImg_id(id);
			String originalFilename = file.getOriginalFilename();
			bimg.setImg_name(originalFilename);

			String contentType = file.getContentType();
			bimg.setImg_content(contentType);

			byte[] data = file.getBytes();
			bimg.setData(data);

			// Save the image entity to the database
			bdao.save(bimg);

		} catch (Exception e) {
			System.out.print(e);
		}

	}

	public List<Product> getproduct(String string) {

		if (string == "face") {
			List<Faceproducts> fpro = null;
			return pro.getallfaceproduct(fpro, fpdao);
		} else if (string == "body") {
			List<Bodyproducts> bpro = null;
			return pro.getallbodyproduct(bpro, bpdao);
		} else {
			return null;
		}
	}

	public List<Product> gettingproduct(long id, String name) {

		if ("face".equals(name)) {
			try {
				return pro.getfaceproduct(fpro, fpdao, id);
			} catch (Exception e) {
				System.out.print(e);
			}

		}

		else if ("body".equals(name)) {

			try {
				return pro.getbodyproduct(bpro, bpdao, id);
			} catch (Exception e) {
				System.out.print(e);
			}

		}
		return null;
	}

	public String orderid() {
		String orderid = "";
		String num = "0123456789";
		Random ran = new Random();
		for (int i = 0; i < 16; i++) {

			orderid += String.valueOf(num.charAt(ran.nextInt(num.length())));
		}

		return orderid;
	}

	public String referenceid() {
		String refid = "";
		String num = "0123456789";
		String schar = "!@#$%^&*";
		String ucase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lcase = "abcdefghijklmnopqrstuvwxyz";
		Random ran = new Random();
		for (int i = 0; i < 7; i++) {

			refid += String.valueOf(num.charAt(ran.nextInt(num.length())));
		}
		refid += String.valueOf(schar.charAt(ran.nextInt(schar.length())));
		refid += String.valueOf(ucase.charAt(ran.nextInt(ucase.length())));
		for (int i = 0; i < 3; i++) {
			refid += String.valueOf(lcase.charAt(ran.nextInt(lcase.length())));

		}
		return refid;
	}

	public void savecustomer_order(CustomerData customer, int quant, String mode, long id, String order_id,
			String ref_id) {

		custdet.adddetails(customer, ref_id);
		custor.adddetails(order_id, ref_id, id, mode, quant);

	}

	public Downloadimage gettingImage(long id, String name) {

		try {
			if ("face".equals(name)) {

				fimg = fdao.getReferenceById(id);

				return dimg.savefimage(fimg);
			}

			else if ("body".equals(name)) {

				return dimg.savebimage(id);
			} else {
				System.out.print("false");
			}

		} catch (Exception e) {
			System.out.print(e);
		}

		return null;
	}

	public void updateface(long id, String select, String change) {
		// TODO Auto-generated method stub
		fpro = fpdao.getReferenceById(id);

		if (select.equalsIgnoreCase("price")) {

			int price = Integer.parseInt(change);

			fpro.setPrice(price);
			fpdao.save(fpro);

		} else if (select.equalsIgnoreCase("name")) {
			fpro.setName(change);
			fpdao.save(fpro);
		} else {
			fpro.setDes(change);
			fpdao.save(fpro);
		}

	}

	public void updatebody(long id, String select, String change) {
		// TODO Auto-generated method stub

		bpro = bpdao.getReferenceById(id);
		if (select.equalsIgnoreCase("price")) {

			int price = Integer.parseInt(change);

			bpro.setPrice(price);
			bpdao.save(bpro);
		} else if (select.equalsIgnoreCase("name")) {
			bpro.setName(change);
			bpdao.save(bpro);
		} else {
			bpro.setDes(change);
			bpdao.save(bpro);
		}
	}

	public void deleteproduct(String id1, String select) {
		// TODO Auto-generated method stub
		long id = Integer.parseInt(id1);
		if (select.equalsIgnoreCase("face")) {
			fdao.deleteById(id);
			fpdao.deleteById(id);
		} else {
			bpdao.deleteById(id);
			bdao.deleteById(id);
		}

	}

}

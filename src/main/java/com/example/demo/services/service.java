package com.example.demo.services;

import java.util.List;

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

	public List<Faceproducts> getproduct(String string) {
		// TODO Auto-generated method stub
		if (string == "face") {
			return fpdao.findAll();
		} else {
			return null;
		}
	}
}

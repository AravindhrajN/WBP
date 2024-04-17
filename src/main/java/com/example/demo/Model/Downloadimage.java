package com.example.demo.Model;

import org.springframework.stereotype.Component;

import com.example.demo.Entity.Bodyproimages;
import com.example.demo.Entity.Faceproimages;

@Component
public class Downloadimage {

	private Long img_id;
	private String img_name;
	private String img_content;
	private byte[] data;

	public Long getImg_id() {
		return img_id;
	}

	public void setImg_id(Long img_id) {
		this.img_id = img_id;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public String getImg_content() {
		return img_content;
	}

	public void setImg_content(String img_content) {
		this.img_content = img_content;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Downloadimage savefimage(Faceproimages fimg) {
		// TODO Auto-generated method stub
		Downloadimage dimg = new Downloadimage();

		dimg.setImg_id(fimg.getImg_id());
		dimg.setImg_name(fimg.getImg_name());
		dimg.setImg_content(fimg.getImg_content());
		dimg.setData(fimg.getData());

		return dimg;

	}

	public Downloadimage savebimage(Bodyproimages bimg) {
		// TODO Auto-generated method stub
		Downloadimage dimg = new Downloadimage();

		dimg.setImg_id(bimg.getImg_id());
		dimg.setImg_name(bimg.getImg_name());
		dimg.setImg_content(bimg.getImg_content());
		dimg.setData(bimg.getData());

		return dimg;

	}

}

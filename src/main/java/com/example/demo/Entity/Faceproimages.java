package com.example.demo.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "FaceProImages")
public class Faceproimages {
	@Id
	private Long img_id;
	private String img_name;
	private String img_content;
	@Lob
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

}

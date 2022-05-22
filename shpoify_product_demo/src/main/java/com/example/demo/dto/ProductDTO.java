package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductDTO {

	@Id 
	@Column(name = "product_uid", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_uid;
	
	@Column(name = "product_id")
	private int product_id;
	
	@Column(name = "bookName")
	private String bookName;
	@Column(name = "price")
	private int price;

    private int categoryId;
    
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getProduct_uid() {
		return product_uid;
	}

	public void setProduct_uid(int product_uid) {
		this.product_uid = product_uid;
	}
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

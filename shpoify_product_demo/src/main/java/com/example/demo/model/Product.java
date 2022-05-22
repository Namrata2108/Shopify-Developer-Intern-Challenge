package com.example.demo.model;


import org.springframework.stereotype.Component;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Component
@Table(name="PRODUCT")
public class Product {

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
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
	

	@Override
	public String toString() {
		return "UserModel [product_uid=" +product_uid+ ",product_id=" +product_id+ ", bookName=" + bookName + ", price=" + price
				+ "]";
	}
	
}




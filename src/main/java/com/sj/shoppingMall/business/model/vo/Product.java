package com.sj.shoppingMall.business.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class Product {
	private int productNo;
	private int businessNo;
	private String productCategory;
	private String productBrand;
	private String productThumbNail;
	private String productName;
	private String productPrice;
	private String productDetail;
	private ArrayList<String> productSize;
	private ArrayList<String> productCount;
	private char status;
	private Date enrollDate;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productNo, int businessNo, String productCategory, String productBrand, String productThumbNail,
			String productName, String productPrice, String productDetail, ArrayList<String> productSize,
			ArrayList<String> productCount, char status, Date enrollDate) {
		super();
		this.productNo = productNo;
		this.businessNo = businessNo;
		this.productCategory = productCategory;
		this.productBrand = productBrand;
		this.productThumbNail = productThumbNail;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDetail = productDetail;
		this.productSize = productSize;
		this.productCount = productCount;
		this.status = status;
		this.enrollDate = enrollDate;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductThumbNail() {
		return productThumbNail;
	}

	public void setProductThumbNail(String productThumbNail) {
		this.productThumbNail = productThumbNail;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public ArrayList<String> getProductSize() {
		return productSize;
	}

	public void setProductSize(ArrayList<String> productSize) {
		this.productSize = productSize;
	}

	public ArrayList<String> getProductCount() {
		return productCount;
	}

	public void setProductCount(ArrayList<String> productCount) {
		this.productCount = productCount;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public int getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(int businessNo) {
		this.businessNo = businessNo;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", businessNo=" + businessNo + ", productCategory=" + productCategory
				+ ", productBrand=" + productBrand + ", productThumbNail=" + productThumbNail + ", productName="
				+ productName + ", productPrice=" + productPrice + ", productDetail=" + productDetail + ", productSize="
				+ productSize + ", productCount=" + productCount + ", status=" + status + ", enrollDate=" + enrollDate
				+ "]";
	}

}

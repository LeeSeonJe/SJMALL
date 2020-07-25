package com.sj.shoppingMall.customer.model.vo;

import com.sj.shoppingMall.business.model.vo.Product;

public class BucketProduct {
	private int bucketNo;
	private int productNo;
	private int customerNo;
	private String productSize;
	private int productCount;
	private int productPrice;
	private Product product;

	public BucketProduct() {
		// TODO Auto-generated constructor stub
	}

	public BucketProduct(int bucketNo, int productNo, int customerNo, String productSize, int productCount,
			int productPrice) {
		super();
		this.bucketNo = bucketNo;
		this.productNo = productNo;
		this.customerNo = customerNo;
		this.productSize = productSize;
		this.productCount = productCount;
		this.productPrice = productPrice;
	}

	public BucketProduct(int bucketNo, int productNo, int customerNo, String productSize, int productCount,
			int productPrice, Product product) {
		super();
		this.bucketNo = bucketNo;
		this.productNo = productNo;
		this.customerNo = customerNo;
		this.productSize = productSize;
		this.productCount = productCount;
		this.productPrice = productPrice;
		this.product = product;
	}

	public int getBucketNo() {
		return bucketNo;
	}

	public void setBucketNo(int bucketNo) {
		this.bucketNo = bucketNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "BucketProduct [bucketNo=" + bucketNo + ", productNo=" + productNo + ", customerNo=" + customerNo
				+ ", productSize=" + productSize + ", productCount=" + productCount + ", productPrice=" + productPrice
				+ ", product=" + product + "]";
	}

}

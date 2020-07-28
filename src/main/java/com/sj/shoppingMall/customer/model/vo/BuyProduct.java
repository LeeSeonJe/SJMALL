package com.sj.shoppingMall.customer.model.vo;

public class BuyProduct {
	private int buyProductNo;
	private int bucketNo;
	private int customerNo;
	private int productNo;
	private String productThumNail;
	private String productName;
	private String productSize;
	private int productCount;
	private int productPrice;

	public BuyProduct() {
		// TODO Auto-generated constructor stub
	}

	public BuyProduct(int buyProductNo, int bucketNo, int customerNo, int productNo, String productThumNail,
			String productName, String productSize, int productCount, int productPrice) {
		super();
		this.buyProductNo = buyProductNo;
		this.bucketNo = bucketNo;
		this.customerNo = customerNo;
		this.productNo = productNo;
		this.productThumNail = productThumNail;
		this.productName = productName;
		this.productSize = productSize;
		this.productCount = productCount;
		this.productPrice = productPrice;
	}

	public int getBuyProductNo() {
		return buyProductNo;
	}

	public void setBuyProductNo(int buyProductNo) {
		this.buyProductNo = buyProductNo;
	}

	public int getBucketNo() {
		return bucketNo;
	}

	public void setBucketNo(int bucketNo) {
		this.bucketNo = bucketNo;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductThumNail() {
		return productThumNail;
	}

	public void setProductThumNail(String productThumNail) {
		this.productThumNail = productThumNail;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	@Override
	public String toString() {
		return "BuyProduct [buyProductNo=" + buyProductNo + ", bucketNo=" + bucketNo + ", customerNo=" + customerNo
				+ ", productNo=" + productNo + ", productThumNail=" + productThumNail + ", productName=" + productName
				+ ", productSize=" + productSize + ", productCount=" + productCount + ", productPrice=" + productPrice
				+ "]";
	}

}

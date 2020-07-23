package com.sj.shoppingMall.business.model.vo;

public class ProductSize {
	private int productNo;
	private String productSize;
	private String productCount;

	public ProductSize() {
		// TODO Auto-generated constructor stub
	}

	public ProductSize(int productNo, String productSize, String productCount) {
		super();
		this.productNo = productNo;
		this.productSize = productSize;
		this.productCount = productCount;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public String getProductCount() {
		return productCount;
	}

	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}

	@Override
	public String toString() {
		return "ProductSize [productNo=" + productNo + ", productSize=" + productSize + ", productCount=" + productCount
				+ "]";
	}

}

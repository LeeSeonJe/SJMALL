package com.sj.shoppingMall.customer.model.vo;

import java.sql.Date;

public class Order {
	private int orderNo;
	private int addressNo;
	private int customerNo;
	private int productNo;
	private String productSize;
	private int productCount;
	private int productPrice;
	private Date orderDate;
	private char orderStatus;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int orderNo, int addressNo, int customerNo, int productNo, String productSize, int productCount,
			int productPrice, Date orderDate, char orderStatus) {
		super();
		this.orderNo = orderNo;
		this.addressNo = addressNo;
		this.customerNo = customerNo;
		this.productNo = productNo;
		this.productSize = productSize;
		this.productCount = productCount;
		this.productPrice = productPrice;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(int addressNo) {
		this.addressNo = addressNo;
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public char getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(char orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", addressNo=" + addressNo + ", customerNo=" + customerNo + ", productNo="
				+ productNo + ", productSize=" + productSize + ", productCount=" + productCount + ", productPrice="
				+ productPrice + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + "]";
	}

}

package com.sj.shoppingMall.customer.model.vo;

public class Address {
	private int addressNo;
	private int customerNo;
	private String orderName;
	private String orderPhone;
	private int addressCode;
	private String address;
	private String addressDetail;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int addressNo, int customerNo, String orderName, String orderPhone, int addressCode, String address,
			String addressDetail) {
		super();
		this.addressNo = addressNo;
		this.customerNo = customerNo;
		this.orderName = orderName;
		this.orderPhone = orderPhone;
		this.addressCode = addressCode;
		this.address = address;
		this.addressDetail = addressDetail;
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

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public int getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(int addressCode) {
		this.addressCode = addressCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	@Override
	public String toString() {
		return "Address [addressNo=" + addressNo + ", customerNo=" + customerNo + ", orderName=" + orderName
				+ ", orderPhone=" + orderPhone + ", addressCode=" + addressCode + ", address=" + address
				+ ", addressDetail=" + addressDetail + "]";
	}

}

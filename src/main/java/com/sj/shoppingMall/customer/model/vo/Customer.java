package com.sj.shoppingMall.customer.model.vo;

import com.sj.shoppingMall.common.model.vo.Member;

public class Customer {
	private Member member;
	private String name;
	private String phone;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Member member, String name, String phone) {
		super();
		this.member = member;
		this.name = name;
		this.phone = phone;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [member=" + member + ", name=" + name + ", phone=" + phone + "]";
	}

}

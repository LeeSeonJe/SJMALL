package com.sj.shoppingMall.business.model.vo;

import com.sj.shoppingMall.common.model.vo.Member;

public class Business {
	private Member member;
	private String enterName;
	private String businessName;
	private int licenseNo;
	private String businessPhone;

	public Business() {
		// TODO Auto-generated constructor stub
	}

	public Business(Member member, String enterName, String businessName, int licenseNo, String businessPhone) {
		super();
		this.member = member;
		this.enterName = enterName;
		this.businessName = businessName;
		this.licenseNo = licenseNo;
		this.businessPhone = businessPhone;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getEnterName() {
		return enterName;
	}

	public void setEnterName(String enterName) {
		this.enterName = enterName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public int getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(int licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	@Override
	public String toString() {
		return "Business [member=" + member + ", enterName=" + enterName + ", businessName=" + businessName
				+ ", licenseNo=" + licenseNo + ", businessPhone=" + businessPhone + "]";
	}

}

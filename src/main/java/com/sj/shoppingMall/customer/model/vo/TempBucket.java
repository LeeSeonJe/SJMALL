package com.sj.shoppingMall.customer.model.vo;

import java.util.Map;

public class TempBucket {
	private int productNo;
	private Map pBuyList;
	private Map pPriceList;

	public TempBucket() {
		// TODO Auto-generated constructor stub
	}

	public TempBucket(int productNo, Map pBuyList, Map pPriceList) {
		super();
		this.productNo = productNo;
		this.pBuyList = pBuyList;
		this.pPriceList = pPriceList;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public Map getpBuyList() {
		return pBuyList;
	}

	public void setpBuyList(Map pBuyList) {
		this.pBuyList = pBuyList;
	}

	public Map getpPriceList() {
		return pPriceList;
	}

	public void setpPriceList(Map pPriceList) {
		this.pPriceList = pPriceList;
	}

	@Override
	public String toString() {
		return "TempBucket [productNo=" + productNo + ", pBuyList=" + pBuyList + ", pPriceList=" + pPriceList + "]";
	}

}

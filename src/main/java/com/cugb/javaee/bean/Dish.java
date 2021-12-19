package com.cugb.javaee.bean;

import java.math.BigDecimal;

public class Dish {
	@Override
	public String toString() {
		return "Dish [dishid=" + dishid + ", dishname=" + dishname + ", price=" + price + ", desc=" + descrp + ", imag="
				+ imag + "]";
	}
	private int dishid;	
	private String dishname;

	public void setPrice(float price) {
		this.price = price;
	}

	private float price;
	private String descrp;
	private String imag;
	public int getDishid() {
		return dishid;
	}
	public void setDishid(int dishid) {
		this.dishid = dishid;
	}
	public String getDishname() {
		return dishname;
	}
	public void setDishname(String dishname) {
		this.dishname = dishname;
	}
	public float getPrice() {
		return price;
	}

	public String getDescrp() {
		return descrp;
	}
	public void setDescrp(String desc) {
		this.descrp = desc;
	}
	public String getImag() {
		return imag;
	}
	public void setImag(String imag) {
		this.imag = imag;
	}
}

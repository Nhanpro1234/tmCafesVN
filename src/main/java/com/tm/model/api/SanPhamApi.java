package com.tm.model.api;

import java.util.Comparator;


public class SanPhamApi implements Comparator<SanPhamApi> {
	private String ma;
	private String ten;
	private String dvt;
	private String donGia;
	private String giam;
	private String tenBG;
	public SanPhamApi(String ma, String ten, String dvt, String donGia, String giam, String tenBG) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.dvt = dvt;
		this.donGia = donGia;
		this.giam = giam;
		this.tenBG = tenBG;
	}
	public SanPhamApi() {
		super();
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDvt() {
		return dvt;
	}
	public void setDvt(String dvt) {
		this.dvt = dvt;
	}
	public String getDonGia() {
		return donGia;
	}
	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}
	public String getGiam() {
		return giam;
	}
	public void setGiam(String giam) {
		this.giam = giam;
	}
	public String getTenBG() {
		return tenBG;
	}
	public void setTenBG(String tenBG) {
		this.tenBG = tenBG;
	}
	public int compare(SanPhamApi o1, SanPhamApi o2) {
		String[] a = o1.getMa().split("_");
		String[] b = o2.getMa().split("_");
		Integer c = Integer.parseInt(a[1]);
		Integer d = Integer.parseInt(b[1]);
		if(c > d) {
			return 1;
		}else if(c < d) {
			return -1;
		}else {
			return 0;
		}
	}	
}

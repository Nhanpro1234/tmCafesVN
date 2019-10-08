package com.tm.model;

import java.util.Comparator;

public class SanPham implements Comparator<SanPham> {
	private String maSP;
	private String maNhom;
	private String tenSP;
	private String maDVT;
	private String tenDVT;
	private float SLDK;
	private float GTDK;
	private float giaVon;
	private float giaBan;
	private float giam;
	private int khongNhap;
	private int khongXuat;
	private int isMenu;
	
	
	public String getTenDVT() {
		return tenDVT;
	}

	public void setTenDVT(String tenDVT) {
		this.tenDVT = tenDVT;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getMaNhom() {
		return maNhom;
	}

	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getMaDVT() {
		return maDVT;
	}

	public void setMaDVT(String maDVT) {
		this.maDVT = maDVT;
	}

	public float getSLDK() {
		return SLDK;
	}

	public void setSLDK(float sLDK) {
		SLDK = sLDK;
	}

	public float getGTDK() {
		return GTDK;
	}

	public void setGTDK(float gTDK) {
		GTDK = gTDK;
	}

	public float getGiaVon() {
		return giaVon;
	}

	public void setGiaVon(float giaVon) {
		this.giaVon = giaVon;
	}

	public float getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}

	public float getGiam() {
		return giam;
	}

	public void setGiam(float giam) {
		this.giam = giam;
	}

	public int getKhongNhap() {
		return khongNhap;
	}

	public void setKhongNhap(int khongNhap) {
		this.khongNhap = khongNhap;
	}

	public int getKhongXuat() {
		return khongXuat;
	}

	public void setKhongXuat(int khongXuat) {
		this.khongXuat = khongXuat;
	}

	public int getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(int isMenu) {
		this.isMenu = isMenu;
	}

	

	public SanPham(String maSP, String maNhom, String tenSP, String maDVT, String tenDVT, float sLDK, float gTDK,
			float giaVon, float giaBan, float giam, int khongNhap, int khongXuat, int isMenu) {
		super();
		this.maSP = maSP;
		this.maNhom = maNhom;
		this.tenSP = tenSP;
		this.maDVT = maDVT;
		this.tenDVT = tenDVT;
		SLDK = sLDK;
		GTDK = gTDK;
		this.giaVon = giaVon;
		this.giaBan = giaBan;
		this.giam = giam;
		this.khongNhap = khongNhap;
		this.khongXuat = khongXuat;
		this.isMenu = isMenu;
	}

	public SanPham() {
		super();
	}

	public int compare(SanPham o1, SanPham o2) {
		String[] a = o1.getMaSP().split("_");
		String[] b = o2.getMaSP().split("_");
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

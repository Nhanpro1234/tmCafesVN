package com.tm.model;

import java.util.Comparator;


public class NhomKhachHang implements Comparator<NhomKhachHang> {
	private String maNhom;
	private String maCha;
	private String tenNhom;
	private int loaiNhom; // 0 la khach hang 1 nha cung cap
	
	public NhomKhachHang(String maNhom, String maCha, String tenNhom, int loaiNhom) {
		super();
		this.maNhom = maNhom;
		this.maCha = maCha;
		this.tenNhom = tenNhom;
		this.loaiNhom = loaiNhom;
	}
	public NhomKhachHang() {
		super();
	}
	public String getMaNhom() {
		return maNhom;
	}
	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}
	public String getMaCha() {
		return maCha;
	}
	public void setMaCha(String maCha) {
		this.maCha = maCha;
	}
	public String getTenNhom() {
		return tenNhom;
	}
	public void setTenNhom(String tenNhom) {
		this.tenNhom = tenNhom;
	}
	public int getLoaiNhom() {
		return loaiNhom;
	}
	public void setLoaiNhom(int loaiNhom) {
		this.loaiNhom = loaiNhom;
	}
	public int compare(NhomKhachHang o1, NhomKhachHang o2) {
		String[] a = o1.getMaNhom().split("_");
		String[] b = o2.getMaNhom().split("_");
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

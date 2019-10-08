package com.tm.model;

import java.util.Comparator;

public class KhachHang  implements Comparator<KhachHang>{
	private String maKH;
	private String maNhom;
	private String tenKH;
	private String diaChi;
	private String dienThoai;
	private String maSoThue;
	private float thuDK;
	private float traDK;
	
	public KhachHang() {
		super();
	}
	public KhachHang(String maKH, String maNhom, String tenKH, String diaChi, String dienThoai, String maSoThue,
			float thuDK, float traDK) {
		super();
		this.maKH = maKH;
		this.maNhom = maNhom;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.maSoThue = maSoThue;
		this.thuDK = thuDK;
		this.traDK = traDK;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaSoThue() {
		return maSoThue;
	}
	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public float getThuDK() {
		return thuDK;
	}
	public void setThuDK(float thuDK) {
		this.thuDK = thuDK;
	}
	public float getTraDK() {
		return traDK;
	}
	public void setTraDK(float traDK) {
		this.traDK = traDK;
	}
	
	public String getMaNhom() {
		return maNhom;
	}
	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}
	public int compare(KhachHang o1, KhachHang o2) {
		String[] a = o1.getMaKH().split("_");
		String[] b = o2.getMaKH().split("_");
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

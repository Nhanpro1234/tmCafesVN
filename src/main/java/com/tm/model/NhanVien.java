package com.tm.model;

import java.util.Comparator;

public class NhanVien implements Comparator<NhanVien> {
	private String maNV;
	private String maBP;
	private String hoTen;
	private String diaChi;
	private String dienThoai;
	private String maSoThue;
	private int isKeToan;
	private int isThuNgan;
	public NhanVien() {
		super();
	}
	public NhanVien(String maNV, String maBP, String hoTen, String diaChi, String dienThoai, String maSoThue,
			int isKeToan, int isThuNgan) {
		super();
		this.maNV = maNV;
		this.maBP = maBP;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.maSoThue = maSoThue;
		this.isKeToan = isKeToan;
		this.isThuNgan = isThuNgan;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMaBP() {
		return maBP;
	}
	public void setMaBP(String maBP) {
		this.maBP = maBP;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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
	public String getMaSoThue() {
		return maSoThue;
	}
	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
	public int getIsKeToan() {
		return isKeToan;
	}
	public void setIsKeToan(int isKeToan) {
		this.isKeToan = isKeToan;
	}
	public int getIsThuNgan() {
		return isThuNgan;
	}
	public void setIsThuNgan(int isThuNgan) {
		this.isThuNgan = isThuNgan;
	}
	public int compare(NhanVien o1, NhanVien o2) {
		String[] a = o1.getMaNV().split("_");
		String[] b = o2.getMaNV().split("_");
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

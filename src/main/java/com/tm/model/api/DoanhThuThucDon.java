package com.tm.model.api;

public class DoanhThuThucDon {
	private String tenSP;
	private String maDVT;
	private int soLuong;
	private float donGia;
	private float giamGia;
	private float doanhSo;
	private float trungBinh;
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
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public float getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(float giamGia) {
		this.giamGia = giamGia;
	}
	public float getDoanhSo() {
		return doanhSo;
	}
	public void setDoanhSo(float doanhSo) {
		this.doanhSo = doanhSo;
	}
	public float getTrungBinh() {
		return trungBinh;
	}
	public void setTrungBinh(float trungBinh) {
		this.trungBinh = trungBinh;
	}
	public DoanhThuThucDon(String tenSP, String maDVT, int soLuong, float donGia, float giamGia, float doanhSo,
			float trungBinh) {
		super();
		this.tenSP = tenSP;
		this.maDVT = maDVT;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.giamGia = giamGia;
		this.doanhSo = doanhSo;
		this.trungBinh = trungBinh;
	}
	public DoanhThuThucDon() {
		super();
	}
	
}

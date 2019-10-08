package com.tm.model;

public class DonViTinh {
	private String maDVT;
	private String tenDVT;
	private String macDinh;
	public DonViTinh() {
		super();
	}
	public DonViTinh(String maDVT, String tenDVT, String macDinh) {
		super();
		this.maDVT = maDVT;
		this.tenDVT = tenDVT;
		this.macDinh = macDinh;
	}
	public String getMaDVT() {
		return maDVT;
	}
	public void setMaDVT(String maDVT) {
		this.maDVT = maDVT;
	}
	public String getTenDVT() {
		return tenDVT;
	}
	public void setTenDVT(String tenDVT) {
		this.tenDVT = tenDVT;
	}
	public String getMacDinh() {
		return macDinh;
	}
	public void setMacDinh(String macDinh) {
		this.macDinh = macDinh;
	}
}

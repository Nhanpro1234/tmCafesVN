package com.tm.model;

public class TaiKhoan {
	private String taiKhoan;
	private String matKhau;
	private String maNV;
	private String maBP;
	private String hoTen;
	private String diaChi;
	private String dienThoai;
	private String maSoThue;
	private int isKeToan;
	private int isThuNgan;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public TaiKhoan(String taiKhoan, String matKhau, String maNV, String maBP, String hoTen, String diaChi,
			String dienThoai, String maSoThue, int isKeToan, int isThuNgan, String role) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.maNV = maNV;
		this.maBP = maBP;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.maSoThue = maSoThue;
		this.isKeToan = isKeToan;
		this.isThuNgan = isThuNgan;
		this.role = role;
	}
	
	
	public TaiKhoan(String taiKhoan, String matKhau, String maNV, String role) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.maNV = maNV;
		this.role = role;
	}
	public TaiKhoan() {
		super();
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
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	@Override
	public String toString() {
		return "TaiKhoan [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", maNV=" + maNV + ", maBP=" + maBP
				+ ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", dienThoai=" + dienThoai + ", maSoThue=" + maSoThue
				+ ", isKeToan=" + isKeToan + ", isThuNgan=" + isThuNgan + ", role=" + role + "]";
	}
}

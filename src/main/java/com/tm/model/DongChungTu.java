package com.tm.model;

public class DongChungTu  {
	private int id;
	private int soCT;
	private String maSP;
	private String tenSP;
	private String maDVT;
	private String tenDVT;
	private int soLuong;
	private float donGia;
	private String gioVao;
	private String gioRa;
	private int traLai;
	private float giam;
	private String ghiChu;
	private int status; // 0 la chua xoa, 1 la da xoa
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public DongChungTu(int id, int soCT, String maSP, String tenSP, String maDVT, String tenDVT, int soLuong,
			float donGia, String gioVao, String gioRa, int traLai, float giam, String ghiChu, int status) {
		super();
		this.id = id;
		this.soCT = soCT;
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.maDVT = maDVT;
		this.tenDVT = tenDVT;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.gioVao = gioVao;
		this.gioRa = gioRa;
		this.traLai = traLai;
		this.giam = giam;
		this.ghiChu = ghiChu;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSoCT() {
		return soCT;
	}
	public void setSoCT(int soCT) {
		this.soCT = soCT;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
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
	public String getTenDVT() {
		return tenDVT;
	}
	public void setTenDVT(String tenDVT) {
		this.tenDVT = tenDVT;
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
	public String getGioVao() {
		return gioVao;
	}
	public void setGioVao(String gioVao) {
		this.gioVao = gioVao;
	}
	public String getGioRa() {
		return gioRa;
	}
	public void setGioRa(String gioRa) {
		this.gioRa = gioRa;
	}
	public int getTraLai() {
		return traLai;
	}
	public void setTraLai(int traLai) {
		this.traLai = traLai;
	}
	public float getGiam() {
		return giam;
	}
	public void setGiam(float giam) {
		this.giam = giam;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}

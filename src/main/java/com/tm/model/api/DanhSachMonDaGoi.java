package com.tm.model.api;

public class DanhSachMonDaGoi {
	private int id;
	private String soBan;
	private String tenSP;
	private int soLuong;
	private String gioVao;
	
	public DanhSachMonDaGoi() {
		super();
	}
	public DanhSachMonDaGoi(int id, String soBan, String tenSP, int soLuong, String gioVao) {
		super();
		this.id = id;
		this.soBan = soBan;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.gioVao = gioVao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSoBan() {
		return soBan;
	}
	public void setSoBan(String soBan) {
		this.soBan = soBan;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getGioVao() {
		return gioVao;
	}
	public void setGioVao(String gioVao) {
		this.gioVao = gioVao;
	}
	
	
}

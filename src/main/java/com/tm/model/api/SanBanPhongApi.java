package com.tm.model.api;

public class SanBanPhongApi {
	private String soBan;
	private String thoiGianVao;
	private float tongTien;
	private int tinhTrang; // 0 la bàn kín 1 là bán trống
	public SanBanPhongApi() {
		super();
	}
	public SanBanPhongApi(String soBan, String thoiGianVao, float tongTien, int tinhTrang) {
		super();
		this.soBan = soBan;
		this.thoiGianVao = thoiGianVao;
		this.tongTien = tongTien;
		this.tinhTrang = tinhTrang;
	}
	public String getSoBan() {
		return soBan;
	}
	public void setSoBan(String soBan) {
		this.soBan = soBan;
	}
	public String getThoiGianVao() {
		return thoiGianVao;
	}
	public void setThoiGianVao(String thoiGianVao) {
		this.thoiGianVao = thoiGianVao;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
}

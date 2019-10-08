package com.tm.model;

import java.util.Comparator;

public class SanBanPhong implements Comparator<SanBanPhong> {
	private String soBan;
	private String maKV;
	private String tenKV;
	private String maBG;
	private String tenBG;
	
	public SanBanPhong() {
		super();
	}
	public SanBanPhong(String soBan, String maKV, String tenKV, String maBG, String tenBG) {
		super();
		this.soBan = soBan;
		this.maKV = maKV;
		this.tenKV = tenKV;
		this.maBG = maBG;
		this.tenBG = tenBG;
	}
	public String getSoBan() {
		return soBan;
	}
	public void setSoBan(String soBan) {
		this.soBan = soBan;
	}
	public String getMaKV() {
		return maKV;
	}
	public void setMaKV(String maKV) {
		this.maKV = maKV;
	}
	public String getTenKV() {
		return tenKV;
	}
	public void setTenKV(String tenKV) {
		this.tenKV = tenKV;
	}
	public String getMaBG() {
		return maBG;
	}
	public void setMaBG(String maBG) {
		this.maBG = maBG;
	}
	public String getTenBG() {
		return tenBG;
	}
	public void setTenBG(String tenBG) {
		this.tenBG = tenBG;
	}
	public int compare(SanBanPhong o1, SanBanPhong o2) {
		String[] a = o1.getSoBan().split("_");
		String[] b = o2.getSoBan().split("_");
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

package com.tm.model;

import java.util.Comparator;

public class KhuVuc implements Comparator<KhuVuc> {
	private String maKV;
	private String tenKV;
	public KhuVuc() {
		super();
	}
	public KhuVuc(String maKV, String tenKV) {
		super();
		this.maKV = maKV;
		this.tenKV = tenKV;
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
	public int compare(KhuVuc o1, KhuVuc o2) {
		String[] a = o1.getMaKV().split("_");
		String[] b = o2.getMaKV().split("_");
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

package com.tm.model;

import java.util.Comparator;

public class BoPhan implements Comparator<BoPhan> {
	private String maBP;
	private String maCha;
	private String tenBP;
	public BoPhan(String maBP, String maCha, String tenBP) {
		super();
		this.maBP = maBP;
		this.maCha = maCha;
		this.tenBP = tenBP;
	}
	public BoPhan() {
		super();
	}
	public String getMaBP() {
		return maBP;
	}
	public void setMaBP(String maBP) {
		this.maBP = maBP;
	}
	public String getMaCha() {
		return maCha;
	}
	public void setMaCha(String maCha) {
		this.maCha = maCha;
	}
	public String getTenBP() {
		return tenBP;
	}
	public void setTenBP(String tenBP) {
		this.tenBP = tenBP;
	}
	public int compare(BoPhan o1, BoPhan o2) {
		String[] a = o1.getMaBP().split("_");
		String[] b = o2.getMaBP().split("_");
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

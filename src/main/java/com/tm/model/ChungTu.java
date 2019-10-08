package com.tm.model;

public class ChungTu {
	private int soCT;	
	private String ngayCT;	
	private int loai;	
	private String soBan;
	private String maKH;	
	private int soKhach;	
	private String noiDung;	
	private String maThuNgan;	
	private String maNhanVien;
	private float giam;	
	private float thueVAT;	
	private float phiPV;	
	private float soTien;
	private float traTruoc;	
	private float conNo;	
	private String ngayDat;	
	private int trangThai;
	
	public ChungTu() {
		super();
	}
	public ChungTu(int soCT, String ngayCT, int loai, String soBan, String maKH, int soKhach, String noiDung,
			String maThuNgan, String maNhanVien, float giam, float thueVAT, float phiPV, float soTien, float traTruoc,
			float conNo, String ngayDat, int trangThai) {
		super();
		this.soCT = soCT;
		this.ngayCT = ngayCT;
		this.loai = loai;
		this.soBan = soBan;
		this.maKH = maKH;
		this.soKhach = soKhach;
		this.noiDung = noiDung;
		this.maThuNgan = maThuNgan;
		this.maNhanVien = maNhanVien;
		this.giam = giam;
		this.thueVAT = thueVAT;
		this.phiPV = phiPV;
		this.soTien = soTien;
		this.traTruoc = traTruoc;
		this.conNo = conNo;
		this.ngayDat = ngayDat;
		this.trangThai = trangThai;
	}
	public int getSoCT() {
		return soCT;
	}
	public void setSoCT(int soCT) {
		this.soCT = soCT;
	}
	public String getNgayCT() {
		return ngayCT;
	}
	public void setNgayCT(String ngayCT) {
		this.ngayCT = ngayCT;
	}
	public int getLoai() {
		return loai;
	}
	public void setLoai(int loai) {
		this.loai = loai;
	}
	public String getSoBan() {
		return soBan;
	}
	public void setSoBan(String soBan) {
		this.soBan = soBan;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public int getSoKhach() {
		return soKhach;
	}
	public void setSoKhach(int soKhach) {
		this.soKhach = soKhach;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getMaThuNgan() {
		return maThuNgan;
	}
	public void setMaThuNgan(String maThuNgan) {
		this.maThuNgan = maThuNgan;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public float getGiam() {
		return giam;
	}
	public void setGiam(float giam) {
		this.giam = giam;
	}
	public float getThueVAT() {
		return thueVAT;
	}
	public void setThueVAT(float thueVAT) {
		this.thueVAT = thueVAT;
	}
	public float getPhiPV() {
		return phiPV;
	}
	public void setPhiPV(float phiPV) {
		this.phiPV = phiPV;
	}
	public float getSoTien() {
		return soTien;
	}
	public void setSoTien(float soTien) {
		this.soTien = soTien;
	}
	public float getTraTruoc() {
		return traTruoc;
	}
	public void setTraTruoc(float traTruoc) {
		this.traTruoc = traTruoc;
	}
	public float getConNo() {
		return conNo;
	}
	public void setConNo(float conNo) {
		this.conNo = conNo;
	}
	public String getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(String ngayDat) {
		this.ngayDat = ngayDat;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "ChungTu [soCT=" + soCT + ", ngayCT=" + ngayCT + ", loai=" + loai + ", soBan=" + soBan + ", maKH=" + maKH
				+ ", soKhach=" + soKhach + ", noiDung=" + noiDung + ", maThuNgan=" + maThuNgan + ", maNhanVien="
				+ maNhanVien + ", giam=" + giam + ", thueVAT=" + thueVAT + ", phiPV=" + phiPV + ", soTien=" + soTien
				+ ", traTruoc=" + traTruoc + ", conNo=" + conNo + ", ngayDat=" + ngayDat + ", trangThai=" + trangThai
				+ "]";
	} 
}

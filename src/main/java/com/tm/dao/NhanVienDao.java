package com.tm.dao;

import java.util.List;

import com.tm.model.NhanVien;


public interface NhanVienDao {
	public List<NhanVien> get();
	
	public List<NhanVien> getByMaBP(String maBP);

	public NhanVien getByMaNV(String maNV);

	public String add(NhanVien nhanVien);

	public String update(NhanVien nhanVien);

	public String del(String maNV);
}

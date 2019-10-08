package com.tm.dao;

import java.util.List;

import com.tm.model.SanPham;


public interface SanPhamDao {
	public List<SanPham> get();
	
	public List<SanPham> getByMaNhom(String maNhom);

	public SanPham getByMaSP(String maSP);

	public String add(SanPham sanPham);

	public String update(SanPham sanPham);

	public String del(String maSP);
}
package com.tm.dao;

import java.util.List;

import com.tm.model.KhachHang;

public interface KhachHangDao {
	public List<KhachHang> get();
	public List<KhachHang> getByMaNhom(String maNhom);
	public KhachHang getByMaKhachHang(String maKH);
	public String add(KhachHang a);
	public String update(KhachHang a);
	public String delete(String maKH);
	public boolean isMaKhachHang(String maKH);
}

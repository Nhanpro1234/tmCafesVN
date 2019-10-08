package com.tm.dao;

import java.util.List;

import com.tm.model.TaiKhoan;

public interface TaiKhoanDao {
	public List<TaiKhoan> get();
	
	public List<TaiKhoan> getAll();
	
	public TaiKhoan getByTaiKhoan(String taiKhoan);
	
	public String add(TaiKhoan taiKhoan);
	
	public String update(TaiKhoan taiKhoan);
	
	public String delete(String taiKhoan);
	
	public boolean login(String taiKhoan, String matKhau);
	
	public boolean isTaiKhoan(String taiKhoan);

	public boolean isMaNV(String maNV);
}

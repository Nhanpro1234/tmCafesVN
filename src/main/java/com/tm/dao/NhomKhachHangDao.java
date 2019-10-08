package com.tm.dao;

import java.util.List;

import com.tm.model.NhomKhachHang;

public interface NhomKhachHangDao {
	public List<NhomKhachHang> get();
	public NhomKhachHang getByMaNhom(String maNhom);
	public String add(NhomKhachHang a);
	public String update(NhomKhachHang a);
	public String delete(String maNhom);
	public String deleteByMaCha(String maCha);
	public boolean isMaNhom(String maNhom);
	public boolean isMaCha(String maCha);
}

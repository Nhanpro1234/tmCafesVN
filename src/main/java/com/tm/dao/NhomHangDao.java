package com.tm.dao;

import java.util.List;

import com.tm.model.NhomHang;


public interface NhomHangDao {
	public List<NhomHang> get();
	
	public NhomHang getByMaNhom(String maNhom);
	
	public String add(NhomHang nhomHang);
	
	public String update(NhomHang nhomHang);
	
	public String delete(String maNhom);
	
	public boolean isMaNhom(String maNhom);
	
	public boolean isMaCha(String maCha);
	
	public String deleteByMaCha(String maCha);
	
	public String moveNhom(String maNhom, String maCha);
}

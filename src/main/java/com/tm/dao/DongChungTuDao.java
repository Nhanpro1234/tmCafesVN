package com.tm.dao;

import java.util.List;

import com.tm.model.DongChungTu;

public interface DongChungTuDao {
	public List<DongChungTu> get();
	
	public DongChungTu getById(int id);
	
	public List<DongChungTu> getBySoCT(int soCT);
	
	public String add(DongChungTu dongChungTu);
	
	public String update(DongChungTu dongChungTu);
	
	public String deleteById(int id);
	
	public String deleteBySoCT(int soCT);
	
	public String updateSoLuong(int soCT, String maSP, int soLuong);
	
	public String updateByCT(int soCT_old, int soCT_new);
	
	public String update_by_sql(String colum_key, Object value_key, String colum_data, Object value_data);
	
	public boolean isSP(int soCT, String maSP);
	
	public float thanhTien(int soCT);
	
	public boolean isGhiChu(int soCT);
}

package com.tm.dao;

import java.util.List;

import com.tm.model.ChungTu;

public interface ChungTuDao {
	public List<ChungTu> get();
	
	public ChungTu getBySoCT(int soCT);

	public List<ChungTu> getByTinhTrang(int tinhTrang);
	
	public ChungTu getBySoBan(String soBan, int tinhTrang);
	
	public String add(ChungTu chungTu);
	
	public String update(ChungTu chungTu);
	
	public String chuyenBan(int soCT, String soBan);
	
	public String huyBan(int soCT);
	
	public String thanhToan(int soCT);
	
	public String update_by_sql(String colum_key, Object value_key, String colum_data, Object value_data);
	
	public boolean checkBan(String maBan, int type);
	
	public float tongTien(int soCT);
}

package com.tm.dao.api;

import java.util.List;

import com.tm.model.api.SanPhamApi;

public interface SanPhamApiDao {
	public List<SanPhamApi> get();
	
	public List<SanPhamApi> getByMaNhom(String maNhom);
}

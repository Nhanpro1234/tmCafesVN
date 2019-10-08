package com.tm.dao.api;

import java.util.List;

import com.tm.model.api.DoanhThuThucDon;

public interface DoanhThuApiDao {
	public List<DoanhThuThucDon> getThucDon(String time_start, String time_ends, String nhanVien);
}

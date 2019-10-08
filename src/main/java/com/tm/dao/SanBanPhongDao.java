package com.tm.dao;

import java.util.List;

import com.tm.model.SanBanPhong;

public interface SanBanPhongDao {
	public List<SanBanPhong> get();

	public List<SanBanPhong> getByKhuVuc(String khuVuc);

	public List<SanBanPhong> getByBangGia(String bangGia);
	
	public SanBanPhong getBySoBan(String soBan);
	
	public String add(SanBanPhong sanBanPhong);
	
	public String update(SanBanPhong  sanBanPhong);
	
	public String delete(String soBan);
}

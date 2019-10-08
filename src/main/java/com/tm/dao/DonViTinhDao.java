package com.tm.dao;

import java.util.List;

import com.tm.model.DonViTinh;


public interface DonViTinhDao {
	public List<DonViTinh> get();

	public DonViTinh getByMaDonViTinh(String maDVT);

	public String add(DonViTinh donViTinh);

	public String update(DonViTinh donViTinh);

	public String del(String maDVT);
}

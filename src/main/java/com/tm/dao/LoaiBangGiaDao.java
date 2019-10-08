package com.tm.dao;

import java.util.List;

import com.tm.model.LoaiBangGia;


public interface LoaiBangGiaDao {
	public List<LoaiBangGia> get();
	
	public LoaiBangGia getByMaKhuVuc(String maBG);
	
	public String add(LoaiBangGia loaiBangGia);
	
	public String update(LoaiBangGia loaiBangGia);
	
	public String del(String maBG);
}

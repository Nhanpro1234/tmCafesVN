package com.tm.dao;

import java.util.List;

import com.tm.model.KhuVuc;

public interface KhuVucDao {
	public List<KhuVuc> get();
	
	public KhuVuc getByMaKhuVuc(String maKV);
	
	public String add(KhuVuc khuVuc);
	
	public String update(KhuVuc khuVuc);
	
	public String del(String maKV);
}

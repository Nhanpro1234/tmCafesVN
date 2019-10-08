package com.tm.dao;

import java.util.List;

import com.tm.model.BoPhan;


public interface BoPhanDao {
	public List<BoPhan> get();
	
	public BoPhan getByMaBP(String maBP);
	
	public String add(BoPhan BoPhan);
	
	public String update(BoPhan BoPhan);
	
	public String delete(String maBP);
	
	public boolean isMaBP(String maBP);
	
	public boolean isMaCha(String maCha);
	
	public String deleteByMaCha(String maCha);
	
	public String moveBoPhan(String maBP, String maCha);
}

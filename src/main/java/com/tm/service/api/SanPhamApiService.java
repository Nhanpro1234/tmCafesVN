package com.tm.service.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.api.SanPhamApiDao;
import com.tm.model.api.SanPhamApi;

@Service
public class SanPhamApiService implements SanPhamApiDao {
	
	@Autowired
	SanPhamApiDao sanPhamApiDao;

	public List<SanPhamApi> get() {
		List<SanPhamApi> list = sanPhamApiDao.get();
		Collections.sort(list, new SanPhamApi());
		return list;
	}

	public List<SanPhamApi> getByMaNhom(String maNhom) {
		return sanPhamApiDao.getByMaNhom(maNhom);
	}

}

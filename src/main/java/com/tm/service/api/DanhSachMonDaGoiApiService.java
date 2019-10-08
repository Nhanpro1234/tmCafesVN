package com.tm.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.api.DanhSachMonDaGoiApiDao;
import com.tm.model.api.DanhSachMonDaGoi;

@Service
public class DanhSachMonDaGoiApiService implements DanhSachMonDaGoiApiDao {

	@Autowired
	DanhSachMonDaGoiApiDao danhSachMonDaGoiApiDao;
	
	public List<DanhSachMonDaGoi> get() {
		return danhSachMonDaGoiApiDao.get();
	}

	
}

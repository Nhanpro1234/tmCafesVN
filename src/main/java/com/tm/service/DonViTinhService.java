package com.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.DonViTinhDao;
import com.tm.model.DonViTinh;

@Service
public class DonViTinhService implements DonViTinhDao {
	
	@Autowired
	DonViTinhDao donViTinhDao;

	public List<DonViTinh> get() {
		return donViTinhDao.get();
	}

	public DonViTinh getByMaDonViTinh(String maDVT) {
		return donViTinhDao.getByMaDonViTinh(maDVT);
	}

	public String add(DonViTinh donViTinh) {
		if(donViTinh.getTenDVT().trim().equals("")) {
			return "Bạn không được để trống";
		}
		
		return donViTinhDao.add(donViTinh);
	}

	public String update(DonViTinh donViTinh) {
		if(donViTinh.getTenDVT().trim().equals("")) {
			return "Bạn không được để trống";
		}
		
		return donViTinhDao.update(donViTinh);
	}

	public String del(String maDVT) {
		if(maDVT.trim().equals("")) {
			return "Bạn không được để trống";
		}
		
		return donViTinhDao.del(maDVT);
	}
	
	
}

package com.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.KhachHangDao;
import com.tm.model.KhachHang;

@Service
public class KhachHangService implements KhachHangDao {

	@Autowired
	KhachHangDao khachHangDao;
	@Autowired
	NhomKhachHangService nhomKhachHangService;
	
	public List<KhachHang> get() {
		return khachHangDao.get();
	}

	public List<KhachHang> getByMaNhom(String maNhom) {
		if(maNhom.trim().equals("")) {
			return null;
		}
		
		return khachHangDao.getByMaNhom(maNhom);
	}

	public KhachHang getByMaKhachHang(String maKH) {
		if(maKH.trim().equals("")) {
			return null;
		}
		
		return khachHangDao.getByMaKhachHang(maKH);
	}

	public String add(KhachHang a) {
		if(a.getMaNhom().trim().equals("") ||
				a.getMaSoThue().trim().equals("") ||
				a.getTenKH().trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		
		if(!nhomKhachHangService.isMaNhom(a.getMaNhom())) {
			return "Mã nhóm không tồn tại";
		}
		
		return khachHangDao.add(a);
	}

	public String update(KhachHang a) {
		if(a.getMaKH().trim().equals("") ||
				a.getMaNhom().trim().equals("") ||
				a.getMaSoThue().trim().equals("") ||
				a.getTenKH().trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		
		return khachHangDao.update(a);
	}

	public String delete(String maKH) {
		if(maKH.trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		
		return khachHangDao.delete(maKH);
	}

	public boolean isMaKhachHang(String maKH) {
		if(maKH.trim().equals("")) {
			return false;
		}
		
		return khachHangDao.isMaKhachHang(maKH);
	}

}

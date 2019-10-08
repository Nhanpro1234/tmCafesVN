package com.tm.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.TaiKhoanDao;
import com.tm.model.TaiKhoan;

@Service
public class TaiKhoanService implements TaiKhoanDao {

	@Autowired
	TaiKhoanDao taiKhoanDao;

	public List<TaiKhoan> get() {
		return taiKhoanDao.get();
	}

	public TaiKhoan getByTaiKhoan(String taiKhoan) {
		if(taiKhoan.trim().equals("")) {
			return null;
		}
		
		return taiKhoanDao.getByTaiKhoan(taiKhoan);
	}

	public String add(TaiKhoan taiKhoan) {
		if(isTaiKhoan(taiKhoan.getTaiKhoan())) {
			return "Đã tồn tại";
		}
		
		if(isMaNV(taiKhoan.getMaNV())) {
			return "Một nhân viên không thể 2 tài khoản";
		}
		
		if(taiKhoan.getRole().equals("ROLE_ADMIN")) {
			return "Xin lỗi, chỉ một người làm admin";
		}
		
		return taiKhoanDao.add(taiKhoan);
	}

	public String update(TaiKhoan taiKhoan) {
		if(!isTaiKhoan(taiKhoan.getTaiKhoan())) {
			return "Nhân viên này không tồn tại";
		}
		
		return taiKhoanDao.update(taiKhoan);
	}

	public String delete(String taiKhoan) {
		if(taiKhoan.trim().equals("")) {
			return null;
		}
		
		if(taiKhoan.toLowerCase().equals("admin")) {
			return "Bạn không thể xóa admin";
		}
		
		if(this.getByTaiKhoan(taiKhoan).getRole().toUpperCase() == "ROLE_ADMIN") {
			return "Bạn không thể xóa admin";
		}
		
		return taiKhoanDao.delete(taiKhoan);
	}
	
	public boolean login(String taiKhoan, String matKhau) {
		if(taiKhoan.trim().equals("")) {
			return false;
		}
		
		if(taiKhoan.matches("[\\w]{3,25}")) {
			return taiKhoanDao.login(taiKhoan, Base64.getEncoder().encodeToString(matKhau.getBytes()));
		}else {
			return false;
		}
	}

	public List<TaiKhoan> getAll() {
		return taiKhoanDao.getAll();
	}

	public boolean isTaiKhoan(String taiKhoan) {
		if(taiKhoan.trim().equals("")) {
			return false;
		}
		return taiKhoanDao.isTaiKhoan(taiKhoan);
	}

	public boolean isMaNV(String maNV) {
		if(maNV.trim().equals("")) {
			return  false;
		}
		return taiKhoanDao.isMaNV(maNV);
	}

}

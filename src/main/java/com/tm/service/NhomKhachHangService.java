package com.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.NhomKhachHangDao;
import com.tm.model.NhomKhachHang;

@Service
public class NhomKhachHangService implements NhomKhachHangDao {

	@Autowired
	NhomKhachHangDao nhomKhachHangDao;
	
	public List<NhomKhachHang> get() {
		return nhomKhachHangDao.get();
	}

	public NhomKhachHang getByMaNhom(String maNhom) {
		if(maNhom.trim().equals("")) {
			return null;
		}
		
		return nhomKhachHangDao.getByMaNhom(maNhom);
	}

	public String add(NhomKhachHang a) {
		if(a.getTenNhom().trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		
		if(a.getMaCha().equals("0")) {
			a.setMaCha(null);
		}
		
		if(a.getLoaiNhom() == 1 || a.getLoaiNhom() == 2) {
			return nhomKhachHangDao.add(a);
		}else {
			return "Loại nhóm không tồn tại";
		}
	}

	public String update(NhomKhachHang a) {
		if(a.getTenNhom().trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		
		if(!this.isMaNhom(a.getMaNhom())) {
			return "Mã nhóm không tồn tại";
		}
		
		if(a.getMaCha().equals("0")) {
			a.setMaCha(null);
		}else {
			if(!this.isMaNhom(a.getMaCha())) {
				return "Mã cha không tồn tại";
			}
		}
		
		if(a.getLoaiNhom() == 1 || a.getLoaiNhom() == 2) {
			return nhomKhachHangDao.update(a);
		}else {
			return "Loại nhóm không tồn tại";
		}
	}

	public String delete(String maNhom) {
		if(maNhom.trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		return nhomKhachHangDao.delete(maNhom);
	}

	public String deleteByMaCha(String maCha) {
		if(maCha.trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		return nhomKhachHangDao.deleteByMaCha(maCha);
	}

	public boolean isMaNhom(String maNhom) {
		if(maNhom.trim().equals("")) {
			return false;
		}
		return nhomKhachHangDao.isMaNhom(maNhom);
	}

	public boolean isMaCha(String maCha) {
		if(maCha.trim().equals("")) {
			return false;
		}
		return nhomKhachHangDao.isMaCha(maCha);
	}

}

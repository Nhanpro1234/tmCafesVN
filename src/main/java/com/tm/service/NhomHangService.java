package com.tm.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.NhomHangDao;
import com.tm.model.NhomHang;

@Service
public class NhomHangService implements NhomHangDao {

	@Autowired
	NhomHangDao nhomHangDao;

	public List<NhomHang> get() {
		List<NhomHang> list = nhomHangDao.get();
		Collections.sort(list, new NhomHang());
		return list;
	}

	public NhomHang getByMaNhom(String maNhom) {
		return nhomHangDao.getByMaNhom(maNhom);
	}

	public String add(NhomHang nhomHang) {
		if(nhomHang.getLoaiNhom() == 1 || nhomHang.getLoaiNhom() == 2 || nhomHang.getLoaiNhom() == 3 || nhomHang.getLoaiNhom() == 4) {
			return nhomHangDao.add(nhomHang);
		}else{
			if(nhomHang.getTenNhom().trim().equals("")) {
				return "Bạn không được để trống";
			}
			return "Loại nhóm không đúng";
		}
	}

	public String update(NhomHang nhomHang) {
		if(nhomHang.getTenNhom().trim().equals("")) {
			return "Bạn không được để trống";
		}
		
		return nhomHangDao.update(nhomHang);
	}

	public String delete(String maNhom) {
		if(nhomHangDao.isMaCha(maNhom)) {
			return "Không thể vì đã phát sinh";
		}
		return nhomHangDao.delete(maNhom);
	}

	public boolean isMaNhom(String maNhom) {
		if(maNhom.trim().equals("")) {
			return false;
		}
		
		return nhomHangDao.isMaNhom(maNhom);
	}

	public boolean isMaCha(String maCha) {
		if(maCha.trim().equals("")) {
			return false;
		}
		
		return nhomHangDao.isMaCha(maCha);
	}

	public String deleteByMaCha(String maCha) {
		if(maCha.trim().equals("")) {
			return "Bạn không được để trống";
		}
		
		return nhomHangDao.deleteByMaCha(maCha);
	}

	public String moveNhom(String maNhom, String maCha) {
		if(maNhom.trim().equals("")) {
			return "Bạn không được để trống";
		}
		
		if(maCha != null ) {
			if(nhomHangDao.getByMaNhom(maCha).getMaCha().equals(maNhom)) {
				return "Không được";
			}
		}

		return nhomHangDao.moveNhom(maNhom, maCha);
	}


}

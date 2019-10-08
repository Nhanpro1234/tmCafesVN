package com.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.DongChungTuDao;
import com.tm.model.DongChungTu;

@Service
public class DongChungTuService implements DongChungTuDao {

	@Autowired
	DongChungTuDao dongChungTuDao;

	public List<DongChungTu> get() {
		return dongChungTuDao.get();
	}

	public DongChungTu getById(int id) {
		return dongChungTuDao.getById(id);
	}

	public List<DongChungTu> getBySoCT(int soCT) {
		return dongChungTuDao.getBySoCT(soCT);
	}

	public String add(DongChungTu dongChungTu) {
		return dongChungTuDao.add(dongChungTu);
	}

	public String update(DongChungTu dongChungTu) {
		return dongChungTuDao.update(dongChungTu);
	}

	public String deleteById(int id) {
		return dongChungTuDao.deleteById(id);
	}

	public String deleteBySoCT(int soCT) {
		return dongChungTuDao.deleteBySoCT(soCT);
	}

	public String updateByCT(int soCT_old, int soCT_new) {
		return dongChungTuDao.updateByCT(soCT_old, soCT_new);
	}

	public String update_by_sql(String colum_key, Object value_key, String colum_data, Object value_data) {
		return dongChungTuDao.update_by_sql(colum_key, value_key, colum_data, value_data);
	}

	public boolean isSP(int soCT, String maSP) {
		if(maSP.trim().equals("")) {
			return false;
		}
		
		return dongChungTuDao.isSP(soCT, maSP);
	}

	public float thanhTien(int soCT) {
		return dongChungTuDao.thanhTien(soCT);
	}

	public String updateSoLuong(int soCT, String maSP, int soLuong) {
		return dongChungTuDao.updateSoLuong(soCT, maSP, soLuong);
	}

	public boolean isGhiChu(int soCT) {
		return dongChungTuDao.isGhiChu(soCT);
	}
	
	
}

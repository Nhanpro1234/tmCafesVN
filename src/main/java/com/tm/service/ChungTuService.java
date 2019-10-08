package com.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.ChungTuDao;
import com.tm.model.ChungTu;

@Service
public class ChungTuService implements ChungTuDao {
	@Autowired
	ChungTuDao chungTuDao;
	@Autowired
	DongChungTuService dongChungTuService;

	public List<ChungTu> get() {
		return chungTuDao.get();
	}

	public ChungTu getBySoBan(String soBan, int tinhTrang) {
		if(soBan.trim().equals("")) {
			return null;
		}
		
		return chungTuDao.getBySoBan(soBan, tinhTrang);
	}

	public ChungTu getBySoCT(int soCT) {
		if(String.valueOf(soCT).trim().equals("")) {
			return null;
		}
		
		return chungTuDao.getBySoCT(soCT);
	}

	public List<ChungTu> getByTinhTrang(int tinhTrang) {
		if(String.valueOf(tinhTrang).trim().equals("")) {
			return null;
		}
		
		return chungTuDao.getByTinhTrang(tinhTrang);
	}

	public String add(ChungTu chungTu) {
		
		if(chungTu.getSoBan().trim().equals("") || chungTu.getMaKH().trim().equals("") || chungTu.getMaThuNgan().trim().equals("")
				|| chungTu.getNgayDat().trim().equals("")
				) {
			return "Lỗi không thể thêm";
		}
		
		return chungTuDao.add(chungTu);
	}

	public String update(ChungTu chungTu) {
		if(chungTuDao.getBySoCT(chungTu.getSoCT()).getTrangThai() == 1 || chungTuDao.getBySoCT(chungTu.getSoCT()).getTrangThai() == -1) {
			return "Chứng từ đã thanh toán hoặc đã hủy nên không thể chỉnh sửa được";
		}
		
		return chungTuDao.update(chungTu);
	}

	public String chuyenBan(int soCT, String soBan) {
		if(chungTuDao.getBySoCT(soCT).getTrangThai() == 1 || chungTuDao.getBySoCT(soCT).getTrangThai() == -1) {
			return "Chứng từ đã thanh toán hoặc đã hủy nên không thể chỉnh sửa được";
		}
		
		return chungTuDao.chuyenBan(soCT, soBan);
	}

	public String huyBan(int soCT) {
		if(dongChungTuService.getBySoCT(soCT).size() > 0) {
			return "Đã phát sinh nên không thể hủy";
		}
		
		return chungTuDao.huyBan(soCT);
	}

	public String thanhToan(int soCT) {
		if(dongChungTuService.isGhiChu(soCT)) {
			return "Vui lòng xử lý những món đang làm xong rồi thanh toán";
		}
		
		return chungTuDao.thanhToan(soCT);
	}

	public String update_by_sql(String colum_key, Object value_key, String colum_data, Object value_data) {
		return chungTuDao.update_by_sql(colum_key, value_key, colum_data, value_data);
	}

	public boolean checkBan(String soBan, int type) {
		if(soBan.trim().equals("")) {
			return false;
		}
		
		return chungTuDao.checkBan(soBan, type);
	}

	public float tongTien(int soCT) {
		return chungTuDao.tongTien(soCT);
	}
}

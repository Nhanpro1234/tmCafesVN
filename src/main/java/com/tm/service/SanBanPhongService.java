package com.tm.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.SanBanPhongDao;
import com.tm.model.SanBanPhong;

@Service
public class SanBanPhongService implements SanBanPhongDao {

	@Autowired
	SanBanPhongDao sanBanPhongDao;
	
	public List<SanBanPhong> get() {
		List<SanBanPhong> list = sanBanPhongDao.get();
		Collections.sort(list, new SanBanPhong());
		return list;
	}

	public List<SanBanPhong> getByKhuVuc(String khuVuc) {
		if(khuVuc.trim().equals("")) {
			return null;
		}
		
		return sanBanPhongDao.getByKhuVuc(khuVuc);
	}

	public List<SanBanPhong> getByBangGia(String bangGia) {
		if(bangGia.trim().equals("")) {
			return null;
		}
		
		return sanBanPhongDao.getByBangGia(bangGia);
	}

	public SanBanPhong getBySoBan(String soBan) {
		if(soBan.trim().equals("")) {
			return null;
		}
		
		return sanBanPhongDao.getBySoBan(soBan);
	}

	public String add(SanBanPhong sanBanPhong) {
		if(sanBanPhong.getMaKV().trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}

		if(sanBanPhong.getMaBG().trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		
		return sanBanPhongDao.add(sanBanPhong);
	}

	public String update(SanBanPhong sanBanPhong) {
		if(sanBanPhong.getMaKV().trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}

		if(sanBanPhong.getMaBG().trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		
		if(sanBanPhong.getSoBan().trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		
		return sanBanPhongDao.update(sanBanPhong);
	}

	public String delete(String soBan) {
		if(soBan.trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		
		return sanBanPhongDao.delete(soBan);
	}

}

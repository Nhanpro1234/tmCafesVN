package com.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.LoaiBangGiaDao;
import com.tm.model.LoaiBangGia;

@Service
public class LoaiBangGiaService implements LoaiBangGiaDao {

	@Autowired
	LoaiBangGiaDao loaiBangGiaDao;
	
	public List<LoaiBangGia> get() {
		return loaiBangGiaDao.get();
	}

	public LoaiBangGia getByMaKhuVuc(String maBG) {
		if(maBG.trim().equals("")) {
			return null;
		}
		
		return loaiBangGiaDao.getByMaKhuVuc(maBG);
	}

	public String add(LoaiBangGia loaiBangGia) {
		if(loaiBangGia.getTenBG().trim().equals("")) {
			return "Bạn không được để trống";
		}
		
		return loaiBangGiaDao.add(loaiBangGia);
	}

	public String update(LoaiBangGia loaiBangGia) {
		if(loaiBangGia.getTenBG().trim().equals("")) {
			return "Bạn không được để trống";
		}
		
		return loaiBangGiaDao.update(loaiBangGia);
	}

	public String del(String maBG) {

		if(maBG.trim().equals("")) {
			return "Bạn không được để trống";
		}
		
		return loaiBangGiaDao.del(maBG);
	}

}

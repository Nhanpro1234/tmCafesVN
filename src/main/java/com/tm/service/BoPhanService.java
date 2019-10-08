package com.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.BoPhanDao;
import com.tm.model.BoPhan;

@Service
public class BoPhanService implements BoPhanDao {

	@Autowired
	BoPhanDao boPhanDao;

	public List<BoPhan> get() {
		return boPhanDao.get();
	}

	public BoPhan getByMaBP(String maBP) {
		if(maBP.trim().equals("")) {
			return null;
		}
		
		return boPhanDao.getByMaBP(maBP);
	}

	public String add(BoPhan boPhan) {
		if(boPhan.getTenBP().trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		
		return boPhanDao.add(boPhan);
	}

	public String update(BoPhan boPhan) {
		if(boPhan.getTenBP().trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		
		if(!isMaBP(boPhan.getMaBP())) {
			return "Mã bộ phận không tồn tại";
		}
		
		return boPhanDao.update(boPhan);
	}

	public String delete(String maBP) {
		if(maBP.trim().equals("")) {
			return "Vui lòng không nhập đầy đủ";
		}
		
		if(!isMaBP(maBP)) {
			return "Không tồn tại !";
		}

		if(isMaCha(maBP)) {
			return "Mã này không đươc xóa, hãy xóa mã con trong nó trước";
		}
		
		return boPhanDao.delete(maBP);
	}

	public boolean isMaBP(String maBP) {
		if(maBP.trim().equals("")) {
			return false;
		}
		
		return boPhanDao.isMaBP(maBP);
	}

	public boolean isMaCha(String maCha) {
		if(maCha.trim().equals("")) {
			return false;
		}
		
		return boPhanDao.isMaCha(maCha);
	}

	public String deleteByMaCha(String maCha) {
		if(maCha.trim().equals("")) {
			return "Vui lòng nhập đầy đủ";
		}
		
		return boPhanDao.deleteByMaCha(maCha);
	}

	public String moveBoPhan(String maBP, String maCha) {
		if(!isMaBP(maBP)) {
			return "Không tồn tại !";
		}
		
		return boPhanDao.moveBoPhan(maBP, maCha);
	}
	
}

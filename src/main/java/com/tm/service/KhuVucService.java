package com.tm.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.KhuVucDao;
import com.tm.model.KhuVuc;

@Service
public class KhuVucService implements KhuVucDao {

	@Autowired
	KhuVucDao khuVucDao;
	
	public List<KhuVuc> get() {
		List<KhuVuc> list = khuVucDao.get();
		Collections.sort(list, new KhuVuc());
		return list;
	}

	public KhuVuc getByMaKhuVuc(String maKV) {
		if(maKV.trim().equals("")) {
			return null;
		}
		
		return khuVucDao.getByMaKhuVuc(maKV);
	}

	public String add(KhuVuc khuVuc) {
		if(khuVuc.getTenKV().trim().equals("")) {
			return "Bạn không đươc để trống";
		}
		
		return khuVucDao.add(khuVuc);
	}

	public String update(KhuVuc khuVuc) {
		if(khuVuc.getTenKV().trim().equals("")) {
			return "Bạn không đươc để trống";
		}
		
		return khuVucDao.update(khuVuc);
	}

	public String del(String maKV) {
		if(maKV.trim().equals("")) {
			return "Bạn không đươc để trống";
		}
		
		return khuVucDao.del(maKV);
	}

}

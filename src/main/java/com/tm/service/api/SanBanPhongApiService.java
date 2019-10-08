package com.tm.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.api.SanBanPhongApiDao;
import com.tm.model.api.SanBanPhongApi;

@Service
public class SanBanPhongApiService implements SanBanPhongApiDao {

	@Autowired
	SanBanPhongApiDao sanBanPhongApiDao;
	
	public List<SanBanPhongApi> get(String khuVuc) {
		return sanBanPhongApiDao.get(khuVuc);
	}

}

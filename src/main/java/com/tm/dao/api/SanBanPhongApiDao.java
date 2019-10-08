package com.tm.dao.api;

import java.util.List;

import com.tm.model.api.SanBanPhongApi;

public interface SanBanPhongApiDao {
	public List<SanBanPhongApi> get(String khuVuc);
}

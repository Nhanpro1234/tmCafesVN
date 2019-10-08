package com.tm.dao.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tm.lib.TimestampCustom;
import com.tm.model.ChungTu;
import com.tm.model.SanBanPhong;
import com.tm.model.api.SanBanPhongApi;
import com.tm.service.ChungTuService;
import com.tm.service.SanBanPhongService;

@Repository
public class SanBanPhongApiDaoImp implements SanBanPhongApiDao {

	@Autowired
	ChungTuService chungTuService;
	@Autowired
	SanBanPhongService sanBanPhongService;
	
	public List<SanBanPhongApi> get(String khuVuc) {
		if(khuVuc == null) {
			List<SanBanPhongApi> lists = new ArrayList<SanBanPhongApi>();
			for (SanBanPhong d : sanBanPhongService.get()) {
				SanBanPhongApi sanBanPhongApi = new SanBanPhongApi();
				sanBanPhongApi.setSoBan(d.getSoBan());
				sanBanPhongApi.setTongTien(0);
				ChungTu chungTu = chungTuService.getBySoBan(d.getSoBan(), 0);
				if(chungTu != null) {
					sanBanPhongApi.setTinhTrang(0);
					sanBanPhongApi.setThoiGianVao(TimestampCustom.convertTimeToDate(Long.valueOf(chungTu.getNgayCT())));
				}else{
					sanBanPhongApi.setTinhTrang(1);
					sanBanPhongApi.setThoiGianVao("___");
				}
				lists.add(sanBanPhongApi);
			}
			return lists;
		}else {
			List<SanBanPhongApi> lists = new ArrayList<SanBanPhongApi>();
			for (SanBanPhong d : sanBanPhongService.getByKhuVuc(khuVuc)) {
				SanBanPhongApi sanBanPhongApi = new SanBanPhongApi();
				sanBanPhongApi.setSoBan(d.getSoBan());
				sanBanPhongApi.setTongTien(0);
				ChungTu chungTu = chungTuService.getBySoBan(d.getSoBan(), 0);
				if(chungTu != null) {
					sanBanPhongApi.setTinhTrang(0);
					sanBanPhongApi.setThoiGianVao(TimestampCustom.convertTimeToDate(Long.valueOf(chungTu.getNgayCT())));
				}else{
					sanBanPhongApi.setTinhTrang(1);
					sanBanPhongApi.setThoiGianVao("___");
				}
				lists.add(sanBanPhongApi);
			}
			return lists;
		}
	}

}

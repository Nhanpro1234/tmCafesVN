package com.tm.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tm.model.SanBanPhong;
import com.tm.service.SanBanPhongService;
import com.tm.service.api.SanBanPhongApiService;

@Controller
@RequestMapping(value = "/api")
public class SanBanPhongApiController {
	
	@Autowired
	SanBanPhongApiService sanBanPhongApiService;
	@Autowired
	SanBanPhongService sanBanPhongService; 
	
	@RequestMapping(value = "/soDoBan", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String soDoBan(HttpServletRequest request, 
			@RequestParam(value = "khuVuc", required = false) String khuVuc) {
		if(khuVuc.trim().equals("")) {
			khuVuc = null;
		}
		
		return new Gson().toJson(sanBanPhongApiService.get(khuVuc));
	}
	
	@RequestMapping(value = "/sanBanPhong", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String get() {
		return new Gson().toJson(sanBanPhongService.get());
	}

	@RequestMapping(value = "/sanBanPhong/getByKhuVuc", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getByKhuVuc(
				@RequestParam(name = "maKV", required = true) String maKV
			) {
		return new Gson().toJson(sanBanPhongService.getByKhuVuc(maKV));
	}
	
	@RequestMapping(value = "/sanBanPhong/getByBangGia", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getByBangGia(
				@RequestParam(name = "maBG", required = true) String maBG
			) {
		return new Gson().toJson(sanBanPhongService.getByBangGia(maBG));
	}
	
	@RequestMapping(value = "/sanBanPhong/getBySoBan", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBySoBan(
				@RequestParam(name = "soBan", required = true) String soBan
			) {
		return new Gson().toJson(sanBanPhongService.getBySoBan(soBan));
	}
	
	@RequestMapping(value = "/sanBanPhong/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String add(
				@RequestParam(name = "maKV", required = true) String maKV,
				@RequestParam(name = "maBG", required = true) String maBG
			) {
		return sanBanPhongService.add(new SanBanPhong(null, maKV, null, maBG, null));
	}

	@RequestMapping(value = "/sanBanPhong/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update(
				@RequestParam(name = "soBan", required = true) String soBan,
				@RequestParam(name = "maKV", required = true) String maKV,
				@RequestParam(name = "maBG", required = true) String maBG
			) {
		return sanBanPhongService.update(new SanBanPhong(soBan, maKV, null, maBG, null));
	}
	
	@RequestMapping(value = "/sanBanPhong/delete", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String delete(
				@RequestParam(name = "soBan", required = true) String soBan
			) {
		return sanBanPhongService.delete(soBan);
	}
}

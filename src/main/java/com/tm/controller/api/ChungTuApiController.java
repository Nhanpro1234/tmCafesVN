package com.tm.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tm.model.ChungTu;
import com.tm.service.ChungTuService;

@Controller
@RequestMapping(value = "/api")
public class ChungTuApiController {

	@Autowired
	ChungTuService chungTuService;
	
	@RequestMapping(value = "/chungTu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String get(HttpServletRequest request) {
		return new Gson().toJson(chungTuService.get());
	}
	
	@RequestMapping(value = "/chungTu/getBySoCT", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBySoCT(@RequestParam(value = "soCT", required = true) int soCT) {
		return new Gson().toJson(chungTuService.getBySoCT(soCT));
	}
	
	@RequestMapping(value = "/chungTu/getBySoBan", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBySoBan(
			@RequestParam(value = "soBan", required = true) String soBan,
			@RequestParam(value = "tinhTrang", required = true) int tinhTrang
			) {
		return new Gson().toJson(chungTuService.getBySoBan(soBan, tinhTrang));
	}
	
	@RequestMapping(value = "/chungTu/getByTinhTrang", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getByTinhTrang(@RequestParam(value = "tinhTrang", required = true) int tinhTrang) {
		return new Gson().toJson(chungTuService.getByTinhTrang(tinhTrang));
	}
	
	@RequestMapping(value = "/chungTu/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String add(@ModelAttribute("chungTu") ChungTu chungTu) {
		return chungTuService.add(chungTu);
	}

	@RequestMapping(value = "/chungTu/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update(@ModelAttribute("chungTu") ChungTu chungTu) {
		return chungTuService.update(chungTu);
	}
	
	@RequestMapping(value = "/chungTu/chuyenBan", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String getBySoBan(
			@RequestParam(value = "soCT", required = true) int soCT,
			@RequestParam(value = "soBan", required = true) String soBan
			) {
		return chungTuService.chuyenBan(soCT, soBan);
	}
	
	@RequestMapping(value = "/chungTu/huyBan", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String getBySoBan(
			@RequestParam(value = "soCT", required = true) int soCT
			) {
		return chungTuService.huyBan(soCT);
	}
	
	@RequestMapping(value = "/chungTu/update_by_sql", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update_by_sql(
			@RequestParam(value = "colum_key", required = true) String colum_key,
			@RequestParam(value = "value_key", required = true) Object value_key,
			@RequestParam(value = "colum_data", required = true) String colum_data,
			@RequestParam(value = "value_data", required = true) Object value_data
			) {
		return chungTuService.update_by_sql(colum_key, value_key, colum_data, value_data);
	}
	
	@RequestMapping(value = "/chungTu/thanhToan", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String thanhToan(
			@RequestParam(value = "soCT", required = true) int soCT
			) {
		return chungTuService.thanhToan(soCT);
	}
	
	@RequestMapping(value = "/chungTu/tongTien", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String sum(@RequestParam(name = "soCT", required = true) int soCT) {
		return String.valueOf(chungTuService.tongTien(soCT));
	}
}

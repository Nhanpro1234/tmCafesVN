package com.tm.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tm.service.api.DoanhThuApiService;

@Controller
@RequestMapping(value = "/api")
public class DoanhThuApiController {

	@Autowired
	DoanhThuApiService doanhThuApiService;
	
	@RequestMapping(value = "/doanhThu/getThucDon", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getThucDon(@RequestParam(name = "time_start",required = true) String time_start, 
			@RequestParam(name = "time_ends",required = true) String time_ends,
			@RequestParam(name = "nhanVien",required = true) String nhanVien) {
		return new Gson().toJson(doanhThuApiService.getThucDon(time_start, time_ends, nhanVien));
	}
}

package com.tm.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tm.service.api.DanhSachMonDaGoiApiService;

@Controller
@RequestMapping(value = "/api")
public class DanhSachMonDaGoiApiController {

	@Autowired
	DanhSachMonDaGoiApiService danhSachMonDaGoiApiService;
	
	@RequestMapping(value = "/danhSachMonDaGoi", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String get(HttpServletRequest request) {
		return new Gson().toJson(danhSachMonDaGoiApiService.get());
	}
	
}

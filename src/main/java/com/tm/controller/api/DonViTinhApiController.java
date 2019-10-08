package com.tm.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tm.model.DonViTinh;
import com.tm.service.DonViTinhService;

@Controller
@RequestMapping(value = "/api")
public class DonViTinhApiController {

	@Autowired
	DonViTinhService donViTinhService;
	
	@RequestMapping(value = "/donViTinh", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String get(HttpServletRequest request) {
		return new Gson().toJson(donViTinhService.get());
	}
	
	@RequestMapping(value = "/donViTinh/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String add(@RequestParam(value = "maDVT", required = true) String maDVT, @RequestParam(value = "tenDVT", required = true) String tenDVT) {
		return donViTinhService.add(new  DonViTinh(maDVT, tenDVT, "0"));
	}
	
	@RequestMapping(value = "/donViTinh/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update(@RequestParam(value = "maDVT", required = true) String maDVT, @RequestParam(value = "tenDVT", required = true) String tenDVT) {
		return donViTinhService.update(new DonViTinh(maDVT, tenDVT, "0"));
	}
	
	@RequestMapping(value = "/donViTinh/del", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String del(@RequestParam(value = "maDVT", required = true) String maDVT) {
		return donViTinhService.del(maDVT);
	}
}

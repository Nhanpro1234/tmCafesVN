package com.tm.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tm.model.KhuVuc;
import com.tm.service.KhuVucService;

@Controller
@RequestMapping(value = "/api")
public class KhuVucApiController {
	
	@Autowired
	KhuVucService khuVucService;
	
	@RequestMapping(value = "/khuVuc", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String get(HttpServletRequest request){
		return new Gson().toJson(khuVucService.get());
	}
	
	@RequestMapping(value = "/khuVuc/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String add(HttpServletRequest request, @RequestParam(value = "tenKV", required = true) String tenKV){
		return khuVucService.add(new KhuVuc(null, tenKV));
	}
	
	@RequestMapping(value = "/khuVuc/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update(HttpServletRequest request,
			@RequestParam(value = "maKV", required = true) String maKV,
			@RequestParam(value = "tenKV", required = true) String tenKV){
		return khuVucService.update(new KhuVuc(maKV, tenKV));
	}
	
	@RequestMapping(value = "/khuVuc/del", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String del(HttpServletRequest request, @RequestParam(value = "maKV", required = true) String maKV){
		return khuVucService.del(maKV);
	}
}

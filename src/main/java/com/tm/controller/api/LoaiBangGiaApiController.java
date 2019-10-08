package com.tm.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tm.model.LoaiBangGia;
import com.tm.service.LoaiBangGiaService;

@Controller
@RequestMapping(value = "/api")
public class LoaiBangGiaApiController {
	
	@Autowired
	LoaiBangGiaService loaiBangGiaService;
	
	@RequestMapping(value = "/loaiBangGia", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String get(HttpServletRequest request) {
		return new Gson().toJson(loaiBangGiaService.get());
	}
	
	@RequestMapping(value = "/loaiBangGia/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String add(@RequestParam(value = "tenBG", required = true) String tenBG) {
		return loaiBangGiaService.add(new LoaiBangGia(null, tenBG, 0));
	}
	
	@RequestMapping(value = "/loaiBangGia/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update(@RequestParam(value = "maBG", required = true) String maBG,
			@RequestParam(value = "tenBG", required = true) String tenBG) {
		return loaiBangGiaService.update(new LoaiBangGia(maBG, tenBG, 0));
	}
	
	@RequestMapping(value = "/loaiBangGia/del", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String del(@RequestParam(value = "maBG", required = true) String maBG) {
		return loaiBangGiaService.del(maBG);
	}
}

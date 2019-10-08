package com.tm.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tm.model.NhomHang;
import com.tm.service.NhomHangService;

@Controller
@RequestMapping(value = "/api")
public class NhomHangApiController {

	@Autowired
	NhomHangService nhomHangService;
	
	@RequestMapping(value = "/nhomHang", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String get(HttpServletRequest request) {
		return new Gson().toJson(nhomHangService.get());
	}
	
	@RequestMapping(value = "/nhomHang/getByMaNhom", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody NhomHang getByMaNhom(@RequestParam(value = "maNhom", required = true) String maNhom) {
		return nhomHangService.getByMaNhom(maNhom);
	}

	@RequestMapping(value = "/nhomHang/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String add(
			@RequestParam(value = "maCha", required = true) String maCha,
			@RequestParam(value = "tenNhom", required = true) String tenNhom,
			@RequestParam(value = "loaiNhom", required = true) int loaiNhom
			) {
		return nhomHangService.add(new NhomHang(null, maCha.equals("0") ? null : maCha, tenNhom, loaiNhom));
	}

	@RequestMapping(value = "/nhomHang/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update(
			@RequestParam(value = "maNhom", required = true) String maNhom,
			@RequestParam(value = "maCha", required = true) String maCha,
			@RequestParam(value = "tenNhom", required = true) String tenNhom,
			@RequestParam(value = "loaiNhom", required = true) String loaiNhom
			) {
		if(!loaiNhom.matches("[0-9]*")) {
			return "Bạn chưa loại sản phẩm";
		}
		
		return nhomHangService.update(new NhomHang(maNhom, maCha.equals("null") ? null : maCha, tenNhom, Integer.valueOf(loaiNhom)));
	}

	@RequestMapping(value = "/nhomHang/del", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String del(@RequestParam(value = "maNhom", required = true) String maNhom) {
		return nhomHangService.delete(maNhom);
	}
	
	@RequestMapping(value = "/nhomHang/isMaNhom", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String isMaNhom(@RequestParam(value = "maNhom", required = true) String maNhom) {
		return nhomHangService.isMaNhom(maNhom) ? "true" : "false";
	}
	//
	@RequestMapping(value = "/nhomHang/isMaCha", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String isMaCha(@RequestParam(value = "maCha", required = true) String maCha) {
		return nhomHangService.isMaCha(maCha) ? "true" : "false";
	}
	
	@RequestMapping(value = "/nhomHang/moveNhom", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String moveNhom(
			@RequestParam(value = "maNhom", required = true) String maNhom,
			@RequestParam(value = "maCha", required = true) String maCha
			) {
		return nhomHangService.moveNhom(maNhom, maCha.equals("0") ? null : maCha);
	}
}

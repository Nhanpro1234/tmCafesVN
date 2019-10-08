package com.tm.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.model.TaiKhoan;
import com.tm.service.TaiKhoanService;


@Controller
@RequestMapping(value = "/api")
public class TaiKhoanApiController {
	
	@Autowired
	TaiKhoanService taiKhoanService;
	
	@RequestMapping(value = "/taiKhoan", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<TaiKhoan> get() {
		return taiKhoanService.get();
	}
	
	@RequestMapping(value = "/taiKhoan/getAll", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<TaiKhoan> getAll() {
		return taiKhoanService.getAll();
	}
	
	@RequestMapping(value = "/taiKhoan/getByTaiKhoan", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody TaiKhoan getByTaiKhoan(@RequestParam(name = "taiKhoan") String taiKhoan) {
		return taiKhoanService.getByTaiKhoan(taiKhoan);
	}
	
	@RequestMapping(value = "/taiKhoan/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String add(
			@RequestParam(name = "taiKhoan") String taiKhoan,
			@RequestParam(name = "matKhau") String matKhau,
			@RequestParam(name = "maNV") String maNV,
			@RequestParam(name = "role") String role
			) {
		return taiKhoanService.add(new TaiKhoan(taiKhoan, matKhau, maNV, role));
	}
	
	@RequestMapping(value = "/taiKhoan/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update(
			@RequestParam(name = "taiKhoan") String taiKhoan,
			@RequestParam(name = "matKhau") String matKhau,
			@RequestParam(name = "maNV") String maNV,
			@RequestParam(name = "role") String role
			) {
		return taiKhoanService.update(new TaiKhoan(taiKhoan, matKhau, maNV, role));
	}
	
	@RequestMapping(value = "/taiKhoan/delete", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String delete(@RequestParam(name = "taiKhoan") String taiKhoan) {
		return taiKhoanService.delete(taiKhoan);
	}
}

package com.tm.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tm.model.NhanVien;
import com.tm.service.NhanVienService;

@Controller
@RequestMapping(value = "/api")
public class NhanVienApiController {

	@Autowired
	NhanVienService nhanVienService;

	@RequestMapping(value = "/nhanVien", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String get() {
		return new Gson().toJson(nhanVienService.get());
	}

	@RequestMapping(value = "/nhanVien/getByMaBP", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getByMaBP(@RequestParam(value = "maBP", required = true) String maBP) {
		if(maBP.equals("0")) {
			return new Gson().toJson(nhanVienService.get());
		}
		return new Gson().toJson(nhanVienService.getByMaBP(maBP));
	}

	@RequestMapping(value = "/nhanVien/{maNV}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getByMaNV(@PathVariable(value = "maNV", required = true) String maNV) {
		return new Gson().toJson(nhanVienService.getByMaNV(maNV));
	}

	@RequestMapping(value = "/nhanVien/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String add(
			@RequestParam(value = "maBP", required = true) String maBP,
			@RequestParam(value = "hoTen", required = true) String hoTen,
			@RequestParam(value = "diaChi", required = true) String diaChi,
			@RequestParam(value = "dienThoai", required = true) String dienThoai,
			@RequestParam(value = "maSoThue", required = true) String maSoThue,
			@RequestParam(value = "isKeToan", required = true) int isKeToan,
			@RequestParam(value = "isThuNgan", required = true) int isThuNgan
			) {
		return nhanVienService.add(new NhanVien(null, maBP, hoTen, diaChi, dienThoai, maSoThue, isKeToan, isThuNgan));
	}

	@RequestMapping(value = "/nhanVien/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update(
			@RequestParam(value = "maNV", required = true) String maNV,
			@RequestParam(value = "maBP", required = true) String maBP,
			@RequestParam(value = "hoTen", required = true) String hoTen,
			@RequestParam(value = "diaChi", required = true) String diaChi,
			@RequestParam(value = "dienThoai", required = true) String dienThoai,
			@RequestParam(value = "maSoThue", required = true) String maSoThue,
			@RequestParam(value = "isKeToan", required = true) int isKeToan,
			@RequestParam(value = "isThuNgan", required = true) int isThuNgan
			) {
		return nhanVienService.update(new NhanVien(maNV, maBP, hoTen, diaChi, dienThoai, maSoThue, isKeToan, isThuNgan));
	}
	
	@RequestMapping(value = "/nhanVien/delete", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String delete(@RequestParam(value = "maNV", required = true) String maNV) {
		return nhanVienService.del(maNV);
	}
}

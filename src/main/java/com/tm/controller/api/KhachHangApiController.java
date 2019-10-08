package com.tm.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.model.KhachHang;
import com.tm.service.KhachHangService;

@Controller
@RequestMapping(value = "/api")
public class KhachHangApiController {

	@Autowired
	KhachHangService khachHangService;

	@RequestMapping(value = "/khachHang", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<KhachHang> get() {
		return khachHangService.get();
	}

	@RequestMapping(value = "/khachHang/getByMaNhom", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<KhachHang> getByMaNhom(@RequestParam(name = "maNhom", required = true) String maNhom) {
		if(maNhom.equals("0")) {
			return khachHangService.get();
		}
		return khachHangService.getByMaNhom(maNhom);
	}

	@RequestMapping(value = "/khachHang/getByMaKhachHang", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody KhachHang getByMaKhachHang(@RequestParam(name = "maKH", required = true) String maKH) {
		return khachHangService.getByMaKhachHang(maKH);
	}

	@RequestMapping(value = "/khachHang/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String add(@ModelAttribute(name = "khachHang") KhachHang khachHang) {
		return khachHangService.add(khachHang);
	}

	@RequestMapping(value = "/khachHang/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update(@ModelAttribute(name = "khachHang") KhachHang khachHang) {
		return khachHangService.update(khachHang);
	}

	@RequestMapping(value = "/khachHang/delete", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String delete(@RequestParam(name = "maKH", required = true) String maKH) {
		return khachHangService.delete(maKH);
	}
}

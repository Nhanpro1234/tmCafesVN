package com.tm.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.model.NhomKhachHang;
import com.tm.service.NhomKhachHangService;

@Controller
@RequestMapping("/api")
public class NhomKhachHangApiController {
	@Autowired
	NhomKhachHangService nhomKhachHangService;

	@RequestMapping(value = "/nhomKhachHang", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<NhomKhachHang> get() {
		return nhomKhachHangService.get();
	}

	@RequestMapping(value = "/nhomKhachHang/getByMaNhom", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody NhomKhachHang getByMaNhom(@RequestParam(name = "maNhom", required = true) String maNhom) {
		return nhomKhachHangService.getByMaNhom(maNhom);
	}

	@RequestMapping(value = "/nhomKhachHang/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String add(@ModelAttribute(name = "nhomKhachHang") NhomKhachHang nhomKhachHang) {
		return nhomKhachHangService.add(nhomKhachHang);
	}

	@RequestMapping(value = "/nhomKhachHang/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update(@ModelAttribute(name = "nhomKhachHang") NhomKhachHang nhomKhachHang) {
		return nhomKhachHangService.update(nhomKhachHang);
	}

	@RequestMapping(value = "/nhomKhachHang/delete", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String delete(@RequestParam(name = "maNhom", required = true) String maNhom) {
		return nhomKhachHangService.delete(maNhom);
	}

	@RequestMapping(value = "/nhomKhachHang/deleteByMaCha", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String deleteByMaCha(@RequestParam(name = "maCha", required = true) String maCha) {
		return nhomKhachHangService.deleteByMaCha(maCha);
	}
}

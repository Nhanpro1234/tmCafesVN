package com.tm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/quan-li")
public class DanhMucController {

	@RequestMapping(value = "/danh-muc", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpSession session) {
		return "danh-muc";
	}
	
	@RequestMapping(value = "/danh-muc-khu-vuc", method = RequestMethod.POST)
	public String danhMucKhuVuc(HttpServletRequest request, HttpSession session) {
		return "api/danh-muc-khu-vuc";
	}
	
	@RequestMapping(value = "/danh-muc-don-vi-tinh", method = RequestMethod.POST)
	public String danhMucDonViTinh(HttpServletRequest request, HttpSession session) {
		return "api/danh-muc-don-vi-tinh";
	}
	
	@RequestMapping(value = "/danh-muc-loai-bang-gia", method = RequestMethod.POST)
	public String danhMucBanGia(HttpServletRequest request, HttpSession session) {
		return "api/danh-muc-loai-bang-gia";
	}
}

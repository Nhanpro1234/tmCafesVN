package com.tm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/quan-li")
public class TaiKhoanController {

	@RequestMapping(value = "/tai-khoan")
	public String taiKhoan(HttpServletRequest request) {
		
		return "tai-khoan";
	}
}

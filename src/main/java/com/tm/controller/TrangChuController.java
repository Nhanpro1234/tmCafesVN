package com.tm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TrangChuController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "redirect:/dang-nhap";
	}
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public String index2() {
		return "trang-chu";
	}
}

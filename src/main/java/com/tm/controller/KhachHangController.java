package com.tm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/quan-li")
public class KhachHangController {

	@RequestMapping(value = "/khach-hang", method = RequestMethod.GET)
	public String index(HttpSession session) {
		return "khach-hang";
	}
}

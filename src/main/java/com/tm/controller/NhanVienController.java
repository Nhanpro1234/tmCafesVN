package com.tm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/quan-li")
public class NhanVienController {
	@RequestMapping(value = "/nhan-vien", method = RequestMethod.GET)
	public String index(HttpSession session) {
		return "nhan-vien";
	}
}

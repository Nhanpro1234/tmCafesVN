package com.tm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/quan-li")
public class SanBanPhongController {


	@RequestMapping(value = "/san-ban-phong", method = RequestMethod.GET)
	public String index_2(HttpSession session) {
		return "san-ban-phong";
	}
}

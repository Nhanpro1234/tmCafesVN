package com.tm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/quan-li")
public class DoanhThuController {
	
	@RequestMapping(value = "/doanh-thu", method = RequestMethod.GET)
	public String index() {
		
		return "doanh-thu";
	}
}

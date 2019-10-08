package com.tm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.service.api.SanBanPhongApiService;

@Controller
@RequestMapping(value = "/thu-ngan")
public class SoDoBanController {
	
	@Autowired
	SanBanPhongApiService sanBanPhongApiService;
	
	@RequestMapping(value = "/so-do-ban", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpSession session) {
		return "so-do-ban";
	}
}
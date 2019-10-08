package com.tm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DangNhapController {
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpSession session, @RequestParam(name="error", required = false) String error) {
		if(error != null) {
			request.setAttribute("message", "Tài khoản hoặc mật khấu sai !");
		}
		
		String currentUserName = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    currentUserName = authentication.getName();
		}
		
		if(currentUserName != null) {
			return "redirect:/trang-chu";
		}
		
		
		return "dang-nhap";
	}
	
}
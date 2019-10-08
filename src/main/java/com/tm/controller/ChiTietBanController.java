package com.tm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.model.ChungTu;
import com.tm.service.ChungTuService;

@Controller
@RequestMapping(value = "/thu-ngan")
public class ChiTietBanController {
	
	@Autowired
	ChungTuService chungTuService;
	
	
	@RequestMapping(value = "/chi-tiet-ban/{soCT}", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpSession session, @PathVariable(value = "soCT", required = true) int soCT) {
		ChungTu chungTu = chungTuService.getBySoCT(soCT);
		
		if(chungTu == null) {
			return "redirect:/thu-ngan/so-do-ban";
		}
		
		request.setAttribute("soCT", soCT);
		
		return "chi-tiet-ban";
	}
	
}

















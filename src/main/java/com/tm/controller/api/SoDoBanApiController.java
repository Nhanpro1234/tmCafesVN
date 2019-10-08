package com.tm.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tm.lib.TimestampCustom;
import com.tm.model.ChungTu;
import com.tm.service.ChungTuService;
import com.tm.service.TaiKhoanService;

@Controller
@RequestMapping(value = "/api")
public class SoDoBanApiController {
	
	@Autowired
	ChungTuService chungTuService;
	@Autowired
	TaiKhoanService taiKhoanService;

	@RequestMapping(value = "/thu-ngan/soDoban", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String index(@RequestParam(value = "soBan", required = true) String soBan){
		String currentUserName = "";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    currentUserName = authentication.getName();
		}
		
		if(!chungTuService.checkBan(soBan, 0)) {
			chungTuService.add(new ChungTu(java.sql.Types.INTEGER, TimestampCustom.getTimestamp(), 
											2, soBan, "KH_1", 
											0, "", taiKhoanService.getByTaiKhoan(currentUserName).getMaNV(), 
											null, 0, 0, 
											0, 0, 0, 
											0, TimestampCustom.getTimestamp(), 0));
		}
		
		return new Gson().toJson(chungTuService.getBySoBan(soBan, 0));
	}
}

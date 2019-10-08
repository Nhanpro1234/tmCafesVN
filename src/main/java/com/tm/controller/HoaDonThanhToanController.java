package com.tm.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.lib.TimestampCustom;
import com.tm.model.ChungTu;
import com.tm.service.ChungTuService;
import com.tm.service.DongChungTuService;
import com.tm.service.NhanVienService;

@Controller
@RequestMapping(value = "/thu-ngan")
public class HoaDonThanhToanController {
	
	@Autowired
	ChungTuService chungTuService;
	@Autowired
	DongChungTuService dongChungTuService;
	@Autowired
	NhanVienService nhanVienService;
	
	@RequestMapping(value = "/hoa-don-thanh-toan/{soCT}", method = RequestMethod.GET)
	public String index(HttpServletRequest request ,
			@PathVariable(name = "soCT", required = true) int soCT) {
		ChungTu chungTu = chungTuService.getBySoCT(soCT);
		request.setAttribute("chungTu", chungTu);
		request.setAttribute("dongChungTu", dongChungTuService.getBySoCT(soCT));
		request.setAttribute("tongTien", new BigDecimal(chungTuService.tongTien(soCT)).toString());
		request.setAttribute("thanhTien", new BigDecimal(dongChungTuService.thanhTien(soCT)).toString());
		request.setAttribute("nhanVienThuNgan", nhanVienService.getByMaNV(chungTu.getMaThuNgan()));
		request.setAttribute("giovao", TimestampCustom.convertTimeToDate(Long.valueOf(chungTu.getNgayCT())));
		
		return "pages/hoa-don-thanh-toan";
	}
}

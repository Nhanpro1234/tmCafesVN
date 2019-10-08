package com.tm.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tm.model.SanPham;
import com.tm.service.SanPhamService;
import com.tm.service.api.SanPhamApiService;

@Controller
@RequestMapping(value = "/api")
public class SanPhamApiController {

	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	SanPhamApiService sanPhamApiService;
	
	@RequestMapping(value = "/sanPham", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String get(HttpServletRequest request){
		return new Gson().toJson(sanPhamService.get());
	}
	
	@RequestMapping(value = "/sanPham/maSP", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getByMaSP(@RequestParam(value = "maSP", required = true) String maSP){
		return new Gson().toJson(sanPhamService.getByMaSP(maSP));
	}
	
	@RequestMapping(value = "/sanPham/maNhom", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getByMaNhom(@RequestParam(value = "maNhom", required = true) String maNhom){
		if(maNhom.equals("0")) {
			return new Gson().toJson(sanPhamService.get());
		}
		return new Gson().toJson(sanPhamService.getByMaNhom(maNhom));
	}
	
	@RequestMapping(value = "/sanPham/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String add(
			@RequestParam(value = "maNhom", required = true) String maNhom,
			@RequestParam(value = "tenSP", required = true) String tenSP,
			@RequestParam(value = "maDVT", required = true) String maDVT,
			@RequestParam(value = "SLDK", required = true) String SLDK,
			@RequestParam(value = "GTDK", required = true) String GTDK,
			@RequestParam(value = "giaVon", required = true) String giaVon,
			@RequestParam(value = "giaBan", required = true) String giaBan,
			@RequestParam(value = "giam", required = true) String giam,
			@RequestParam(value = "khongNhap", required = true) String khongNhap,
			@RequestParam(value = "khongXuat", required = true) String khongXuat,
			@RequestParam(value = "isMenu", required = true) String isMenu
			){
		if(	tenSP.trim().equals("")
				|| maNhom.trim().equals("")
				|| SLDK.trim().equals("")
				|| GTDK.trim().equals("") 
				|| giaVon.trim().equals("") 
				|| giaBan.trim().equals("") 
				|| giam.trim().equals("") 
				|| khongNhap.trim().equals("") 
				|| khongXuat.trim().equals("") 
				|| isMenu.trim().equals("")  ) {
			return "Vui lòng nhập đầy đủ";
		}
		
		if(SLDK.matches("[0-9]+") == false
				|| GTDK.matches("[0-9]+") == false
				|| giaVon.matches("[0-9]+") == false
				|| giaBan.matches("[0-9]+") == false
				|| giam.matches("[0-9]+") == false) {
			return "Đơn giá hay giá giảm phải là kiểu số";
		}
		
		return sanPhamService.add(new SanPham(null, maNhom, 
				tenSP, maDVT, null ,
				Float.valueOf(SLDK), Float.valueOf(GTDK), 
				Float.valueOf(giaVon), Float.valueOf(giaBan), 
				Float.valueOf(giam), Integer.valueOf(khongNhap), 
				Integer.valueOf(khongXuat), Integer.valueOf(isMenu)));
	}
	
	@RequestMapping(value = "/sanPham/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update(
			@RequestParam(value = "maSP", required = true) String maSP,
			@RequestParam(value = "maNhom", required = true) String maNhom,
			@RequestParam(value = "tenSP", required = true) String tenSP,
			@RequestParam(value = "maDVT", required = true) String maDVT,
			@RequestParam(value = "SLDK", required = true) String SLDK,
			@RequestParam(value = "GTDK", required = true) String GTDK,
			@RequestParam(value = "giaVon", required = true) String giaVon,
			@RequestParam(value = "giaBan", required = true) String giaBan,
			@RequestParam(value = "giam", required = true) String giam,
			@RequestParam(value = "khongNhap", required = true) String khongNhap,
			@RequestParam(value = "khongXuat", required = true) String khongXuat,
			@RequestParam(value = "isMenu", required = true) String isMenu
			){
		if(	tenSP.trim().equals("")
				|| maSP.trim().equals("")
				|| maNhom.trim().equals("")
				|| SLDK.trim().equals("")
				|| GTDK.trim().equals("") 
				|| giaVon.trim().equals("") 
				|| giaBan.trim().equals("") 
				|| giam.trim().equals("") 
				|| khongNhap.trim().equals("") 
				|| khongXuat.trim().equals("") 
				|| isMenu.trim().equals("")  ) {
			return "Vui lòng nhập đầy đủ";
		}
		
		if(SLDK.matches("[0-9]+") == false
				|| GTDK.matches("[0-9]+") == false
				|| giaVon.matches("[0-9]+") == false
				|| giaBan.matches("[0-9]+") == false
				|| giam.matches("[0-9]+") == false) {
			return "Đơn giá hay giá giảm phải là kiểu số";
		}
		
		return sanPhamService.update(new SanPham(maSP, maNhom, 
				tenSP, maDVT, null ,
				Float.valueOf(SLDK), Float.valueOf(GTDK), 
				Float.valueOf(giaVon), Float.valueOf(giaBan), 
				Float.valueOf(giam), Integer.valueOf(khongNhap), 
				Integer.valueOf(khongXuat), Integer.valueOf(isMenu)));
	}
	
	
	@RequestMapping(value = "/sanPham/del", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String del(@RequestParam(value = "maSP", required = true) String maSP){
		return sanPhamService.del(maSP);
	}
	
	@RequestMapping(value = "/khac/sanPham", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String __get(@RequestParam(value = "maNhom", required = false) String maNhom) {
		if(maNhom == "" || maNhom == null || maNhom.equals("0")) {
			return new Gson().toJson(sanPhamApiService.get());
		}
		return new Gson().toJson(sanPhamApiService.getByMaNhom(maNhom));
	}
}

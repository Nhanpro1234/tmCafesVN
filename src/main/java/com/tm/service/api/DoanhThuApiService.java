package com.tm.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.tm.dao.api.DoanhThuApiDao;
import com.tm.model.api.DoanhThuThucDon;
import com.tm.service.TaiKhoanService;

@Service
public class DoanhThuApiService implements DoanhThuApiDao {

	@Autowired
	DoanhThuApiDao doanhThuApiDao;
	@Autowired
	TaiKhoanService taiKhoanService;
	
	public List<DoanhThuThucDon> getThucDon(String time_start, String time_ends, String nhanVien) {
		String currentUserName = "";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    currentUserName = authentication.getName();
		}
		
		if(currentUserName.equals("")) {
			return null;
		}
		
		if(currentUserName.toLowerCase().equals("admin")) {
			if(nhanVien.equals("ALL")) {
				nhanVien = null;
			}
			
			return doanhThuApiDao.getThucDon(time_start, time_ends, nhanVien);
		}else {
			if(taiKhoanService.getByTaiKhoan(currentUserName).getMaNV().equals(nhanVien)) {
				return doanhThuApiDao.getThucDon(time_start, time_ends, nhanVien);
			}
		}
		
		return null;
	}
	
	
}

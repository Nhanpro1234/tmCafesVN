package com.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.NhanVienDao;
import com.tm.model.NhanVien;

@Service
public class NhanVienService implements NhanVienDao {

	@Autowired
	NhanVienDao nhanVienDao;
	
	public List<NhanVien> get() {
		return nhanVienDao.get();
	}

	public List<NhanVien> getByMaBP(String maBP) {
		if(maBP.trim().equals("")) {
			return null;
		}
		
		return nhanVienDao.getByMaBP(maBP);
	}

	public NhanVien getByMaNV(String maNV) {
		return nhanVienDao.getByMaNV(maNV);
	}

	public String add(NhanVien nhanVien) {
		if(nhanVien.getHoTen().trim().equals("") 
				|| nhanVien.getMaBP().trim().equals("")) {
			
			return "Bạn không được để trống";
		}
		
		return nhanVienDao.add(nhanVien);
	}

	public String update(NhanVien nhanVien) {
		if(nhanVien.getHoTen().trim().equals("") 
				|| nhanVien.getMaBP().trim().equals("")
				|| nhanVien.getMaNV().trim().equals("")) {
			
			return "Bạn không được để trống";
		}
		
		return nhanVienDao.update(nhanVien);
	}

	public String del(String maNV) {
		if(maNV.trim().equals("")) {
			return "Vui long nhap day du";
		}
		
		return nhanVienDao.del(maNV);
	}
}

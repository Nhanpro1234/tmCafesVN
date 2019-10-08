package com.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.dao.SanPhamDao;
import com.tm.model.SanPham;

@Service
public class SanPhamService implements SanPhamDao {

	@Autowired
	SanPhamDao sanPhamDao;

	public List<SanPham> get() {
		return sanPhamDao.get();
	}

	public List<SanPham> getByMaNhom(String maNhom) {
		if(maNhom.trim().equals("")) {
			return null;
		}
		
		return sanPhamDao.getByMaNhom(maNhom);
	}

	public SanPham getByMaSP(String maSP) {
		if(maSP.trim().equals("")) {
			return null;
		}
		
		return sanPhamDao.getByMaSP(maSP);
	}

	public String add(SanPham sanPham) {
		if(sanPham.getIsMenu() == 0 || sanPham.getIsMenu() == 1) {
			if(sanPham.getKhongNhap() == 0 || sanPham.getKhongNhap() == 1) {
				if(sanPham.getKhongXuat() == 0 || sanPham.getKhongXuat() == 1) {
					return sanPhamDao.add(sanPham);
				}else {
					return "Sai mục >không xuất<";
				}
			}else {
				return "Sai mục >không nhập<";
			}
		}else {
			return "Sai mục >IsMenu<";
		}
	}

	public String update(SanPham sanPham) {
		if(sanPham.getIsMenu() == 0 || sanPham.getIsMenu() == 1) {
			if(sanPham.getKhongNhap() == 0 || sanPham.getKhongNhap() == 1) {
				if(sanPham.getKhongXuat() == 0 || sanPham.getKhongXuat() == 1) {
					return sanPhamDao.update(sanPham);
				}else {
					return "Sai mục >không xuất<";
				}
			}else {
				return "Sai mục >không nhập<";
			}
		}else {
			return "Sai mục >IsMenu<";
		}
	}

	public String del(String maSP) {
		if(maSP.trim().equals("")) {
			return "Bạn không được để trống";
		}
		
		return sanPhamDao.del(maSP);
	}
}

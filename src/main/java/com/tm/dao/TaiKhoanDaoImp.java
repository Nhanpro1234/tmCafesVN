package com.tm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tm.model.TaiKhoan;

@Repository
@Transactional
public class TaiKhoanDaoImp implements TaiKhoanDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean login(String taiKhoan, String matKhau) {
		String sql = "SELECT * FROM `tai_khoan` where taiKhoan = ? and matKhau = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, taiKhoan, matKhau);
		if(row.next()) {
			return true;
		}
		return false;
	}

	public List<TaiKhoan> get() {
		String sql = "SELECT nhan_vien.maNV, tai_khoan.taiKhoan, tai_khoan.matKhau, tai_khoan.role, nhan_vien.maBP, nhan_vien.hoTen, nhan_vien.diaChi, nhan_vien.dienThoai, nhan_vien.maSoThue, nhan_vien.maSoThue, nhan_vien.isKeToan, nhan_vien.isThuNgan FROM tai_khoan INNER JOIN nhan_vien ON tai_khoan.maNV = nhan_vien.maNV ";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<TaiKhoan>() {
			public TaiKhoan mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new TaiKhoan(rs.getString("taiKhoan"), rs.getString("matKhau"), rs.getString("maNV"), rs.getString("role"));
			}
		});
	}

	public TaiKhoan getByTaiKhoan(String taiKhoan) {
		String sql = "SELECT nhan_vien.maNV, tai_khoan.taiKhoan, tai_khoan.role, tai_khoan.matKhau, nhan_vien.maBP, nhan_vien.hoTen, nhan_vien.diaChi, nhan_vien.dienThoai, nhan_vien.maSoThue, nhan_vien.maSoThue, nhan_vien.isKeToan, nhan_vien.isThuNgan FROM tai_khoan INNER JOIN nhan_vien ON tai_khoan.maNV = nhan_vien.maNV  where tai_khoan.taiKhoan = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {taiKhoan}, new RowMapper<TaiKhoan>() {
			public TaiKhoan mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new TaiKhoan(
						rs.getString("taiKhoan"), rs.getString("matKhau"), 
						rs.getString("maNV"), rs.getString("maBP"), 
						rs.getString("hoTen"), rs.getString("diaChi"), 
						rs.getString("dienThoai"), rs.getString("maSoThue"), 
						rs.getInt("isKeToan"), rs.getInt("isThuNgan"), rs.getString("role")
				);
				
			}
		});
	}
	
	public boolean isTaiKhoan(String taiKhoan) {
		String sql = "SELECT * FROM `tai_khoan` WHERE taiKhoan = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, taiKhoan);
		return row.next();
	}
	
	public boolean isMaNV(String maNV) {
		String sql = "SELECT * FROM `tai_khoan` WHERE maNV = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, maNV);
		return row.next();
	}

	public String add(TaiKhoan taiKhoan) {
		try {
			String sql = "INSERT INTO `tai_khoan`(`taiKhoan`, `matKhau`, `maNV`, `role`) VALUES (?, ?, ?, ?)";
			int i = jdbcTemplate.update(sql, taiKhoan.getTaiKhoan(), taiKhoan.getMatKhau(), taiKhoan.getMaNV(), taiKhoan.getRole());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String update(TaiKhoan taiKhoan) {
		if(this.getByTaiKhoan(taiKhoan.getTaiKhoan()) == null) {
			return "Không tồn tại !";
		}
		
		try {
			String sql = "UPDATE `tai_khoan` SET `matKhau`= ?,`maNV`= ?,`role`= ? WHERE `taiKhoan`= ?";
			int i = jdbcTemplate.update(sql, taiKhoan.getMatKhau(), taiKhoan.getMaNV(), taiKhoan.getRole(), taiKhoan.getTaiKhoan());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String delete(String taiKhoan) {
		try {
			String sql = "DELETE FROM `tai_khoan` WHERE taiKhoan = ?";
			int i = jdbcTemplate.update(sql, taiKhoan);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public List<TaiKhoan> getAll() {
		String sql = "SELECT nhan_vien.maNV, tai_khoan.taiKhoan, tai_khoan.role, tai_khoan.matKhau, nhan_vien.maBP, nhan_vien.hoTen, nhan_vien.diaChi, nhan_vien.dienThoai, nhan_vien.maSoThue, nhan_vien.maSoThue, nhan_vien.isKeToan, nhan_vien.isThuNgan FROM tai_khoan INNER JOIN nhan_vien ON tai_khoan.maNV = nhan_vien.maNV ";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<TaiKhoan>() {
			public TaiKhoan mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new TaiKhoan(
						rs.getString("taiKhoan"), rs.getString("matKhau"), 
						rs.getString("maNV"), rs.getString("maBP"), 
						rs.getString("hoTen"), rs.getString("diaChi"), 
						rs.getString("dienThoai"), rs.getString("maSoThue"), 
						rs.getInt("isKeToan"), rs.getInt("isThuNgan"), rs.getString("role")
				);
				
			}
		});
	}
}

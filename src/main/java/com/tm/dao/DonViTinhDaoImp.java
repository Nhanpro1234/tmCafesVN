package com.tm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tm.model.DonViTinh;

@Repository
@Transactional
public class DonViTinhDaoImp implements DonViTinhDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<DonViTinh> get() {
		String sql = "SELECT * FROM `don_vi_tinh`";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<DonViTinh>() {
			public DonViTinh mapRow(ResultSet rs, int rowNum) throws SQLException {
				DonViTinh donViTinh = new DonViTinh(rs.getString("maDVT"), rs.getString("tenDVT"), rs.getString("macDinh"));
				return donViTinh;
			}
		});
	}

	public DonViTinh getByMaDonViTinh(String maDVT) {
		String sql = "SELECT * FROM `don_vi_tinh`";
		return jdbcTemplate.queryForObject(sql, new Object[] {}, new RowMapper<DonViTinh>() {
			public DonViTinh mapRow(ResultSet rs, int rowNum) throws SQLException {
				DonViTinh donViTinh = new DonViTinh(rs.getString("maDVT"), rs.getString("tenDVT"), rs.getString("macDinh"));
				return donViTinh;
			}
		});
	}

	public String add(DonViTinh donViTinh) {
		try {
			String sql = "INSERT INTO `don_vi_tinh`(`maDVT`, `tenDVT`, `macDinh`) VALUES (?, ?, ?)";
			int i = jdbcTemplate.update(sql, donViTinh.getMaDVT(), donViTinh.getTenDVT(), donViTinh.getMacDinh());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String update(DonViTinh donViTinh) {
		try {
			String sql = "UPDATE `don_vi_tinh` SET `tenDVT`= ? WHERE `maDVT`= ?";
			int i = jdbcTemplate.update(sql, donViTinh.getTenDVT(), donViTinh.getMaDVT());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String del(String maDVT) {
		try {
			String sql = "DELETE FROM `don_vi_tinh` Where maDVT = ?";
			int i = jdbcTemplate.update(sql, maDVT);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

}

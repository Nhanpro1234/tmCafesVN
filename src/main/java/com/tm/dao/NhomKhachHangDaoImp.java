package com.tm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tm.model.NhomKhachHang;

@Repository
@Transactional
public class NhomKhachHangDaoImp implements NhomKhachHangDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<NhomKhachHang> get() {
		String sql = "SELECT * FROM `nhom_khach_hang`";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<NhomKhachHang>() {
			public NhomKhachHang mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new NhomKhachHang(rs.getString("maNhom"), rs.getString("maCha"), rs.getString("tenNhom"), rs.getInt("loaiNhom"));
			}
		});
	}

	public NhomKhachHang getByMaNhom(String maNhom) {
		String sql = "SELECT * FROM `nhom_khach_hang` where maNhom = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { maNhom }, new RowMapper<NhomKhachHang>() {
			public NhomKhachHang mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new NhomKhachHang(rs.getString("maNhom"), rs.getString("maCha"), rs.getString("tenNhom"), rs.getInt("loaiNhom"));
			}
		});
	}

	public String add(NhomKhachHang a) {
		try {
			List<NhomKhachHang> resultt = this.get();
			String maNhomMoi = "NKH_1";
			if(resultt.size() > 0) {
				Collections.sort(resultt, new NhomKhachHang());
				
				String[] split = resultt.get(resultt.size() - 1).getMaNhom().split("_");
				int sum_split = Integer.valueOf(split[1]) + 1;
				maNhomMoi = split[0] + "_" + sum_split;
			}
			
			
			String sql = "INSERT INTO `nhom_khach_hang`(`maNhom`, `maCha`, `tenNhom`, `loaiNhom`) VALUES (?, ?, ?, ?)";
			int i = jdbcTemplate.update(sql, maNhomMoi, a.getMaCha(), a.getTenNhom(), a.getLoaiNhom());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi hệ thống";
		}
	}

	public String update(NhomKhachHang a) {
		try {
			String sql = "UPDATE `nhom_khach_hang` SET `maCha`= ?,`tenNhom`= ?,`loaiNhom`= ? WHERE `maNhom`= ?";
			int i = jdbcTemplate.update(sql, a.getMaCha(), a.getTenNhom(), a.getLoaiNhom(), a.getMaNhom());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi hệ thống";
		}
	}

	public String delete(String maNhom) {
		try {
			String sql = "DELETE FROM `nhom_khach_hang` WHERE maNhom = ?";
			int i = jdbcTemplate.update(sql, maNhom);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi hệ thống";
		}
	}

	public String deleteByMaCha(String maCha) {
		try {
			String sql = "DELETE FROM `nhom_khach_hang` WHERE maCha = ?";
			int i = jdbcTemplate.update(sql, maCha);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi hệ thống";
		}
	}

	public boolean isMaNhom(String maNhom) {
		String sql = "SELECT * FROM `nhom_khach_hang` WHERE maNhom = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, maNhom);
		return row.next();
	}

	public boolean isMaCha(String maCha) {
		String sql = "SELECT * FROM `nhom_khach_hang` WHERE maCha = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, maCha);
		return row.next();
	}

}

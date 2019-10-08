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

import com.tm.model.NhomHang;

@Repository
@Transactional
public class NhomHangDaoImp implements NhomHangDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<NhomHang> get() {
		String sql = "SELECT * FROM `nhom_hang` ORDER BY `nhom_hang`.`tenNhom` ASC";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<NhomHang>() {
			public NhomHang mapRow(ResultSet rs, int rowNum) throws SQLException {
				NhomHang nhomHang = new NhomHang(rs.getString("maNhom"), rs.getString("maCha") == null ? "null" : rs.getString("maCha"), rs.getString("tenNhom"), rs.getInt("loaiNhom"));
				return nhomHang;
			}
		});
	}

	public NhomHang getByMaNhom(String maNhom) {
		String sql = "SELECT * FROM `nhom_hang` Where maNhom = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {maNhom}, new RowMapper<NhomHang>() {
			public NhomHang mapRow(ResultSet rs, int rowNum) throws SQLException {
				NhomHang nhomHang = new NhomHang(rs.getString("maNhom"), rs.getString("maCha") == null ? "null" : rs.getString("maCha"), rs.getString("tenNhom"), rs.getInt("loaiNhom"));
				return nhomHang;
			}
		});
	}

	public String add(NhomHang nhomHang) {
		try {
			List<NhomHang> resultt = this.get();
			String maNhomMoi = "NH_1";
			if(resultt.size() > 0) {
				Collections.sort(resultt, new NhomHang());

				String[] split = resultt.get(resultt.size() - 1).getMaNhom().split("_");
				int sum_split = Integer.valueOf(split[1]) + 1;
				maNhomMoi = split[0] + "_" + sum_split;
			}


			String sql = "INSERT INTO `nhom_hang`(`maNhom`, `maCha`, `tenNhom`, `loaiNhom`) VALUES (?, ?, ?, ?)";
			int i = jdbcTemplate.update(sql, maNhomMoi, nhomHang.getMaCha(), nhomHang.getTenNhom(), nhomHang.getLoaiNhom());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String update(NhomHang nhomHang) {
		try {
			String sql = "UPDATE `nhom_hang` SET `maCha`= ?,`tenNhom`= ?,`loaiNhom`= ? WHERE `maNhom`= ?";
			int i = jdbcTemplate.update(sql, nhomHang.getMaCha(), nhomHang.getTenNhom(), nhomHang.getLoaiNhom(), nhomHang.getMaNhom());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String delete(String maNhom) {
		try {
			String sql = "DELETE FROM `nhom_hang` Where maNhom = ?";
			int i = jdbcTemplate.update(sql, maNhom);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public boolean isMaNhom(String maNhom) {
		String sql = "SELECT * FROM `nhom_hang` WHERE maNhom = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, maNhom);
		return row.next();
	}

	public boolean isMaCha(String maCha) {
		String sql = "SELECT * FROM `nhom_hang` WHERE maCha = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, maCha);
		return row.next();
	}

	public String deleteByMaCha(String maCha) {
		try {
			String sql = "DELETE FROM `nhom_hang` Where maCha = ?";
			int i = jdbcTemplate.update(sql, maCha);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String moveNhom(String maNhom, String maCha) {
		try {
			String sql = "UPDATE `nhom_hang` SET `maCha` = ? WHERE `maNhom` = ?";
			int i = jdbcTemplate.update(sql, maCha, maNhom);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

}

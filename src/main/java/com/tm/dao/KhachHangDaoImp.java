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

import com.tm.model.KhachHang;

@Repository
@Transactional
public class KhachHangDaoImp implements KhachHangDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<KhachHang> get() {
		String sql = "SELECT * FROM khach_hang";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<KhachHang>() {
			public KhachHang mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new KhachHang(
						rs.getString("maKH"), rs.getString("maNhom"), 
						rs.getString("tenKH"), rs.getString("diaChi"), 
						rs.getString("dienThoai"), rs.getString("maSoThue"), 
						rs.getFloat("thuDK"), rs.getFloat("traDK"));
			}
		});
	}

	public List<KhachHang> getByMaNhom(String maNhom) {
		String sql = "SELECT * FROM khach_hang where maNhom = ?";
		return jdbcTemplate.query(sql, new Object[] {maNhom}, new RowMapper<KhachHang>() {
			public KhachHang mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new KhachHang(
						rs.getString("maKH"), rs.getString("maNhom"), 
						rs.getString("tenKH"), rs.getString("diaChi"), 
						rs.getString("dienThoai"), rs.getString("maSoThue"), 
						rs.getFloat("thuDK"), rs.getFloat("traDK"));
			}
		});
	}

	public KhachHang getByMaKhachHang(String maKH) {
		String sql = "SELECT * FROM khach_hang where maKH = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {maKH}, new RowMapper<KhachHang>() {
			public KhachHang mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new KhachHang(
						rs.getString("maKH"), rs.getString("maNhom"), 
						rs.getString("tenKH"), rs.getString("diaChi"), 
						rs.getString("dienThoai"), rs.getString("maSoThue"), 
						rs.getFloat("thuDK"), rs.getFloat("traDK"));
			}
		});
	}

	public String add(KhachHang a) {
		try {
			List<KhachHang> resultt = this.get();
			String maKhachHangMoi = "KH_1";
			
			if(resultt.size() > 0) {
				Collections.sort(resultt, new KhachHang());
				
				String[] split = resultt.get(resultt.size() - 1).getMaKH().split("_");
				int sum_split = Integer.valueOf(split[1]) + 1;
				maKhachHangMoi = split[0] + "_" + sum_split;
			}
			
			String sql = "INSERT INTO `khach_hang`VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			int i = jdbcTemplate.update(sql, maKhachHangMoi, a.getMaNhom(), a.getTenKH(), a.getDiaChi(), a.getDienThoai(), a.getMaSoThue(), a.getThuDK(), a.getTraDK());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String update(KhachHang a) {
		try {
			String sql = "UPDATE `khach_hang` SET"
					+ " `maNhom`= ?,`tenKH`= ?,"
					+ "`diaChi`= ?,`dienThoai`= ?,"
					+ "`maSoThue`= ?,`thuDK`= ?,"
					+ "`traDK`= ? WHERE `maKH`= ?";
			int i = jdbcTemplate.update(sql, a.getMaNhom(), a.getTenKH(), a.getDiaChi(), a.getDienThoai(), a.getMaSoThue(), a.getThuDK(), a.getTraDK(), a.getMaKH());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String delete(String maKH) {
		try {
			String sql = "DELETE FROM `khach_hang` WHERE maKH = ?";
			int i = jdbcTemplate.update(sql, maKH);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public boolean isMaKhachHang(String maKH) {
		String sql = "SELECT * FROM `khach_hang` WHERE maKH = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, maKH);
		return row.next();
	}
}

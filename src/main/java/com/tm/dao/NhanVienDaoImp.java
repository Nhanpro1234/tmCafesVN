package com.tm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tm.model.NhanVien;

@Repository
@Transactional
public class NhanVienDaoImp implements NhanVienDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<NhanVien> get() {
		String sql = "SELECT * FROM nhan_vien";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<NhanVien>() {
			public NhanVien mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new NhanVien(
						rs.getString("maNV"), rs.getString("maBP"), 
						rs.getString("hoTen"), rs.getString("diaChi"), 
						rs.getString("dienThoai"), rs.getString("maSoThue"),
						rs.getInt("isKeToan"), rs.getInt("isThuNgan"));
			}
		});
	}

	public List<NhanVien> getByMaBP(String maBP) {
		String sql = "SELECT * FROM nhan_vien where maBP = ?";
		return jdbcTemplate.query(sql, new Object[] {maBP}, new RowMapper<NhanVien>() {
			public NhanVien mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new NhanVien(
						rs.getString("maNV"), rs.getString("maBP"), 
						rs.getString("hoTen"), rs.getString("diaChi"), 
						rs.getString("dienThoai"), rs.getString("maSoThue"),
						rs.getInt("isKeToan"), rs.getInt("isThuNgan"));
			}
		});
	}

	public NhanVien getByMaNV(String maNV) {
		String sql = "SELECT * FROM nhan_vien where maNV = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {maNV}, new RowMapper<NhanVien>() {
			public NhanVien mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new NhanVien(
						rs.getString("maNV"), rs.getString("maBP"), 
						rs.getString("hoTen"), rs.getString("diaChi"), 
						rs.getString("dienThoai"), rs.getString("maSoThue"),
						rs.getInt("isKeToan"), rs.getInt("isThuNgan"));
			}
		});
	}

	public String add(NhanVien nhanVien) {
		try {
			List<NhanVien> resultt = this.get();
			String maNhanVienMoi = "NV_1";
			if(resultt.size() > 0) {
				Collections.sort(resultt, new NhanVien());

				String[] split = resultt.get(resultt.size() - 1).getMaNV().split("_");
				int sum_split = Integer.valueOf(split[1]) + 1;
				maNhanVienMoi = split[0] + "_" + sum_split;
			}


			String sql = "INSERT INTO `nhan_vien` VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			int i = jdbcTemplate.update(sql, maNhanVienMoi, nhanVien.getMaBP(), nhanVien.getHoTen(), nhanVien.getDiaChi(), nhanVien.getDienThoai(), nhanVien.getDienThoai(), nhanVien.getIsKeToan(), nhanVien.getIsThuNgan());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String update(NhanVien nhanVien) {
		try {
			String sql = "UPDATE `nhan_vien` SET `maBP`= ?,`hoTen`= ?,"
					+ "`diaChi`= ?,`dienThoai`= ?,"
					+ "`maSoThue`= ?,`isKeToan`= ?,"
					+ "`isThuNgan`= ? WHERE `maNV`= ?";
			int i = jdbcTemplate.update(sql, nhanVien.getMaBP(), nhanVien.getHoTen(), nhanVien.getDiaChi(), nhanVien.getDienThoai(), nhanVien.getMaSoThue(), nhanVien.getIsKeToan(), nhanVien.getIsThuNgan(), nhanVien.getMaNV());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String del(String maNV) {
		try {
			String sql = "DELETE FROM `nhan_vien` WHERE maNV = ?";
			int i = jdbcTemplate.update(sql, maNV);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

}

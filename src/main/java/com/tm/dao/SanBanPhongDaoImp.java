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

import com.tm.model.SanBanPhong;

@Repository
@Transactional
public class SanBanPhongDaoImp implements SanBanPhongDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<SanBanPhong> get() {
		String sql = "SELECT san_ban_phong.soBan, san_ban_phong.maKV, khu_vuc.tenKV, san_ban_phong.maBG, loai_bang_gia.tenBG"
				+ " FROM san_ban_phong"
				+ " INNER JOIN khu_vuc ON san_ban_phong.maKV = khu_vuc.maKV"
				+ " INNER JOIN loai_bang_gia ON san_ban_phong.maBG = loai_bang_gia.maBG";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<SanBanPhong>() {
			public SanBanPhong mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanBanPhong sanBanPhong = new SanBanPhong(rs.getString("soBan"),rs.getString("maKV"), rs.getString("tenKV"), rs.getString("maBG"), rs.getString("tenBG"));
				return sanBanPhong;
			}
		});
	}

	public List<SanBanPhong> getByKhuVuc(String khuVuc) {
		String sql = "SELECT san_ban_phong.soBan, san_ban_phong.maKV, khu_vuc.tenKV, san_ban_phong.maBG, loai_bang_gia.tenBG"
				+ " FROM san_ban_phong"
				+ " INNER JOIN khu_vuc ON san_ban_phong.maKV = khu_vuc.maKV"
				+ " INNER JOIN loai_bang_gia ON san_ban_phong.maBG = loai_bang_gia.maBG"
				+ " WHERE san_ban_phong.maKV = ?";
		return jdbcTemplate.query(sql, new Object[] { khuVuc }, new RowMapper<SanBanPhong>() {
			public SanBanPhong mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanBanPhong sanBanPhong = new SanBanPhong(rs.getString("soBan"),rs.getString("maKV"), rs.getString("tenKV"), rs.getString("maBG"), rs.getString("tenBG"));
				return sanBanPhong;
			}
		});
	}

	public List<SanBanPhong> getByBangGia(String bangGia) {
		String sql = "SELECT san_ban_phong.soBan, san_ban_phong.maKV, khu_vuc.tenKV, san_ban_phong.maBG, loai_bang_gia.tenBG"
				+ " FROM san_ban_phong"
				+ " INNER JOIN khu_vuc ON san_ban_phong.maKV = khu_vuc.maKV"
				+ " INNER JOIN loai_bang_gia ON san_ban_phong.maBG = loai_bang_gia.maBG"
				+ " WHERE san_ban_phong.maBG = ?";
		return jdbcTemplate.query(sql, new Object[] { bangGia }, new RowMapper<SanBanPhong>() {
			public SanBanPhong mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanBanPhong sanBanPhong = new SanBanPhong(rs.getString("soBan"),rs.getString("maKV"), rs.getString("tenKV"), rs.getString("maBG"), rs.getString("tenBG"));
				return sanBanPhong;
			}
		});
	}

	public SanBanPhong getBySoBan(String soBan) {
		String sql = "SELECT san_ban_phong.soBan, san_ban_phong.maKV, khu_vuc.tenKV, san_ban_phong.maBG, loai_bang_gia.tenBG"
				+ " FROM san_ban_phong"
				+ " INNER JOIN khu_vuc ON san_ban_phong.maKV = khu_vuc.maKV"
				+ " INNER JOIN loai_bang_gia ON san_ban_phong.maBG = loai_bang_gia.maBG"
				+ " WHERE san_ban_phong.soBan = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { soBan }, new RowMapper<SanBanPhong>() {
			public SanBanPhong mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanBanPhong sanBanPhong = new SanBanPhong(rs.getString("soBan"),rs.getString("maKV"), rs.getString("tenKV"), rs.getString("maBG"), rs.getString("tenBG"));
				return sanBanPhong;
			}
		});
	}

	public String add(SanBanPhong sanBanPhong) {
		try {
			List<SanBanPhong> resultt = this.get();
			String maSoBanMoi = "BS_1";
			if(resultt.size() > 0) {
				Collections.sort(resultt, new SanBanPhong());

				String[] split = resultt.get(resultt.size() - 1).getSoBan().split("_");
				int sum_split = Integer.valueOf(split[1]) + 1;
				maSoBanMoi = split[0] + "_" + sum_split;
			}
			

			String sql = "INSERT INTO `san_ban_phong`(`soBan`, `maKV`, `maBG`) VALUES (?, ?, ?)";
			int i = jdbcTemplate.update(sql, maSoBanMoi, sanBanPhong.getMaKV(), sanBanPhong.getMaBG());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String update(SanBanPhong sanBanPhong) {
		try {
			String sql = "UPDATE `san_ban_phong` SET `maKV`= ?,`maBG`= ? WHERE `soBan`= ?";
			int i = jdbcTemplate.update(sql, sanBanPhong.getMaKV(), sanBanPhong.getMaBG(), sanBanPhong.getSoBan());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String delete(String soBan) {
		try {
			String sql = "DELETE FROM `san_ban_phong` Where soBan = ?";
			int i = jdbcTemplate.update(sql, soBan);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

}

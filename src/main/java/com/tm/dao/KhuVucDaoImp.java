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

import com.tm.model.KhuVuc;

@Repository
@Transactional
public class KhuVucDaoImp implements KhuVucDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<KhuVuc> get() {
		String sql = "SELECT * FROM `khu_vuc` ";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<KhuVuc>() {
			public KhuVuc mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new KhuVuc(rs.getString("maKV"), rs.getString("tenKV"));
			}
		});
	}

	public KhuVuc getByMaKhuVuc(String maKV) {
		String sql = "SELECT * FROM `khu_vuc` where maKV = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {maKV}, new RowMapper<KhuVuc>() {
			public KhuVuc mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new KhuVuc(rs.getString("maKV"), rs.getString("tenKV"));
			}
		});
	}

	public String add(KhuVuc khuVuc) {
		try {
			List<KhuVuc> resultt = this.get();
			String maKhuVucMoi = "KV_1";

			if(resultt.size() > 0) {
				Collections.sort(resultt, new KhuVuc());

				String[] split = resultt.get(resultt.size() - 1).getMaKV().split("_");
				int sum_split = Integer.valueOf(split[1]) + 1;
				maKhuVucMoi = split[0] + "_" + sum_split;
			}

			String sql = "INSERT INTO `khu_vuc`(`maKV`, `tenKV`) VALUES (?, ?)";
			int i = jdbcTemplate.update(sql, maKhuVucMoi, khuVuc.getTenKV());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String update(KhuVuc khuVuc) {
		try {
			String sql = "UPDATE `khu_vuc` SET `tenKV`= ? WHERE `maKV`= ?";
			int i = jdbcTemplate.update(sql, khuVuc.getTenKV(), khuVuc.getMaKV());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String del(String maKV) {
		try {
			String sql = "DELETE FROM `khu_vuc` WHERE maKV = ?";
			int i = jdbcTemplate.update(sql, maKV);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

}

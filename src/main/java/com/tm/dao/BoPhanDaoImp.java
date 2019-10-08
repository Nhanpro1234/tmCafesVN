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

import com.tm.model.BoPhan;

@Repository
@Transactional
public class BoPhanDaoImp implements BoPhanDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<BoPhan> get() {
		String sql = "SELECT * FROM `bo_phan`";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<BoPhan>() {
			public BoPhan mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new BoPhan(rs.getString("maBP"), rs.getString("maCha") == null ? "null" : rs.getString("maCha"), rs.getString("tenBP"));
			}
		});
	}

	public BoPhan getByMaBP(String maBP) {
		String sql = "SELECT * FROM `bo_phan` where maBP = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {maBP}, new RowMapper<BoPhan>() {
			public BoPhan mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new BoPhan(rs.getString("maBP"), rs.getString("maCha") == null ? "null" : rs.getString("maCha"), rs.getString("tenBP"));
			}
		});
	}

	public String add(BoPhan boPhan) {
		try {
			List<BoPhan> resultt = this.get();
			String maBoPhamMoi = "BP_1";
			if(resultt.size() > 0) {
				Collections.sort(resultt, new BoPhan());
				
				String[] split = resultt.get(resultt.size() - 1).getMaBP().split("_");
				int sum_split = Integer.valueOf(split[1]) + 1;
				maBoPhamMoi = split[0] + "_" + sum_split;
			}
			
			String sql = "INSERT INTO `bo_phan`(`maBP`, `maCha`, `tenBP`) VALUES (?, ?, ?)";
			int i = jdbcTemplate.update(sql, maBoPhamMoi, boPhan.getMaCha(), boPhan.getTenBP());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String update(BoPhan boPhan) {
		try {
			String sql = "UPDATE `bo_phan` SET `maCha`= ?,`tenBP`= ? WHERE `maBP`= ?";
			int i = jdbcTemplate.update(sql, boPhan.getMaCha(), boPhan.getTenBP(), boPhan.getMaBP());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String delete(String maBP) {
		try {
			String sql = "DELETE FROM bo_phan where maBP = ?";
			int i = jdbcTemplate.update(sql, maBP);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public boolean isMaBP(String maBP) {
		String sql = "SELECT * FROM `bo_phan` WHERE maBP = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, maBP);
		return row.next();
	}

	public boolean isMaCha(String maCha) {
		String sql = "SELECT * FROM `bo_phan` WHERE maCha = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, maCha);
		return row.next();
	}

	public String deleteByMaCha(String maCha) {
		try {
			String sql = "DELETE FROM `bo_phan` Where maCha = ?";
			int i = jdbcTemplate.update(sql, maCha);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String moveBoPhan(String maBP, String maCha) {
		try {
			String sql = "UPDATE `bo_phan` SET `maCha` = ? WHERE `maBP` = ?";
			int i = jdbcTemplate.update(sql, maCha, maBP);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

}

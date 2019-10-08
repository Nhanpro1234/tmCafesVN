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

import com.tm.model.LoaiBangGia;

@Repository
@Transactional
public class LoaiBangGiaDaoImp implements LoaiBangGiaDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<LoaiBangGia> get() {
		String sql = "SELECT * FROM `loai_bang_gia`";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<LoaiBangGia>() {
			public LoaiBangGia mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new LoaiBangGia(rs.getString("maBG"), rs.getString("tenBG"), rs.getInt("macDinh"));
			}
		});
	}

	public LoaiBangGia getByMaKhuVuc(String maBG) {
		String sql = "SELECT * FROM `loai_bang_gia` where maBG = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {maBG}, new RowMapper<LoaiBangGia>() {
			public LoaiBangGia mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new LoaiBangGia(rs.getString("maBG"), rs.getString("tenBG"), rs.getInt("macDinh"));
			}
		});
	}

	public String add(LoaiBangGia loaiBangGia) {
		try {
			List<LoaiBangGia> resultt = this.get();
			String maBangGiaMoi = "BG_1";
			
			if(resultt.size() > 0) {
				Collections.sort(resultt, new LoaiBangGia());
				
				String[] split = resultt.get(resultt.size() - 1).getMaBG().split("_");
				int sum_split = Integer.valueOf(split[1]) + 1;
				maBangGiaMoi = split[0] + "_" + sum_split;
			}
			
			
			
			String sql = "INSERT INTO `loai_bang_gia`(`maBG`, `tenBG`, `macDinh`) VALUES (?, ?, ?)";
			int i = jdbcTemplate.update(sql, maBangGiaMoi, loaiBangGia.getTenBG(), 0);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String update(LoaiBangGia loaiBangGia) {
		try {
			String sql = "UPDATE `loai_bang_gia` SET `tenBG`= ? WHERE `maBG`= ?";
			int i = jdbcTemplate.update(sql, loaiBangGia.getTenBG(), loaiBangGia.getMaBG());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String del(String maBG) {
		try {
			String sql = "DELETE FROM `loai_bang_gia` WHERE maBG = ?";
			int i = jdbcTemplate.update(sql, maBG);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

}

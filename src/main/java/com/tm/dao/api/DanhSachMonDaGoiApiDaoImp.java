package com.tm.dao.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tm.model.api.DanhSachMonDaGoi;

@Repository
@Transactional
public class DanhSachMonDaGoiApiDaoImp implements DanhSachMonDaGoiApiDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<DanhSachMonDaGoi> get() {
		String sql = "SELECT dong_chung_tu.id, chung_tu.soBan, san_pham.tenSP, dong_chung_tu.soLuong, dong_chung_tu.gioVao FROM dong_chung_tu INNER JOIN san_pham ON dong_chung_tu.maSP = san_pham.maSP INNER JOIN chung_tu ON dong_chung_tu.soCT = chung_tu.soCT WHERE dong_chung_tu.ghiChu = \"Đang làm\" AND dong_chung_tu.status = 0 and chung_tu.trangThai = 0 ORDER BY dong_chung_tu.gioVao ASC ";
		
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<DanhSachMonDaGoi>() {
			public DanhSachMonDaGoi mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DanhSachMonDaGoi(rs.getInt("id"), rs.getString("soBan"), rs.getString("tenSP"), rs.getInt("soLuong"), rs.getString("gioVao"));
			}
		});
	}
	
}

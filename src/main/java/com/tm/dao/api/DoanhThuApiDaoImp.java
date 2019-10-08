package com.tm.dao.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tm.model.api.DoanhThuThucDon;

@Repository
@Transactional
public class DoanhThuApiDaoImp implements DoanhThuApiDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<DoanhThuThucDon> getThucDon(String time_start, String time_end, String nhanVien) {
		String sql_nhanVien = "";
		if(nhanVien != null) {
			sql_nhanVien = " AND chung_tu.maThuNgan = '" + nhanVien + "' ";
		}
		String sql = "SELECT san_pham.tenSP, dong_chung_tu.maDVT,\r\n" + 
				"SUM(dong_chung_tu.soLuong) as sumSoLuong, \r\n" + 
				"SUM(dong_chung_tu.giam) as sumGiam,\r\n" + 
				"SUM(dong_chung_tu.donGia) as sumDonGia, \r\n" + 
				"SUM((dong_chung_tu.donGia - dong_chung_tu.giam) * dong_chung_tu.soLuong) as sumDoanhSo,\r\n" + 
				"SUM((dong_chung_tu.donGia - dong_chung_tu.giam) * dong_chung_tu.soLuong) / SUM(dong_chung_tu.soLuong) as sumTrungBinh\r\n" + 
				"FROM dong_chung_tu\r\n" + 
				"INNER JOIN san_pham ON dong_chung_tu.maSP = san_pham.maSP\r\n" + 
				"INNER JOIN chung_tu ON dong_chung_tu.soCT = chung_tu.soCT\r\n" + 
				"WHERE dong_chung_tu.status = 0 AND dong_chung_tu.gioVao BETWEEN ? AND ? " + sql_nhanVien +
				"GROUP BY dong_chung_tu.maSP";
		return jdbcTemplate.query(sql, new Object[] {time_start, time_end}, new RowMapper<DoanhThuThucDon>() {
			public DoanhThuThucDon mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DoanhThuThucDon(rs.getString("tenSP"), rs.getString("maDVT"), rs.getInt("sumSoLuong"), rs.getFloat("sumDonGia"), rs.getFloat("sumGiam"), rs.getFloat("sumDoanhSo"), rs.getFloat("sumTrungBinh"));
			}
		});
	}


}

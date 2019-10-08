package com.tm.dao.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tm.model.api.SanPhamApi;

@Repository
@Transactional
public class SanPhamApiDaoImp implements SanPhamApiDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<SanPhamApi> getByMaNhom(String maNhom) {
		String sql = "SELECT san_pham.maSP as ma,"
				+ " san_pham.tenSP as ten,"
				+ " don_vi_tinh.tenDVT as dvt,"
				+ " GROUP_CONCAT(bang_gia.donGia separator ':') as donGia,"
				+ " GROUP_CONCAT(bang_gia.giam separator ':') as giam,"
				+ " GROUP_CONCAT(loai_bang_gia.tenBG separator ':') as tenBG"
				+ " FROM san_pham "
				+ "INNER JOIN don_vi_tinh ON san_pham.maDVT = don_vi_tinh.maDVT "
				+ "INNER JOIN bang_gia on san_pham.maSP = bang_gia.maSP "
				+ "INNER JOIN loai_bang_gia ON loai_bang_gia.maBG = bang_gia.maBG "
				+ "WHERE san_pham.maNhom = ? GROUP BY san_pham.maSP ";
		return jdbcTemplate.query(sql, new Object[] { maNhom }, new RowMapper<SanPhamApi>() {
			public SanPhamApi mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new SanPhamApi(rs.getString("ma"), rs.getString("ten"), rs.getString("dvt"), rs.getString("donGia"), rs.getString("giam"), rs.getString("tenBG"));
			}
		});
	}

	public List<SanPhamApi> get() {
		String sql = "SELECT san_pham.maSP as ma,"
				+ " san_pham.tenSP as ten,"
				+ " don_vi_tinh.tenDVT as dvt,"
				+ " GROUP_CONCAT(bang_gia.donGia separator ':') as donGia,"
				+ " GROUP_CONCAT(bang_gia.giam separator ':') as giam,"
				+ " GROUP_CONCAT(loai_bang_gia.tenBG separator ':') as tenBG"
				+ " FROM san_pham "
				+ "INNER JOIN don_vi_tinh ON san_pham.maDVT = don_vi_tinh.maDVT "
				+ "INNER JOIN bang_gia on san_pham.maSP = bang_gia.maSP "
				+ "INNER JOIN loai_bang_gia ON loai_bang_gia.maBG = bang_gia.maBG "
				+ "GROUP BY san_pham.maSP ";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<SanPhamApi>() {
			public SanPhamApi mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new SanPhamApi(rs.getString("ma"), rs.getString("ten"), rs.getString("dvt"), rs.getString("donGia"), rs.getString("giam"), rs.getString("tenBG"));
			}
		});
	}

}

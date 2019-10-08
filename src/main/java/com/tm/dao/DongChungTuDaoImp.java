package com.tm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tm.model.DongChungTu;

@Repository
@Transactional
public class DongChungTuDaoImp implements DongChungTuDao {


	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<DongChungTu> get() {
		String sql = "SELECT "
				+ "dong_chung_tu.id, dong_chung_tu.soCT, dong_chung_tu.maSP, "
				+ "san_pham.tenSP, dong_chung_tu.maDVT, don_vi_tinh.tenDVT, "
				+ "dong_chung_tu.soLuong, dong_chung_tu.donGia, dong_chung_tu.gioVao, "
				+ "dong_chung_tu.gioRa, dong_chung_tu.traLai, dong_chung_tu.giam, "
				+ "dong_chung_tu.ghiChu, dong_chung_tu.status "
				+ "FROM dong_chung_tu "
				+ "INNER JOIN san_pham ON dong_chung_tu.maSP = san_pham.maSP "
				+ "INNER JOIN don_vi_tinh ON dong_chung_tu.maDVT = don_vi_tinh.maDVT";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<DongChungTu>() {
			public DongChungTu mapRow(ResultSet rs, int rowNum) throws SQLException {
				DongChungTu dongChungTu = new DongChungTu(
						rs.getInt("id"), rs.getInt("soCT"), 
						rs.getString("maSP"), rs.getString("tenSP"), 
						rs.getString("maDVT"), rs.getString("tenDVT"), 
						rs.getInt("soLuong"), rs.getFloat("donGia"), 
						rs.getString("gioVao") == null ? "" : rs.getString("gioVao"), rs.getString("gioRa") == null ? "" : rs.getString("gioRa"), 
								rs.getInt("traLai"), rs.getFloat("giam"), 
								rs.getString("ghiChu") == null ? "" : rs.getString("ghiChu"), rs.getInt("status"));

				return dongChungTu;
			}
		});
	}

	public DongChungTu getById(int id) {
		String sql = "SELECT dong_chung_tu.id, dong_chung_tu.soCT, dong_chung_tu.maSP, "
				+ "san_pham.tenSP, dong_chung_tu.maDVT, don_vi_tinh.tenDVT, "
				+ "dong_chung_tu.soLuong, dong_chung_tu.donGia, dong_chung_tu.gioVao, "
				+ "dong_chung_tu.gioRa, dong_chung_tu.traLai, dong_chung_tu.giam, "
				+ "dong_chung_tu.ghiChu, dong_chung_tu.status "
				+ "FROM dong_chung_tu "
				+ "INNER JOIN san_pham ON dong_chung_tu.maSP = san_pham.maSP "
				+ "INNER JOIN don_vi_tinh ON dong_chung_tu.maDVT = don_vi_tinh.maDVT where dong_chung_tu.id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<DongChungTu>() {
			public DongChungTu mapRow(ResultSet rs, int rowNum) throws SQLException {
				DongChungTu dongChungTu = new DongChungTu(
						rs.getInt("id"), rs.getInt("soCT"), 
						rs.getString("maSP"), rs.getString("tenSP"), 
						rs.getString("maDVT"), rs.getString("tenDVT"), 
						rs.getInt("soLuong"), rs.getFloat("donGia"), 
						rs.getString("gioVao") == null ? "" : rs.getString("gioVao"), rs.getString("gioRa") == null ? "" : rs.getString("gioRa"), 
								rs.getInt("traLai"), rs.getFloat("giam"), 
								rs.getString("ghiChu") == null ? "" : rs.getString("ghiChu"), rs.getInt("status"));

				return dongChungTu;
			}
		});
	}

	public List<DongChungTu> getBySoCT(int soCT) {
		String sql = "SELECT "
				+ "dong_chung_tu.id, dong_chung_tu.soCT, dong_chung_tu.maSP, "
				+ "san_pham.tenSP, dong_chung_tu.maDVT, don_vi_tinh.tenDVT, "
				+ "dong_chung_tu.soLuong, dong_chung_tu.donGia, dong_chung_tu.gioVao, "
				+ "dong_chung_tu.gioRa, dong_chung_tu.traLai, dong_chung_tu.giam, "
				+ "dong_chung_tu.ghiChu, dong_chung_tu.status "
				+ "FROM dong_chung_tu "
				+ "INNER JOIN san_pham ON dong_chung_tu.maSP = san_pham.maSP "
				+ "INNER JOIN don_vi_tinh ON dong_chung_tu.maDVT = don_vi_tinh.maDVT "
				+ "where dong_chung_tu.soCT = ? and dong_chung_tu.status = 0";

		return jdbcTemplate.query(sql, new Object[]{soCT}, new RowMapper<DongChungTu>() {
			public DongChungTu mapRow(ResultSet rs, int rowNum) throws SQLException {
				DongChungTu dongChungTu = new DongChungTu(
						rs.getInt("id"), rs.getInt("soCT"), 
						rs.getString("maSP"), rs.getString("tenSP"), 
						rs.getString("maDVT"), rs.getString("tenDVT"), 
						rs.getInt("soLuong"), rs.getFloat("donGia"), 
						rs.getString("gioVao") == null ? "" : rs.getString("gioVao"),
								rs.getString("gioRa") == null ? "" : rs.getString("gioRa"), 
										rs.getInt("traLai"), rs.getFloat("giam"), 
										rs.getString("ghiChu") == null ? "" : rs.getString("ghiChu"), rs.getInt("status"));

				return dongChungTu;
			}
		});
	}

	public String add(DongChungTu dongChungTu) {
		String sql = "INSERT INTO `dong_chung_tu` VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			int i = jdbcTemplate.update(sql,
					dongChungTu.getSoCT(),
					dongChungTu.getMaSP(),
					dongChungTu.getMaDVT(),
					dongChungTu.getSoLuong(),
					dongChungTu.getDonGia(),
					dongChungTu.getGioVao(),
					null, 0, dongChungTu.getGiam(), "Đang làm", dongChungTu.getStatus());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			e.printStackTrace();
			return "Lỗi phát sinh";
		}
	}

	public String update(DongChungTu dongChungTu) {
		return null;
	}

	public String deleteById(int id) {
		return null;
	}

	public String deleteBySoCT(int soCT) {
		return null;
	}

	public String updateByCT(int soCT_old, int soCT_new) {
		return null;
	}

	public String update_by_sql(String colum_key, Object value_key, String colum_data, Object value_data) {
		String sql = "UPDATE `dong_chung_tu` SET " + colum_data + " = ? WHERE " + colum_key + "= ?";
		try {
			int i = jdbcTemplate.update(sql, value_data, value_key);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public boolean isSP(int soCT, String maSP) {
		String sql = "SELECT * FROM `dong_chung_tu` where soCT = ? and maSP = ? and status = 0";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, soCT, maSP);
		if(row.next()) {
			return true;
		}
		return false;
	}

	public float thanhTien(int soCT) {
		String sql = "SELECT SUM((donGia - giam) * soLuong) as sum FROM `dong_chung_tu` WHERE status = 0 AND soCT = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] {soCT}, new RowMapper<Float>() {
				public Float mapRow(ResultSet rs, int rowNum) throws SQLException {
					Float f = rs.getFloat("SUM");
					return f;
				}

			});
		} catch (Exception e) {
			return 0;
		}
	}

	public String updateSoLuong(int soCT, String maSP, int soLuong) {
		try {
			String sql = "UPDATE dong_chung_tu SET soLuong = soLuong + ? where soCT = ? and maSP = ? and status = 0";
			int i = jdbcTemplate.update(sql, soLuong, soCT, maSP);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public boolean isGhiChu(int soCT) {
		String sql = "SELECT * FROM `dong_chung_tu` WHERE ghiChu = \"Đang làm\" AND soCT = ? ";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, soCT);
		if(row.next()) {
			return true;
		}
		return false;
	}

}

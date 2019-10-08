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

import com.tm.model.ChungTu;

@Repository
@Transactional
public class ChungTuDaoImp implements ChungTuDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<ChungTu> get() {
		String sql = "SELECT * FROM `chung_tu` ORDER BY `chung_tu`.`soCT` DESC";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<ChungTu>() {

			public ChungTu mapRow(ResultSet rs, int rowNum) throws SQLException {
				ChungTu chungTu = new ChungTu(	rs.getInt("soCT"), rs.getString("ngayCT"), 
						rs.getInt("loai"), rs.getString("soBan"), 
						rs.getString("maKH") == null ? "" : rs.getString("maKH"), rs.getInt("soKhach"), 
						rs.getString("noiDung") == null ? "" : rs.getString("noiDung"), rs.getString("maThuNgan") == null ? "" : rs.getString("maThuNgan"), 
						rs.getString("maNhanVien") == null ? "" : rs.getString("maNhanVien"), rs.getFloat("giam"), 
						rs.getFloat("thueVAT"), rs.getFloat("phiPV"), 
						rs.getFloat("soTien"), rs.getFloat("traTruoc"), 
						rs.getFloat("conNo"), rs.getString("ngayDat"), 
						rs.getInt("trangThai"));
				return chungTu;
			}

		});
	}

	public ChungTu getBySoBan(String soBan, int tinhTrang) {
		String sql = "SELECT * FROM `chung_tu` WHERE soBan = ? AND trangThai = ? ORDER BY `soCT` DESC ";

		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, soBan, tinhTrang);
		if(row.next()) {
			return jdbcTemplate.queryForObject(sql, new Object[] {soBan, tinhTrang}, new RowMapper<ChungTu>() {

				public ChungTu mapRow(ResultSet rs, int rowNum) throws SQLException {
					ChungTu chungTu = new ChungTu(	rs.getInt("soCT"), rs.getString("ngayCT"), 
							rs.getInt("loai"), rs.getString("soBan"), 
							rs.getString("maKH") == null ? "" : rs.getString("maKH"), rs.getInt("soKhach"), 
							rs.getString("noiDung") == null ? "" : rs.getString("noiDung"), rs.getString("maThuNgan") == null ? "" : rs.getString("maThuNgan"), 
							rs.getString("maNhanVien") == null ? "" : rs.getString("maNhanVien"), rs.getFloat("giam"), 
							rs.getFloat("thueVAT"), rs.getFloat("phiPV"), 
							rs.getFloat("soTien"), rs.getFloat("traTruoc"), 
							rs.getFloat("conNo"), rs.getString("ngayDat"), 
							rs.getInt("trangThai"));
					return chungTu;
				}

			});
		}else {
			return null;
		}
	}

	public ChungTu getBySoCT(int soCT) {
		String sql = "SELECT * FROM `chung_tu` WHERE soCT = ? ORDER BY `soCT` DESC ";

		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, soCT);
		if(!row.next()) {
			return null;
		}

		return jdbcTemplate.queryForObject(sql, new Object[] {soCT}, new RowMapper<ChungTu>() {

			public ChungTu mapRow(ResultSet rs, int rowNum) throws SQLException {
				ChungTu chungTu = new ChungTu(	rs.getInt("soCT"), rs.getString("ngayCT"), 
						rs.getInt("loai"), rs.getString("soBan"), 
						rs.getString("maKH") == null ? "" : rs.getString("maKH"), rs.getInt("soKhach"), 
						rs.getString("noiDung") == null ? "" : rs.getString("noiDung"), rs.getString("maThuNgan") == null ? "" : rs.getString("maThuNgan"), 
						rs.getString("maNhanVien") == null ? "" : rs.getString("maNhanVien"), rs.getFloat("giam"), 
						rs.getFloat("thueVAT"), rs.getFloat("phiPV"), 
						rs.getFloat("soTien"), rs.getFloat("traTruoc"), 
						rs.getFloat("conNo"), rs.getString("ngayDat"), 
						rs.getInt("trangThai"));
				return chungTu;
			}

		});
	}

	public List<ChungTu> getByTinhTrang(int tinhTrang) {
		String sql = "SELECT * FROM `chung_tu` WHERE soCT = ? ORDER BY `soCT` DESC ";

		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, tinhTrang);
		if(row.next()) {
			return jdbcTemplate.query(sql, new Object[] {tinhTrang}, new RowMapper<ChungTu>() {
				public ChungTu mapRow(ResultSet rs, int rowNum) throws SQLException {
					ChungTu chungTu = new ChungTu(	rs.getInt("soCT"), rs.getString("ngayCT"), 
							rs.getInt("loai"), rs.getString("soBan"), 
							rs.getString("maKH") == null ? "" : rs.getString("maKH"), rs.getInt("soKhach"), 
							rs.getString("noiDung") == null ? "" : rs.getString("noiDung"), rs.getString("maThuNgan") == null ? "" : rs.getString("maThuNgan"), 
							rs.getString("maNhanVien") == null ? "" : rs.getString("maNhanVien"), rs.getFloat("giam"), 
							rs.getFloat("thueVAT"), rs.getFloat("phiPV"), 
							rs.getFloat("soTien"), rs.getFloat("traTruoc"), 
							rs.getFloat("conNo"), rs.getString("ngayDat"), 
							rs.getInt("trangThai"));
					return chungTu;
				}
			});
		}else {
			return null;
		}

		
	}

	public String add(ChungTu chungTu) {
		String sql = "INSERT INTO `chung_tu` VALUES "
				+ "(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			int i = jdbcTemplate.update(sql, chungTu.getNgayCT(), chungTu.getLoai(), chungTu.getSoBan(), chungTu.getMaKH(), chungTu.getSoKhach(), chungTu.getNoiDung(), chungTu.getMaThuNgan(), chungTu.getMaNhanVien(), chungTu.getGiam(), chungTu.getThueVAT(), chungTu.getPhiPV(), chungTu.getSoTien(), chungTu.getTraTruoc(), chungTu.getConNo(), chungTu.getNgayDat(), chungTu.getTrangThai());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String update(ChungTu chungTu) {
		String sql = "UPDATE `chung_tu` SET "
				+ "`ngayCT`= ?,`loai`= ?,`soBan`= ?,"
				+ "`maKH`= ?,`soKhach`= ?,`noiDung`= ?,"
				+ "`maThuNgan`= ?,`maNhanVien`= ?,`giam`= ?,"
				+ "`thueVAT`= ?,`phiPV`= ?,`soTien`= ?,"
				+ "`traTruoc`= ?,`conNo`= ?,`ngayDat`= ?,"
				+ "`trangThai`= ? WHERE `soCT`= ?";
		try {
			int i = jdbcTemplate.update(sql, chungTu.getNgayCT(), chungTu.getLoai(), chungTu.getSoBan(), chungTu.getMaKH(), chungTu.getSoKhach(), chungTu.getNoiDung(), chungTu.getMaThuNgan(), chungTu.getMaNhanVien(), chungTu.getGiam(), chungTu.getThueVAT(), chungTu.getPhiPV(), chungTu.getSoTien(), chungTu.getTraTruoc(), chungTu.getConNo(), chungTu.getNgayDat(), chungTu.getTrangThai(), chungTu.getSoCT());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String chuyenBan(int soCT, String soBan) {
		String sql = "UPDATE `chung_tu` SET soBan = ? WHERE `soCT`= ?";
		try {
			int i = jdbcTemplate.update(sql, soBan, soCT);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String huyBan(int soCT) {
		String sql = "UPDATE `chung_tu` SET trangThai = -1 WHERE `soCT`= ?";
		try {
			int i = jdbcTemplate.update(sql, soCT);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String thanhToan(int soCT) {
		if(this.getBySoCT(soCT).getTrangThai() == 0) {
			String sql = "UPDATE `chung_tu` SET trangThai = 1 WHERE `soCT`= ?";
			try {
				int i = jdbcTemplate.update(sql, soCT);
				return i == 1 ? "Thành công" : "Thất bại";
			} catch (Exception e) {
				return "Lỗi phát sinh";
			}
		}else {
			return "Hóa đơn này đã hủy hoặc đã đã thanh toán rồi, nên không thể thanh toán nữa";
		}
	}

	public String update_by_sql(String colum_key, Object value_key, String colum_data, Object value_data) {
		String sql = "UPDATE `chung_tu` SET " + colum_data + " = ? WHERE " + colum_key + "= ?";
		try {
			int i = jdbcTemplate.update(sql, value_data, value_key);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	//1 = thanh toan, -1 la huy, 0 la dang ngoi`
	public boolean checkBan(String maBan, int type) {
		String sql = "SELECT * FROM `chung_tu` WHERE soBan = ? And trangThai = ?";
		SqlRowSet row = jdbcTemplate.queryForRowSet(sql, maBan, type);
		if(row.next()) {
			return true;
		}else {
			return false;
		}
	}

	public float tongTien(int soCT) {
		String sql = "SELECT SUM((dong_chung_tu.donGia - dong_chung_tu.giam) * dong_chung_tu.soLuong) * ((100 - chung_tu.giam) / 100) * ((100 + chung_tu.thueVAT) / 100) as sum FROM dong_chung_tu INNER JOIN chung_tu ON dong_chung_tu.soCT = chung_tu.soCT WHERE dong_chung_tu.soCT = ? and dong_chung_tu.status = 0";
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

}

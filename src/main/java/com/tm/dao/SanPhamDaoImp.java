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

import com.tm.model.SanPham;

@Repository
@Transactional
public class SanPhamDaoImp implements SanPhamDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<SanPham> get() {
		String sql = "SELECT `san_pham`.`maSP`, san_pham.maNhom, san_pham.tenSP, don_vi_tinh.maDVT, don_vi_tinh.tenDVT, san_pham.SLDK, san_pham.GTDK, san_pham.giaVon, san_pham.giaBan, san_pham.giam, san_pham.khongNhap, san_pham.khongXuat, san_pham.isMenu FROM san_pham INNER JOIN don_vi_tinh ON don_vi_tinh.maDVT = san_pham.maDVT";
		return jdbcTemplate.query(sql, new Object[] {}, new RowMapper<SanPham>() {
			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham(
						rs.getString("maSP"), 
						rs.getString("maNhom"), 
						rs.getString("tenSP").toUpperCase(), 
						rs.getString("maDVT").toUpperCase(),
						rs.getString("tenDVT").toUpperCase(), 
						rs.getFloat("SLDK"), 
						rs.getFloat("GTDK"),
						rs.getFloat("giaVon"),
						rs.getFloat("giaBan"),
						rs.getFloat("giam"),
						rs.getInt("khongNhap"),
						rs.getInt("khongXuat"),
						rs.getInt("isMenu")
						);
				return sanPham;
			}
		});
	}

	public List<SanPham> getByMaNhom(String maNhom) {
		String sql = "SELECT `san_pham`.`maSP`, san_pham.maNhom, san_pham.tenSP, don_vi_tinh.maDVT, don_vi_tinh.tenDVT, san_pham.SLDK, san_pham.GTDK, san_pham.giaVon, san_pham.giaBan, san_pham.giam, san_pham.khongNhap, san_pham.khongXuat, san_pham.isMenu FROM san_pham INNER JOIN don_vi_tinh ON don_vi_tinh.maDVT = san_pham.maDVT WHERE san_pham.maNhom = ?";
		return jdbcTemplate.query(sql, new Object[] { maNhom }, new RowMapper<SanPham>() {
			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham(
						rs.getString("maSP"), 
						rs.getString("maNhom"), 
						rs.getString("tenSP").toUpperCase(), 
						rs.getString("maDVT").toUpperCase(),
						rs.getString("tenDVT").toUpperCase(), 
						rs.getFloat("SLDK"), 
						rs.getFloat("GTDK"),
						rs.getFloat("giaVon"),
						rs.getFloat("giaBan"),
						rs.getFloat("giam"),
						rs.getInt("khongNhap"),
						rs.getInt("khongXuat"), 
						rs.getInt("isMenu")
						);
				return sanPham;
			}
		});
	}

	public SanPham getByMaSP(String maSP) {
		String sql = "SELECT `san_pham`.`maSP`, san_pham.maNhom, san_pham.tenSP, don_vi_tinh.maDVT, don_vi_tinh.tenDVT, san_pham.SLDK, san_pham.GTDK, san_pham.giaVon, san_pham.giaBan, san_pham.giam, san_pham.khongNhap, san_pham.khongXuat, san_pham.isMenu FROM san_pham INNER JOIN don_vi_tinh ON don_vi_tinh.maDVT = san_pham.maDVT WHERE san_pham.maSP = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { maSP }, new RowMapper<SanPham>() {
			public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
				SanPham sanPham = new SanPham(
						rs.getString("maSP"), 
						rs.getString("maNhom"), 
						rs.getString("tenSP").toUpperCase(), 
						rs.getString("maDVT").toUpperCase(),
						rs.getString("tenDVT").toUpperCase(), 
						rs.getFloat("SLDK"), 
						rs.getFloat("GTDK"),
						rs.getFloat("giaVon"),
						rs.getFloat("giaBan"),
						rs.getFloat("giam"),
						rs.getInt("khongNhap"),
						rs.getInt("khongXuat"), 
						rs.getInt("isMenu")
						);
				return sanPham;
			}
		});
	}

	public String add(SanPham sanPham) {
		try {
			List<SanPham> resultt = this.get();
			String maSpMoi = "SP_1";
			if(resultt.size() > 0) {
				Collections.sort(resultt, new SanPham());
				
				String[] split = resultt.get(resultt.size() - 1).getMaSP().split("_");
				int sum_split = Integer.valueOf(split[1]) + 1;
				maSpMoi = split[0] + "_" + sum_split;
			}
			
			
			String sql = "INSERT INTO `san_pham` VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			int i = jdbcTemplate.update(sql, 
					maSpMoi, sanPham.getMaNhom(), 
					sanPham.getTenSP(), sanPham.getMaDVT(), 
					sanPham.getSLDK(), sanPham.getGTDK(), 
					sanPham.getGiaVon(), sanPham.getGiaBan(),
					sanPham.getGiam(), sanPham.getKhongNhap(),
					sanPham.getKhongXuat(), sanPham.getIsMenu());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String update(SanPham sanPham) {
		try {
			String sql = "UPDATE `san_pham` SET "
					+ "`maNhom`= ?,`tenSP`= ?,`maDVT`= ?,`SLDK`= ?,`GTDK`= ?,`giaVon`= ?,`giaBan`= ?,`giam`= ?,`khongNhap`= ?,`khongXuat`= ?,`isMenu`= ? WHERE `maSP`= ?";
			int i = jdbcTemplate.update(sql,
					sanPham.getMaNhom(), 
					sanPham.getTenSP(), sanPham.getMaDVT(), 
					sanPham.getSLDK(), sanPham.getGTDK(), 
					sanPham.getGiaVon(), sanPham.getGiaBan(),
					sanPham.getGiam(), sanPham.getKhongNhap(),
					sanPham.getKhongXuat(), sanPham.getIsMenu(), sanPham.getMaSP());
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

	public String del(String maSP) {
		try {
			String sql = "DELETE FROM `san_pham` WHERE maSP = ?";
			int i = jdbcTemplate.update(sql, maSP);
			return i == 1 ? "Thành công" : "Thất bại";
		} catch (Exception e) {
			return "Lỗi phát sinh";
		}
	}

}
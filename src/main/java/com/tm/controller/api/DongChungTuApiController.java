package com.tm.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tm.lib.TimestampCustom;
import com.tm.model.DongChungTu;
import com.tm.model.SanPham;
import com.tm.service.DongChungTuService;
import com.tm.service.SanPhamService;

@Controller
@RequestMapping(value = "/api")
public class DongChungTuApiController {
	
	@Autowired
	DongChungTuService dongChungTuService;
	@Autowired
	SanPhamService sanPhamService;
	
	@RequestMapping(value = "/dongChungTu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String get(HttpServletRequest request) {
		return new Gson().toJson(dongChungTuService.get());
	}
	
	@RequestMapping(value = "/dongChungTu/getById", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getById(@RequestParam(name = "id", required = true) int id) {
		return new Gson().toJson(dongChungTuService.getById(id));
	}
	
	@RequestMapping(value = "/dongChungTu/getBySoCT", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getBySoCT(@RequestParam(name = "soCT", required = true) int soCT) {
		return new Gson().toJson(dongChungTuService.getBySoCT(soCT));
	}
	
	@RequestMapping(value = "/dongChungTu/thanhTien", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String sum(@RequestParam(name = "soCT", required = true) int soCT) {
		return String.valueOf(dongChungTuService.thanhTien(soCT));
	}

	@RequestMapping(value = "/dongChungTu/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String add(
			@RequestParam(name = "soCT", required = true) int soCT,
			@RequestParam(name = "maSP", required = true) String maSP
			) {
		SanPham sanPham = sanPhamService.getByMaSP(maSP);
		if(sanPham == null) {
			return "Sản phẩm này không tồn tại";
		}
		if(dongChungTuService.isSP(soCT, maSP)) {
			//nếu đã có thì chỉ cần update thôi
			dongChungTuService.updateSoLuong(soCT, maSP, 1);
		}else {
			//đây là phai thêm mới @@@
			dongChungTuService.add(
					new DongChungTu(java.sql.Types.INTEGER, soCT, maSP, null, sanPham.getMaDVT(), null, 1, sanPham.getGiaBan(), TimestampCustom.getTimestamp(), null, 0, sanPham.getGiam(), null, 0)
			);
		}
		
		return "Thành công";
	}
	
	@RequestMapping(value = "/dongChungTu/update_by_sql", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update_by_sql(
			@RequestParam(value = "colum_key", required = true) String colum_key,
			@RequestParam(value = "value_key", required = true) Object value_key,
			@RequestParam(value = "colum_data", required = true) String colum_data,
			@RequestParam(value = "value_data", required = true) Object value_data
			) {
		return dongChungTuService.update_by_sql(colum_key, value_key, colum_data, value_data);
	}
	
	@RequestMapping(value = "/dongChungTu/deleteById", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String deleteById(@RequestParam(name = "id", required = true) int id) {
		return dongChungTuService.deleteById(id);
	}
	
}

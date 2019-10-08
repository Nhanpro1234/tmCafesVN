package com.tm.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.tm.model.BoPhan;
import com.tm.service.BoPhanService;

@Controller
@RequestMapping(value = "/api")
public class BoPhanApiController {

	@Autowired
	BoPhanService boPhanService;
	
	@RequestMapping(value = "/boPhan", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String get() {
		return new Gson().toJson(boPhanService.get());
	}
	
	@RequestMapping(value = "/boPhan/getByMaBP", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getByMaBP(@RequestParam(value = "maBP", required = true) String maBP)  {
		return new Gson().toJson(boPhanService.getByMaBP(maBP));
	}
	
	@RequestMapping(value = "/boPhan/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String add(@RequestParam("maCha") String maCha, @RequestParam("tenBP") String tenBP) {
		return boPhanService.add(new BoPhan(null, maCha.equals("0") ? null : maCha, tenBP));
	}
	
	@RequestMapping(value = "/boPhan/update", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String update(@RequestParam("maBP") String maBP, 
									@RequestParam("maCha") String maCha, 
									@RequestParam("tenBP") String tenBP) {
		return boPhanService.update(new BoPhan(maBP, maCha.equals("null") ? null : maCha, tenBP));
	}
	
	@RequestMapping(value = "/boPhan/delete", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String delete(@RequestParam("maBP") String maBP) {
		return boPhanService.delete(maBP);
	}
	
	@RequestMapping(value = "/boPhan/isMaBP", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String isMaBP(@RequestParam("maBP") String maBP) {
		return boPhanService.isMaBP(maBP) ? "true" : "false";
	}
	
	@RequestMapping(value = "/boPhan/isMaCha", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String isMaCha(@RequestParam("maCha") String maCha) {
		return boPhanService.isMaCha(maCha) ? "true" : "false";
	}
	
	@RequestMapping(value = "/boPhan/deleteByMaCha", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String deleteByMaCha(@RequestParam("maCha") String maCha) {
		return boPhanService.deleteByMaCha(maCha);
	}

	@RequestMapping(value = "/boPhan/moveBoPhan", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String moveBoPhan(@RequestParam("maBP") String maBP, @RequestParam("maCha") String maCha) {
		return boPhanService.moveBoPhan(maBP, maCha.equals("0") ? null : maCha);
	}
}

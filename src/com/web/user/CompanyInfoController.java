package com.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Json;
import com.service.user.CompanyInfoService;

@Controller
@RequestMapping("/company")
public class CompanyInfoController {
	
	@Autowired
	private CompanyInfoService service;

	@RequestMapping(value="/add")
	@ResponseBody
	public Json add(){
		Json json = new Json();
		json.setMsg("test");
		boolean flag = false;
		try {
			service.insertCompanyInfo(null);
			flag =true;
		} catch (Exception e) {
			flag = false;
		}
		
		json.setSuccess(flag);
		return json;
	}
}

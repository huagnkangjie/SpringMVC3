package com.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Json;
import com.service.user.CompanyInfoService;

@Controller
@RequestMapping("/main")
public class IndexController {
	
	@Autowired
	private CompanyInfoService service;

	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String index(HttpServletRequest request, Model model, String pages){
		if(pages.equals("index")){
			List<Map<String,Object>> list = service.getAll(null);
			model.addAttribute("infoList", list);
		}
		return pages;
	}
	
	@RequestMapping("/abort")
	@ResponseBody
	public Json abort(){
		Json json = new  Json();
		try {
			for (int i = 1; i < 10; i++) {
				System.out.println(">>>>>>>> "+i);
				Thread.sleep(1000 * 1);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return json;
	}
}

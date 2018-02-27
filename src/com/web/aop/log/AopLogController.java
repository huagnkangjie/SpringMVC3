package com.web.aop.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Json;
import com.service.user.IUserService;

@RequestMapping("/aop")
@Controller
public class AopLogController {
	
	@Autowired
	private IUserService service;

	/**
	 * 日志
	 * @return
	 */
	@RequestMapping("/log")
	@ResponseBody
	public Json aopLog(){
		Json json = new Json ();
		try {
			service.deleteUser(0);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return json;
		}
	}
}

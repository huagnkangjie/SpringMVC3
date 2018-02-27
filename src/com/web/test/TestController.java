package com.web.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Json;
import com.pojo.User;

@RequestMapping("/test")
@Controller
public class TestController {

	
	/*@RequestMapping(value = "/v1", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json")
	@ResponseBody
	public Json test(HttpServletRequest request,
			 @RequestBody User user){
		Json json = new Json();
		json.setMsg("成功");
		json.setObj(user);
		return json;
	}*/
	
	@RequestMapping(value="/v1")
    @ResponseBody
    public User testConverter(@RequestBody User  user,Token token, String qq)
    {
		System.out.println(">>>>>>>>>>>> qq " + qq);
        return user;       
    }
}

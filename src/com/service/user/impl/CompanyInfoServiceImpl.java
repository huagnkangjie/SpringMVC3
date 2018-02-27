package com.service.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.user.CompanyInfoDao;
import com.service.user.CompanyInfoService;

@Service("companyInfoService")
@Transactional
public class CompanyInfoServiceImpl implements CompanyInfoService{

	@Autowired
	private CompanyInfoDao dao;
	
	@Override
	public List<Map<String, Object>> getAll(Map<String, Object> map) {
		return dao.getAll(map);
	}

	@Override
	@Transactional
	public boolean insertCompanyInfo(Map<String,Object> map){
		Map<String,Object> maps = new HashMap<String,Object>();
		boolean flag = true;
			for (int i = 10000; i < 10005; i++) {
//				if(i == 10004){
//					i = 1;
//					flag = false;
//				}
				maps.clear();
				maps.put("id", i);
				maps.put("entName", i);
				dao.insertCompanyInfo(maps);
				System.out.println(">>>>>>>>>>  增加一条");
				
			}
			return flag;
		
		
	}

}

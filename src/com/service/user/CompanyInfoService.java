package com.service.user;

import java.util.List;
import java.util.Map;

public interface CompanyInfoService {
	
	public List<Map<String,Object>> getAll(Map<String,Object> map);
	
	public boolean insertCompanyInfo(Map<String,Object> map);
}

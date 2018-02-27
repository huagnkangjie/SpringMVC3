package com.service.user;

import com.pojo.User;

public interface IUserService {
	public void saveUser(User user);  
    
	   public void deleteUser(int id);  
	     
	   public void updateUser(int id);
}

package com.dao.user;

import com.pojo.User;

public interface IUserDAO {

	public void addUser(User user);  
    
    public void deleteUser(int id);  
      
    public void updateUser(int id); 
}

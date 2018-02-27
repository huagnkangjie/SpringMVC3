package com.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.user.IUserDAO;
import com.pojo.User;
import com.service.user.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
		@Autowired
	    private IUserDAO userDAO;  
	      
	    public void setUserDAO(IUserDAO userDAO) {  
	        this.userDAO = userDAO;  
	    }  
	      
	    @Override  
	    public void deleteUser(int id) { 
	    	System.out.println("----deleteUser----"); 
	        userDAO.deleteUser(id);  
	    }  
	  
	    @Override  
	    public void saveUser(User user) {  
	        userDAO.addUser(user);  
	  
	    }  
	  
	    @Override  
	    public void updateUser(int id) {  
	        userDAO.updateUser(id);  
	    } 
}

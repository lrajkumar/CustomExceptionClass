package com.codedecode.microservices.EurekaServer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
	@Autowired
	UserDao userdao;
	
	public String addallusers(List<User> u) {
    	return userdao.addallusers(u);
    }
	
	
	
	public List<User> getUser() {
   List<User>use =userdao.getUser();
   return use;
}

	
	public User getUserId(int id) {
		   User use1 = userdao.getUserId(id);
		   return use1;
		}

	
	
	
	
	
	public String deleteInformation() {
		return userdao.deleteInformation();
	
	}
	
	
}

package com.codedecode.microservices.EurekaServer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class UserDao {
	@Autowired
	UserRepository userrepository;
	
	/*	public List<Employee> getBySal(int sal1,int sal2){
	 return emprepo.getBySal(sal1,sal2);
	  }*/
	
	public String addallusers(List<User> u) {
		for(User i:u) {
			userrepository.save(i);
		}
    	return "Data saved";
    }
	
	
	
	public List<User> getUser() {
		List<User>use=userrepository.findAll();
			return use;
		}
	
	
	public User getUserId(Integer id) {
		return userrepository.findById(id).get();	 
		}
	
	 public String deleteInformation() {
		 userrepository.deleteAll();
	 
		  return "Data has been deleted";
	  }
	
	
}

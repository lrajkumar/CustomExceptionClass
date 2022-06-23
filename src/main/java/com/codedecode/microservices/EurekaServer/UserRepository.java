package com.codedecode.microservices.EurekaServer;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

	//List<User> getUser();



}

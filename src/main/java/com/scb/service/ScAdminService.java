package com.scb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scb.entity.AdminCredentails;
import com.scb.repository.ScAdminRepo;

@Transactional
@Service
public class ScAdminService {

	@Autowired
	private ScAdminRepo adminRepo;
	
	public AdminCredentails showDetails(String username) {
		AdminCredentails userDetails=adminRepo.findByusername(username);
		return userDetails;
	}
	
	
	public boolean authenticate(String username,String password) {
		System.out.println("in ScAdminService- authenticate method1");
		boolean status=true;
		if(username!=null && password!=null) {
			System.out.println("in ScAdminService- authenticate method if username and password not null");
			
			System.out.println(username+"---------- "+password);
			AdminCredentails user=adminRepo.findByusername(username);
			System.out.println("inservice class"+user.getU_id()+""+user.getUsername()+"==="+user.getRole()+"---"+user.getMobno()+"========"+user.getU_id()+"---------"+user.getLastlogin());

			System.out.println("in ScAdminService- authenticate method sucess");
			status=user!=null && user.getPassword().equals(password);
			return status;
		}
		return false;
	}
	
}

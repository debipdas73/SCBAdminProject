package com.scb.service;

import java.util.Date;
import java.util.Random;

import javax.persistence.EntityNotFoundException;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.commonMethod;
import com.scb.entity.ScAdminAccount;
import com.scb.repository.ScAdminActRepo;

@Service
@Transactional
public class ScAdminActService {
	
	@Autowired
	private ScAdminActRepo adminActivityService;
	
	public ScAdminAccount addUser(ScAdminAccount newUser) {
		Random random=new Random();
		Date sysDate=commonMethod.sysDate();
		long milliseconds=sysDate.getDate();
    	long userId=random.nextInt(9000)+1000;
    	newUser.setUser_id(userId);	
    	newUser.setUserStatus("ENABLE");
    	newUser.setUserCode((int)milliseconds/1000);
    	System.out.println(" inside ScAdminActService- addUser method User creataion date"+(int)milliseconds/1000);
    	
		System.out.println("inside ScAdminActService- addUser method"+userId+"usercreated.");
		return adminActivityService.save(newUser);
	}
	public List<ScAdminAccount> showUsers(){
	
		List<ScAdminAccount> usersList=adminActivityService.findAll();
		
	System.out.println("inside ScAdminActService- showUsers "+usersList.size());
		return usersList;
	}
	
	public ScAdminAccount updateUser(Long user_id,ScAdminAccount updateExtUser) {
		Optional<ScAdminAccount> checkUser=adminActivityService.findById(user_id);
		System.out.println("inside ScAdminActService- updateUser "+checkUser.get());
		if(checkUser.isPresent()) {
			ScAdminAccount user=checkUser.get();
			user.setName(updateExtUser.getName());
			user.setEmail(updateExtUser.getEmail());
			user.setMobile_no(updateExtUser.getMobile_no());
			user.setCity(updateExtUser.getCity());
			return adminActivityService.save(user);
		}else {
			System.out.println("inside ScAdminActService- updateUser error");
			return null;
			
		}
	
	}
	
	public boolean removeUser(Long user_id) {
		Optional<ScAdminAccount> checkUser=adminActivityService.findById(user_id);
		System.out.println("inside ScAdminActService- removeUser "+checkUser.get());
		if(checkUser.isPresent()) {
			ScAdminAccount user=checkUser.get();
			System.out.println("inside ScAdminActService- removeUser true");
			adminActivityService.delete(checkUser.get());
			return true;
		}else {
			System.out.println("inside ScAdminActService- removeUser false");
			return false;
			
		}
	}
	public Optional<ScAdminAccount> getUserById(Long user_id) {
		System.out.println("inside ScAdminActService- getUserById "+user_id);
        return adminActivityService.findById(user_id);
    }
	public ScAdminAccount updateUserStatus(Long user_id, String userStatus) {
		ScAdminAccount user = adminActivityService.findById(user_id).orElse(null);
		System.out.println("inside ScAdminActService- updateUserStatus--- "+user_id);
        if (user != null) {
            user.setUserStatus(userStatus);
            return adminActivityService.save(user);
        }
        return null; 
    }
	public void updateUserDetails(Long userId, ScAdminAccount request) {
		System.out.println("inside ScAdminActService- updateUserDetails--&&&&- "+userId);
        Optional<ScAdminAccount> optionalUser = adminActivityService.findById(userId);
        if (optionalUser.isPresent()) {
        	ScAdminAccount user = optionalUser.get();
            // Update user details with the values from the request
            if (request.getName() != null) {
                user.setName(request.getName());
            }
            if (request.getEmail() != null) {
                user.setEmail(request.getEmail());
            }
            if(request.getUsername() !=null) {
            	user.setUsername(request.getUsername());
            }
            if(request.getMobile_no() !=0) {
            	user.setMobile_no(request.getMobile_no());
            }
           if(request.getCity() !=null) {
        	   user.setCity(request.getCity());
           }
           if(request.getUserRole() !=null) {
        	   user.setUserRole(request.getUserRole());
           }
            adminActivityService.save(user);
        } else {
            throw new EntityNotFoundException("User with ID " + userId + " not found");
        }
    }
}


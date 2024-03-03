package com.scb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.scb.entity.ScAdminAccount;
import com.scb.service.ScAdminActService;
import com.scb.service.ScAdminService;

@Controller
public class UserController {

	@Autowired
	private ScAdminService adminService;
	
	@Autowired
    private ScAdminActService adminAccountService;
	
	@GetMapping("/")
	public String loginPage() {
		return "/login";
	}

	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	@GetMapping("/adminMenuHome")
	public String adminHome() {
		return "adminMenuHome";
	}
	
	@GetMapping("/editUserForm")
	public String editUser() {
		return "editUserForm";
	}
	
	  @PostMapping("/logout")
	  public String logout(HttpServletRequest request) {
			 HttpSession session=request.getSession(false);
			 System.out.println("Logout****************************"+session);
			 if (session != null) 
			 session.invalidate();
				 return "/login";
			 //}
		        //return null;
	  }
	 
	
	/*
	 * @GetMapping("api/users") public String getUsers(Model model) {
	 * List<ScAdminAccount> users=adminAccountService.showUsers();
	 * model.addAttribute("users", users); return "user-list"; }
	 */


}

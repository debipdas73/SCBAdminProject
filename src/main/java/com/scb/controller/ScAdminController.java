package com.scb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.common.SessionExpire;
import com.scb.entity.AdminCredentails;
import com.scb.service.ScAdminService;

@RestController
@RequestMapping("/api")
public class ScAdminController {

	@Autowired
	private ScAdminService adminService;

	/*
	 * @PostMapping("/login") public ResponseEntity<String> login(@RequestBody
	 * AdminCredentails user) { String username = user.getUsername(); String
	 * password = user.getPassword();
	 * 
	 * AdminCredentails userDetails=adminService.showDetails(username);
	 * 
	 * String userRole= userDetails.getRole();
	 * System.out.println("userRole----"+userRole);
	 * 
	 * boolean isAuthenticated = adminService.authenticate(username, password);
	 * System.out.println("isAuthenticated status---" + isAuthenticated); if
	 * (isAuthenticated) { String sessionToken =
	 * SessionExpire.generateSessionToken(username); // Calculate session expiration
	 * time long expirationTimeMillis = SessionExpire.calculateExpirationTime();
	 * 
	 * 
	 * System.out.println("userRole----"+userRole);
	 * System.out.println("in ScAdminController login method- Successfully response"
	 * ); if(userRole.equalsIgnoreCase("ADMIN")) { return
	 * ResponseEntity.ok("adminMenuHome"); }else { return ResponseEntity.ok("home");
	 * }
	 * 
	 * } else {
	 * System.out.println("in ScAdminController login method- wrong/error response"
	 * ); String errorMessage = "Invalid username or password";
	 * ResponseEntity<String> responseEntity =
	 * ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage); HttpStatus
	 * statusCode = responseEntity.getStatusCode();
	 * System.out.println("status code---"+statusCode); if (statusCode ==
	 * HttpStatus.UNAUTHORIZED) {
	 * 
	 * System.out.println("Authentication failed: " + responseEntity.getBody()); }
	 * else { System.out.println("Unexpected response status: " + statusCode); }
	 * 
	 * //return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
	 * body("Invalid username or password"); return responseEntity; } }
	 */
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AdminCredentails user) {
		Map<String, Object> response = new HashMap<>();
		List<Object> response1 = new ArrayList<>();
		String username = user.getUsername();
		String password = user.getPassword();

		AdminCredentails userDetails = adminService.showDetails(username);
		String userRole = userDetails.getRole();
		System.out.println("userRole----" + userRole);

		boolean isAuthenticated = adminService.authenticate(username, password);
		System.out.println("isAuthenticated status---" + isAuthenticated);
		if (isAuthenticated) {
			// Generate session token
			String sessionToken = SessionExpire.generateSessionToken(username);
			// Calculate session expiration time
			long expirationTimeMillis = SessionExpire.calculateExpirationTime();

			System.out.println("userRole----" + userRole);
			System.out.println("in ScAdminController login method- Successfully response");
			if (userRole.equalsIgnoreCase("ADMIN")) {
				System.out.println("inside admin********");
				response.put("role", "adminMenuHome");
				response1.add("adminMenuHome");
			} else {
				response.put("role", "home");
				response1.add("home");
			}
			response.put("sessionToken", sessionToken);
			response.put("expirationTimeMillis", expirationTimeMillis);
			// response1.add(sessionToken);
			// response1.add(expirationTimeMillis);

			return ResponseEntity.ok(response1);
		} else {
			System.out.println("in ScAdminController login method- wrong/error response");
			String errorMessage = "Invalid username or password";
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
		}
	}

	/*
	 * @PostMapping("/api/logout") public ResponseEntity<String> logout() { //
	 * Invalidate session or perform logout logic here // For example, you can clear
	 * session attributes or invalidate the session
	 * 
	 * // Assuming logout is successful, redirect to the login page return
	 * ResponseEntity.status(HttpStatus.FOUND) .header(HttpHeaders.LOCATION,
	 * "/login.html") .body(""); }
	 */
	
	/*
	 * @PostMapping("/api/logout") public String logout(HttpServletRequest request)
	 * { HttpSession session=request.getSession(false);
	 * System.out.println("Logout****************************"); if (session !=
	 * null) { session.invalidate(); return "redirect:/login"; } return null; }
	 */
	
	/*
	 * @PostMapping("/api/logout") public
	 * ResponseEntity<String>logout(HttpServletRequest request) { HttpSession
	 * session =request.getSession(false); // Retrieve the session, if it exists
	 * System.out.println("Logout****************************"); // if (session
	 * !=null) { // session.invalidate(); // Invalidate the session //} return
	 * ResponseEntity.ok("Logout successful"); }
	 */
	 
	/*
	 * @PostMapping("/api/logout") public String logout(HttpServletRequest request)
	 * { // Invalidate session
	 * System.out.println("Logout****************************"); HttpSession session
	 * = request.getSession(false); if (session != null) { session.invalidate();
	 * return "Logout successful"; } else { return "Session not found"; } }
	 */
	 
}

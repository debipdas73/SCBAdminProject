package com.scb.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scb.entity.ScAdminAccount;
import com.scb.service.ScAdminActService;

@RestController
public class ScAdminActivityController {

    @Autowired
    private ScAdminActService adminAccountService;

    @PostMapping("/admin/create")
    public ResponseEntity<String> createAdminAccount(@RequestBody ScAdminAccount adminAccount) {
        try {
            ScAdminAccount createdAdminAccount = adminAccountService.addUser(adminAccount);
            if (createdAdminAccount != null) {
                return ResponseEntity.ok("Admin account created successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                     .body("Failed to create admin account");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error creating admin account: " + e.getMessage());
        }
    }
   @GetMapping("/api/users")
    public ResponseEntity<List<ScAdminAccount>> fetchUsersdetails(){
    	List<ScAdminAccount> users=adminAccountService.showUsers();
    	System.out.println("inside ScAdminActivityController- fetchUserDetails method "+users.size());
		return new ResponseEntity<>(users,HttpStatus.OK);
    	
    }
   @GetMapping("/api/users/details")
   public ResponseEntity<List<ScAdminAccount>> fetchUsersToUpdate(){
   	List<ScAdminAccount> usersDetails=adminAccountService.showUsers();
   	System.out.println("inside ScAdminActivityController- fetchUsersToUpdate method "+usersDetails.size());
		return new ResponseEntity<>(usersDetails,HttpStatus.OK);
   	
   }
   
   @GetMapping("/api/users/getUser/{userId}")
   public ResponseEntity<?> getUserById(@PathVariable Long userId) {
	   System.out.println("inside ScAdminActivityController getUserById "+userId);
       try {
    	   System.out.println("inside ScAdminActivityController getUserById 1-"+userId);
           Optional<ScAdminAccount> userOptional = adminAccountService.getUserById(userId);
           System.out.println("inside ScAdminActivityController getUserById 2-"+userId);
           System.out.println("inside ScAdminActivityController getUserById 4-"+userOptional.get());
           if (userOptional.isPresent()) {
        	   System.out.println("inside ScAdminActivityController getUserById 3-"+userId);
               return ResponseEntity.ok(userOptional.get());
           } else {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           }
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching user details: " + e.getMessage());
       }
   }
   
   @PutMapping("api/users/update/{userId}")
   public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody ScAdminAccount user) {
       try {
    	  adminAccountService.updateUserDetails(userId, user);
    	  System.out.println("in ScAdminActivityController updateUser---done for "+userId);
           
               return ResponseEntity.ok("User updated successfully");
          
               //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
           
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user: " + e.getMessage());
       }
   }
   

   @DeleteMapping("/api/users/remove/{userId}")
   public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
       try {
           
           boolean isDeleted = adminAccountService.removeUser(userId);
           if (isDeleted) {
               return ResponseEntity.ok("User deleted successfully");
           } else {
               return ResponseEntity.notFound().build(); // User not found
           }
       } catch (Exception e) {
           return ResponseEntity.internalServerError().body("Error deleting user: " + e.getMessage());
       }
   }
   
   @PostMapping("api/users/updateStatus")
   public String updateUserStatus(@RequestParam Long userId, @RequestParam String userStatus) {
	   System.out.println("inside ScAdminActivityController updateUserStatus method"+userId+"--"+userStatus);

	   try {
    	   ScAdminAccount updatedUser = adminAccountService.updateUserStatus(userId, userStatus);
           if (updatedUser != null) { System.out.println("inside ScAdminActivityController updateUserStatus method"+userId+" User updated successfully");
               return "User updated successfully";
           } else {
               return "User not found";
           }
       } catch (Exception e) {
           return "Error updating user: " + e.getMessage();
       }
   }
	/*
	 * @PostMapping("/admin/update") public ResponseEntity<String>
	 * updateAdminAccount(@RequestBody ScAdminAccount adminAccount) { try {
	 * ScAdminAccount updatedAdminAccount =
	 * adminAccountService.updateAdminAccount(adminAccount); if (updatedAdminAccount
	 * != null) { return ResponseEntity.ok("Admin account updated successfully"); }
	 * else { return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	 * .body("Failed to update admin account"); } } catch (Exception e) { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	 * .body("Error updating admin account: " + e.getMessage()); } }
	 */}

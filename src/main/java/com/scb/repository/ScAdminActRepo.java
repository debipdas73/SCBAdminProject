package com.scb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.entity.ScAdminAccount;

public interface ScAdminActRepo extends JpaRepository<ScAdminAccount, Long>{
	
	// Save / Update
    ScAdminAccount save(ScAdminAccount adminAccount);
    
   // List<ScAdminAccount> saveAll(Iterable<ScAdminAccount> adminAccounts);
    
    // Find / Read
   // Optional<ScAdminAccount> findById(Long id);
    List<ScAdminAccount> findAll();
    List<ScAdminAccount> findAllById(Iterable<Long> ids);
    long count();
    boolean existsById(Long id);
    
    // Delete
   // void deleteById(Long id);
    
    void delete(ScAdminAccount adminAccount);
    
   // void deleteAll(Iterable<ScAdminAccount> adminAccounts);
    
    void deleteAll();
    
    // Custom Query Methods
    List<ScAdminAccount> findByUsername(String username);
	

}

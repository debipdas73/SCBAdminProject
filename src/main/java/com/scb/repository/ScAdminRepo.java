package com.scb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scb.entity.AdminCredentails;

@Repository
public interface ScAdminRepo extends JpaRepository<AdminCredentails,Long>{
	AdminCredentails findByusername(String username);
}

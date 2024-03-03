package com.scb.web;

import java.time.Duration;
import java.time.Instant;

public class SessionManager {
    // Duration for session expiration (e.g., 30 minutes)
    private static final long SESSION_DURATION_MINUTES = 30;
    
    // Method to calculate session expiration time
    public static long calculateExpirationTime() {
        // Get current time
        Instant currentTime = Instant.now();
        
        // Calculate session duration in seconds
        long sessionDurationSeconds = SESSION_DURATION_MINUTES * 60;
        
        // Add session duration to current time to get expiration time
        Instant expirationTime = currentTime.plus(Duration.ofSeconds(sessionDurationSeconds));
        
        // Return expiration time as UNIX timestamp (milliseconds)
        return expirationTime.toEpochMilli();
    }
    
	/*
	 * public static void main(String[] args) { // Calculate session expiration time
	 * long expirationTimeMillis = calculateExpirationTime();
	 * System.out.println("Session expiration time: " + expirationTimeMillis); }
	 */
}


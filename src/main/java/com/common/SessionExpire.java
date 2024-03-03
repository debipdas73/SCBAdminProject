package com.common;
import com.scb.web.*;
import java.time.Instant;

public class SessionExpire {
	
	 public static String generateSessionToken(String username) {
	        // Simulated session token generation logic (replace with your actual token generation logic)
	        return "SESSION_TOKEN_" + username;
	    }

	    public static long calculateExpirationTime() {
	        // Get current time
	        Instant currentTime = Instant.now();
	        // Calculate session duration in seconds
	        long sessionDurationSeconds = SessionManager.calculateExpirationTime() * 60;
	        // Add session duration to current time to get expiration time
	        Instant expirationTime = currentTime.plusSeconds(sessionDurationSeconds);
	        // Return expiration time as UNIX timestamp (milliseconds)
	        return expirationTime.toEpochMilli();
	    }

}

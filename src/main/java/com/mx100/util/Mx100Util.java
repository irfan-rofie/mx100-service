package com.mx100.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Mx100Util {
	
	public static Boolean isAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication() != null;
	}

	public static String getUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}

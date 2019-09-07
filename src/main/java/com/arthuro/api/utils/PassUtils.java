package com.arthuro.api.utils;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassUtils {
	
	public static String generate(String pass) {
		if (pass==null) {
			return pass;
		}
	//	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return null; //encoder.encode(pass);
	}
	
	public static boolean passValid(String pass, String passEncoded) {
	//	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return true;// encoder.matches(pass, passEncoded);
	}
	
//	<dependency>
//	<groupId>org.springframework.boot</groupId>
//	<artifactId>spring-boot-starter-security</artifactId>
//  </dependency>	
}

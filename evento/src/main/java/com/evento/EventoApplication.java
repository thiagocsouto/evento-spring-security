
package com.evento; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

public class EventoApplication {

	public static void main(String[] args) { 
		SpringApplication.run(EventoApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}        
      
}  

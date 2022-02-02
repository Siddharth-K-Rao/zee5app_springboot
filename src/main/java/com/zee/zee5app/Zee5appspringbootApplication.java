package com.zee.zee5app;

import java.math.BigDecimal;

import javax.naming.InvalidNameException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidContactNumberException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.UserService;


@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =  
				SpringApplication.run(Zee5appspringbootApplication.class, args);
		
		UserService service = applicationContext.getBean(UserService.class);
		
		Register registerNew = null;
		try {
			registerNew = new Register("sid0012", "Siddharth", "K Rao", "siddrao12@gmail.com", "12345", new BigDecimal("8123333693"));			
			System.out.println(service.addUser(registerNew));
		} 
		catch (InvalidNameException | InvalidIdLengthException | InvalidEmailException | InvalidPasswordException | InvalidContactNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		applicationContext.close();
		
	}

}

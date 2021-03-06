package com.zee.zee5app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.zee.zee5app.utils.PasswordUtils;


@Configuration // It is used to mark on config class/classes
// Here, we hold all commonly required objects
//@ComponentScan("com.zee.zee5app")
//@PropertySource("classpath:application.properties") // It is responsible for reading the property files

public class Config {
 
	@Autowired // Will bring the already created objects based on the name(reference name) / type
	Environment environment; // This impl object is prepared by spring
	// Do we need to inject the already created object? Yes ===> DI ===> IoC
	// Config: DB related, reading prop file, commonly required beans(passwordEncoder)
	
//	@Bean(name = "ds") // For providing the singleton object
//	@Scope("singleton") // ---> If you call getBean method N times, we get N objects
//	// Scope is used to get multiple objects (scope --> prototype)
//	// If we will not specify the bean name, then it will take / consider the method name as bean name
//	public DataSource dataSource() {
//		
//		BasicDataSource basicDataSource = new BasicDataSource();
//		
//		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
//		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
//		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
//		basicDataSource.setInitialSize(5);
//		basicDataSource.setDefaultAutoCommit(false);
//		
//		return basicDataSource;
//	}
	
	@Bean // Advantage of using Bean, we can initialize as per the requirements
	public PasswordUtils passwordUtils() {
		return new PasswordUtils();
	}
	
}

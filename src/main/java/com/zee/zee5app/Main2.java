package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;

public class Main2 {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);
		
		
		UserService userService = applicationContext.getBean(UserService.class);
		RoleService roleService = applicationContext.getBean(RoleService.class);
		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
		SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
		
		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
		
		

//		Role role = new Role();
//		role.setRoleName(EROLE.ROLE_ADMIN);
//
//		Role role2 = new Role();
//		role2.setRoleName(EROLE.ROLE_USER);
		
//		System.out.println(roleService.addRole(role));
//		System.out.println(roleService.addRole(role2));
		
		
		
		Register addRegister = null;
		addRegister = new Register("sid0015", "Siddharth", "K Rao", "siddrao15@gmail.com", "12345678",
				new BigDecimal("8123333693"), null, null);
		
		Set<Role> roles = new HashSet<Role>();
		roles.add(roleRepository.findById(1).get());
		roles.add(roleRepository.findById(2).get());
		addRegister.setRoles(roles);
		
		try {
			System.out.println(userService.addUser(addRegister));
		} 
		catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Subscription subscription1 = null;
		subscription1 = new Subscription("sub0010", "2022-02-02", "2023-02-02", "DEBIT", "ACTIVE", 
				"YEARLY", true, 499f, addRegister);
		
		System.out.println(subscriptionService.addSubscription(subscription1));
		
		
//		List<Episodes> episodeList = new ArrayList<Episodes>();
//		episodeList.add(null);
//		
//		Series series1 = null;
//		series1 = new Series("ser0011", "The Office", "Comedy", "2023-04-01", "English", "Steve Carell, Rainn", 10, 18,
//				"https://www.youtube.com/watch?v=eoIO5-O2Qvk", episodeList);
//		
//		//System.out.println(seriesService.addSeries(series1));
//		
//		Episodes episode1 = null;
//		episode1 = new Episodes("epi0010", "Pilot", 1270f, "California", "Trailer", series1);
//		
//		episodeService.addEpisodes(episode1);
		
		
		applicationContext.close();

	}

}

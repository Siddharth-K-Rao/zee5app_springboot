package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidContactNumberException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.InvalidUsernameException;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);

		UserService userService = applicationContext.getBean(UserService.class);
		SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
		LoginService loginService = applicationContext.getBean(LoginService.class);
		MovieService movieService = applicationContext.getBean(MovieService.class);
		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);

		// *************************** REGISTER *************************
		Register addRegister = null;
		addRegister = new Register("sid0012", "Siddharth", "K Rao", "siddrao12@gmail.com", "12345678",
				new BigDecimal("8123333693"));

		// Adding user
		System.out.println(userService.addUser(addRegister));

		// Getting user by ID
		try {
			Optional<Register> optional1 = userService.getUserById("sid0011");
			System.out.println(optional1.get());
		} 
		catch (InvalidNameException | IdNotFoundException | InvalidIdLengthException | InvalidEmailException
				| InvalidContactNumberException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Getting all users
		try {
			Optional<List<Register>> optional2 = userService.getAllUserDetails();
			System.out.println(optional2.get());
		} 
		catch (InvalidNameException | InvalidIdLengthException | InvalidEmailException | InvalidContactNumberException
				| InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Deleting a user
		try {
			System.out.println(userService.deleteUserById("sid0012"));
		} 
		catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// *************************** SUBSCRIPTION *********************
		Subscription addSubscription = null;
		addSubscription = new Subscription("sub0012", "2022-01-03", "2023-01-03", "CREDIT", "ACTIVE", "YEARLY", true,
				"sid0012", 499f);

		// Adding subscription
		System.out.println(subscriptionService.addSubscription(addSubscription));

		// Getting subscription by ID
		try {
			Optional<Subscription> optional3 = subscriptionService.getSubscriptionById("sub0011");
			System.out.println(optional3.get());
		} 
		catch (IdNotFoundException | InvalidIdLengthException | InvalidAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Getting all subscriptions
		try {
			Optional<List<Subscription>> optional4 = subscriptionService.getAllSubscriptions();
			System.out.println(optional4.get());
		} 
		catch (InvalidIdLengthException | InvalidAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Deleting a user
		try {
			System.out.println(subscriptionService.deleteSubscription("sub0012"));
		} 
		catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		// *************************** LOGIN *********************
		Login addLogin = null;
		addLogin = new Login("siddrao12@gmail.com", "12345678", "sid0012", null);

		// Adding login details
		System.out.println(loginService.addCredentials(addLogin));
		
		// Delete credentials
		try {
			System.out.println(loginService.deleteCredentials("siddrao12@gmail.com"));
		} 
		catch (IdNotFoundException | InvalidUsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		// *************************** MOVIES *********************
		Movies addMovie = null;
		addMovie = new Movies("mov0012", "Goodfellas", "Crime", "2022-08-04", "English", "wxyz", 2400f, 21,
				"https://www.youtube.com/watch?v=Rt_UqUm38BI");

		// Adding movie
		System.out.println(movieService.addMovie(addMovie));
		
		// Getting movie details by ID
		try {
			Optional<Movies> optional5 = movieService.getMovieById("mov0011");
			System.out.println(optional5.get());
		} 
		catch (InvalidNameException | IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Getting all movie details
		try {
			Optional<List<Movies>> optional6 = movieService.getAllMovies();
			System.out.println(optional6.get());
		} 
		catch (InvalidNameException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Deleting a movie
		try {
			System.out.println(movieService.deleteMovie("mov0012"));
		} 
		catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// *************************** SERIES *********************
		Series addSeries = null;
		addSeries = new Series("ser0012", "lmnopq", "Drama", "2023-03-01", "Hindi", "rstu", 10, 18,
				"https://www.youtube.com/watch?v=eoIO5-O2Qvk");

		// Adding series
		System.out.println(seriesService.addSeries(addSeries));
		
		// Getting series details by ID
		try {
			Optional<Series> optional7 = seriesService.getSeriesById("ser0011");
			System.out.println(optional7.get());
		} 
		catch (InvalidNameException | IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Getting all series details
		try {
			Optional<List<Series>> optional8 = seriesService.getAllSeries();
			System.out.println(optional8.get());
		} 
		catch (InvalidNameException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Deleting series details
		try {
			System.out.println(seriesService.deleteSeries("ser0012"));
		} 
		catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		// *************************** EPISODES *********************
		Episodes addEpisodes = null;
		addEpisodes = new Episodes("epi0012", "ser0012", "qwert", 1500f, "yuiop",
				"https://www.youtube.com/watch?v=af0GMFIlb4Q");

		// Adding episodes
		System.out.println(episodeService.addEpisodes(addEpisodes));
		
		// Getting details of episode by ID
		try {
			Optional<Episodes> optional9 = episodeService.getEpisodeDetailsById("epi0011");
			System.out.println(optional9.get());
		} 
		catch (InvalidNameException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Getting all episode details
		try {
			Optional<List<Episodes>> optional10 = episodeService.getAllEpisodeDetails();
			System.out.println(optional10.get());
		} 
		catch (InvalidNameException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Deleting details of an episode
		try {
			System.out.println(episodeService.deleteEpisodes("epi0012"));
		} 
		catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		applicationContext.close();

	}

}

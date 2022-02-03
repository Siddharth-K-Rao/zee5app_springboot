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
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidContactNumberException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.InvalidUsernameException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.UserRepository;
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

		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		MovieRepository movieRepository = applicationContext.getBean(MovieRepository.class);
		SeriesRepository seriesRepository = applicationContext.getBean(SeriesRepository.class);
		
		
		
		// *************************** REGISTER *************************
		System.out.println("*************************** REGISTER *********************");
		Register addRegister = null;
		addRegister = new Register("sid0012", "Siddharth", "K Rao", "siddrao12@gmail.com", "12345678",
				new BigDecimal("8123333693"), null, null);

		// Adding user
		System.out.println("Adding user: ");
		try {
			System.out.println(userService.addUser(addRegister));
		} 
		catch (AlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println();

		// Getting user by ID
		System.out.println("Getting user by ID");
		try {
			Optional<Register> optional1 = userService.getUserById("sid0011");
			if(optional1.isEmpty()) {
				System.out.println("Not Present");
				System.out.println();
			}
			else {
				System.out.println(optional1.get());
				System.out.println();
			}
		} 
		catch (InvalidNameException | IdNotFoundException | InvalidIdLengthException | InvalidEmailException
				| InvalidContactNumberException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Getting all users
		System.out.println("Getting all user details");
		try {
			Optional<List<Register>> optional2 = userService.getAllUserDetails();
			if(optional2.isEmpty()) {
				System.out.println("Not Present");
				System.out.println();
			}
			else {
				optional2.get().forEach(e->System.out.println(e));
				System.out.println();
			}
		} 
		catch (InvalidNameException | InvalidIdLengthException | InvalidEmailException | InvalidContactNumberException
				| InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Deleting a user
		System.out.println("Deleting the details of a user");
		try {
			System.out.println(userService.deleteUserById("sid0012"));
			System.out.println();
		} 
		catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Checking if User exists by Email and Contact Number
		System.out.println("Checking is User exists by Email and Contact Number");
		System.out.println(userRepository.existsByEmailAndContactNumber("siddrao11@gmail.com", new BigDecimal("8123333693")));
		System.out.println();
		
//		// Checking if User exists by their contact number
//		System.out.println("Checking if User exists by their contact number");
//		System.out.println(userRepository.existsByContactNumber(new BigDecimal("8123333693")));
//		System.out.println();
		
		
		
//		// *************************** SUBSCRIPTION *********************
//		Subscription addSubscription = null;
//		addSubscription = new Subscription("sub0012", "2022-01-03", "2023-01-03", "CREDIT", "ACTIVE", "YEARLY", true,
//				"sid0012", 499f);
//
//		// Adding subscription
//		System.out.println(subscriptionService.addSubscription(addSubscription));
//
//		// Getting subscription by ID
//		try {
//			Optional<Subscription> optional3 = subscriptionService.getSubscriptionById("sub0011");
//			if(optional3.isEmpty()) {
//				System.out.println("Not Present");
//			}
//			else {
//				System.out.println(optional3.get());
//			}
//		} 
//		catch (IdNotFoundException | InvalidIdLengthException | InvalidAmountException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// Getting all subscriptions
//		try {
//			Optional<List<Subscription>> optional4 = subscriptionService.getAllSubscriptions();
//			if(optional4.isEmpty()) {
//				System.out.println("Not Present");
//			}
//			else {
//				optional4.get().forEach(e->System.out.println(e));
//			}
//		} 
//		catch (InvalidIdLengthException | InvalidAmountException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// Deleting a user
//		try {
//			System.out.println(subscriptionService.deleteSubscription("sub0012"));
//		} 
//		catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		
//		
//		// *************************** LOGIN *********************
//		Login addLogin = null;
//		addLogin = new Login("siddrao12@gmail.com", "12345678", "sid0012", null);
//
//		// Adding login details
//		System.out.println(loginService.addCredentials(addLogin));
//		
//		// Delete credentials
//		try {
//			System.out.println(loginService.deleteCredentials("siddrao12@gmail.com"));
//		} 
//		catch (IdNotFoundException | InvalidUsernameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//
		// *************************** MOVIES *********************
		System.out.println("*************************** MOVIES *********************");
		Movies addMovie = null;
		addMovie = new Movies("mov0012", "Goodfellas", "Crime", "2022-08-04", "English", "wxyz", 2400f, 21,
				"https://www.youtube.com/watch?v=Rt_UqUm38BI");

		// Adding movie
		System.out.println("Adding movie details:");
		System.out.println(movieService.addMovie(addMovie));
		System.out.println();
		
		// Getting movie details by ID
		System.out.println("Getting movie details by ID:");
		try {
			Optional<Movies> optional5 = movieService.getMovieById("mov0011");
			if(optional5.isEmpty()) {
				System.out.println("Not Present");
				System.out.println();
			}
			else {
				System.out.println(optional5.get());
				System.out.println();
			}
		} 
		catch (InvalidNameException | IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Getting all movie details
		System.out.println("Getting all movie details: ");
		try {
			Optional<List<Movies>> optional6 = movieService.getAllMovies();
			if(optional6.isEmpty()) {
				System.out.println("Not Present");
				System.out.println();
			}
			else {
				optional6.get().forEach(e->System.out.println(e));
				System.out.println();
			}
		} 
		catch (InvalidNameException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Deleting a movie
		System.out.println("Deleting the details of a movie: ");
		try {
			System.out.println(movieService.deleteMovie("mov0012"));
			System.out.println();
		} 
		catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Checking if a movie exists
		System.out.println("Checking if a movie already exists");
		System.out.println(movieRepository.existsByName("Money Ball"));
		System.out.println();
		
		// Retrieving movie details based on their name and language
		System.out.println("Retrieving movie details based on their name and language:");
		Optional<Movies> retrieveMovieDetails = movieRepository.findByNameAndLanguage("Money Ball", "English");
		if(retrieveMovieDetails.isEmpty()) {
			System.out.println("Movie Details Not Found");
			System.out.println();
		}
		else {
			System.out.println(retrieveMovieDetails.get());
			System.out.println();
		}
		
		// Retrieving movie details based on the name/title
		System.out.println("Retrieving movie details based on the name/title: ");
		Optional<Movies> retrieveMovieName = movieRepository.findByName("Money Ball");
		if(retrieveMovieName.isEmpty()) {
			System.out.println("Movie Not Found");
			System.out.println();
		}
		else {
			System.out.println(retrieveMovieName.get());
			System.out.println();
		}
		
		// Retrieving movie details based on the name and release date
		System.out.println("Retrieving movie details based on name and release date: ");
		Optional<Movies> retrieveMovieDetailsByNameAndDate = movieRepository.findByNameAndReleaseDate("Money Ball", "2022-09-04");
		if(retrieveMovieDetailsByNameAndDate.isEmpty()) {
			System.out.println("Movie Not Found");
			System.out.println();
		}
		else {
			System.out.println(retrieveMovieDetailsByNameAndDate.get());
			System.out.println();
		}
		
		// Retrieving movie details based on the cast
		System.out.println("Retrieving movie details based on cast: ");
		Optional<List<Movies>> retrieveMovieDetailsByCast = movieRepository.findByCast("Brad Pitt, Jonah Hill, Chris Pratt");
		if(retrieveMovieDetailsByCast.isEmpty()) {
			System.out.println("Movie Not Found");
			System.out.println();
		}
		else {
			retrieveMovieDetailsByCast.get().forEach(e->System.out.println(e));
			System.out.println();
		}
		
		
		
		// *************************** SERIES *********************
		System.out.println("*************************** SERIES *********************");
		Series addSeries = null;
		addSeries = new Series("ser0012", "lmnopq", "Drama", "2023-03-01", "Hindi", "rstu", 10, 18,
				"https://www.youtube.com/watch?v=eoIO5-O2Qvk", null);

		// Adding series
		System.out.println("Adding series details: ");
		System.out.println(seriesService.addSeries(addSeries));
		System.out.println();
		
		// Getting series details by ID
		System.out.println("Getting series details by ID: ");
		try {
			Optional<Series> optional7 = seriesService.getSeriesById("ser0011");
			if(optional7.isEmpty()) {
				System.out.println("Not Present");
				System.out.println();
			}
			else {
				System.out.println(optional7.get());
				System.out.println();
			}
		} 
		catch (InvalidNameException | IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Getting all series details
		System.out.println("Getting all series details: ");
		try {
			Optional<List<Series>> optional8 = seriesService.getAllSeries();
			if(optional8.isEmpty()) {
				System.out.println("Not Present");
				System.out.println();
			}
			else {
				optional8.get().forEach(e->System.out.println(e));
				System.out.println();
			}
		} 
		catch (InvalidNameException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Deleting series details
		System.out.println("Deleting details of a series: ");
		try {
			System.out.println(seriesService.deleteSeries("ser0012"));
			System.out.println();
		} 
		catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Checking if a series exists by their name
		System.out.println("Checking if a series exists by their name: ");
		System.out.println(seriesRepository.existsByName("The Office"));
		System.out.println();
		
		// Retrieving series details by their name and language
		System.out.println("Retrieving series details based on their name and language:");
		Optional<Series> retrieveSeriesDetails = seriesRepository.findByNameAndLanguage("The Office", "English");
		if(retrieveSeriesDetails.isEmpty()) {
			System.out.println("Series Details Not Found");
			System.out.println();
		}
		else {
			System.out.println(retrieveSeriesDetails.get());
			System.out.println();
		}
		

//		// *************************** EPISODES *********************
//		Episodes addEpisodes = null;
//		addEpisodes = new Episodes("epi0012", "ser0012", "qwert", 1500f, "yuiop",
//				"https://www.youtube.com/watch?v=af0GMFIlb4Q");
//
//		// Adding episodes
//		System.out.println(episodeService.addEpisodes(addEpisodes));
//		
//		// Getting details of episode by ID
//		try {
//			Optional<Episodes> optional9 = episodeService.getEpisodeDetailsById("epi0011");
//			if(optional9.isEmpty()) {
//				System.out.println("Not Present");
//			}
//			else {
//				System.out.println(optional9.get());
//			}
//		} 
//		catch (InvalidNameException | InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// Getting all episode details
//		try {
//			Optional<List<Episodes>> optional10 = episodeService.getAllEpisodeDetails();
//			if(optional10.isEmpty()) {
//				System.out.println("Not Present");
//			}
//			else {
//				optional10.get().forEach(e->System.out.println(e));
//			}
//		} 
//		catch (InvalidNameException | InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// Deleting details of an episode
//		try {
//			System.out.println(episodeService.deleteEpisodes("epi0012"));
//		} 
//		catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		applicationContext.close();

	}

}

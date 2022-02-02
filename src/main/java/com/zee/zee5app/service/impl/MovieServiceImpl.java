/**
 * 
 */
package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.service.MovieService;


@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	
	@Override
	public String addMovie(Movies movie) {
		Movies movie1 = movieRepository.save(movie);
		
		if(movie1 != null) {
			return "Success";
		}
		else {
			return "Fail";
		}
	}


	@Override
	public Optional<Movies> getMovieById(String id)
			throws IdNotFoundException, InvalidNameException, InvalidIdLengthException {
		
		return movieRepository.findById(id);
	}


	@Override
	public Optional<List<Movies>> getAllMovies() throws InvalidNameException, InvalidIdLengthException {
		
		return Optional.ofNullable(movieRepository.findAll());
	}


	@Override
	public String modifyMovie(String id, Movies movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		
		try {
			Optional<Movies> optional = this.getMovieById(id);
			
			if(optional.isEmpty()) {
				throw new IdNotFoundException("Record Not Found");
			}
			else {
				movieRepository.deleteById(id);
				return "Success";
			}
		} 
		catch (InvalidNameException | IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
		
	}


}

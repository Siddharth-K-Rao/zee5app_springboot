package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {

	@Autowired
	private EpisodeRepository episodeRepository;
	
	
	@Override
	public String addEpisodes(Episodes episode) {
		Episodes episode1 = episodeRepository.save(episode);
		
		if(episode1 != null) {
			return "Success";
		}
		else {
			return "Fail";
		}
	}


	@Override
	public String deleteEpisodes(String id) throws IdNotFoundException {
		
		try {
			Optional<Episodes> optional = this.getEpisodeDetailsById(id);
			
			if(optional.isEmpty()) {
				throw new IdNotFoundException("Record Not Found");
			}
			else {
				episodeRepository.deleteById(id);
				return "Success";
			}
		} 
		catch (InvalidNameException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
		
	}


	@Override
	public String modifyEpisodeDetails(String id, Episodes episode) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<Episodes> getEpisodeDetailsById(String id) throws InvalidNameException, InvalidIdLengthException {
		
		return episodeRepository.findById(id);
	}


	@Override
	public Optional<List<Episodes>> getAllEpisodeDetails(String id)
			throws InvalidNameException, InvalidIdLengthException {
		
		return Optional.ofNullable(episodeRepository.findAll());
	}



}

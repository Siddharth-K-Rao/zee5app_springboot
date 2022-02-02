package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.service.SeriesService;

@Service
public class SeriesServiceImpl implements SeriesService {

	@Autowired
	private SeriesRepository seriesRepository;
	
	
	@Override
	public String addSeries(Series series1) {
		Series series2 = seriesRepository.save(series1);
		
		if(series2 != null) {
			return "Success";
		}
		else {
			return "Fail";
		}
	}


	@Override
	public Optional<Series> getSeriesById(String id)
			throws IdNotFoundException, InvalidNameException, InvalidIdLengthException {
		
		return seriesRepository.findById(id);
	}


	@Override
	public Optional<List<Series>> getAllSeries() throws InvalidNameException, InvalidIdLengthException {
		
		return Optional.ofNullable(seriesRepository.findAll());
	}


	@Override
	public String modifySeries(String id, Series series1) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		
		try {
			Optional<Series> optional = this.getSeriesById(id);
			
			if(optional.isEmpty()) {
				throw new IdNotFoundException("Record Not Found");
			}
			else {
				seriesRepository.deleteById(id);
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

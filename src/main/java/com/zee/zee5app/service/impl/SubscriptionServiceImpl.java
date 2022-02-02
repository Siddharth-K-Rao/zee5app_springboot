package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subRepository;

	
	@Override
	public String addSubscription(Subscription subscription) {
		Subscription subscription2 =  subRepository.save(subscription);
		
		if(subscription2 != null) {
			return "Success";
		}
		else {
			return "Fail";
		}
	}


	@Override
	public Optional<Subscription> getSubscriptionById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException {
		
		return subRepository.findById(id);
	}


	@Override
	public Optional<List<Subscription>> getAllSubscriptions() throws InvalidIdLengthException, InvalidAmountException {
		
		return Optional.ofNullable(subRepository.findAll());
	}


	@Override
	public String modifySubscription(String id, Subscription subscription) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		
		Optional<Subscription> optional;
		try {
			optional = this.getSubscriptionById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("Record Not Found");
			}
			else {
				subRepository.deleteById(id);
				return "Success";
			}
		} 
		catch (IdNotFoundException | InvalidIdLengthException | InvalidAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
		
	}

}

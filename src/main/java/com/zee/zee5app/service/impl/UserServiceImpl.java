package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidContactNumberException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public String addUser(Register register) {
		Register register2 = userRepository.save(register);
		
		if(register2 != null) {
			return "Success";
		}
		else {
			return "Fail";
		}
	}
	
	
	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidNameException,
			InvalidIdLengthException, InvalidEmailException, InvalidContactNumberException, InvalidPasswordException {
		
		return userRepository.findById(id);
	}
	
	
	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		
		return null;
	}
	
	
	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		
		try {
			Optional<Register> optional = this.getUserById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("Record Not Found");
			}
			else {
				userRepository.deleteById(id);
				return "Success";
			}
		} 
		catch (InvalidNameException | IdNotFoundException | InvalidIdLengthException | InvalidEmailException
				| InvalidContactNumberException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}

	}
	
	
	@Override
	public Register[] getAllUsers() throws InvalidNameException, InvalidIdLengthException,
	InvalidEmailException, InvalidContactNumberException, InvalidPasswordException{
		
		List<Register> list = userRepository.findAll();
		Register[] array = new Register[list.size()];
		
		return list.toArray(array);
	}
	
	
	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidNameException, InvalidIdLengthException,
			InvalidEmailException, InvalidContactNumberException, InvalidPasswordException {
		
		return Optional.ofNullable(userRepository.findAll());
	}


}

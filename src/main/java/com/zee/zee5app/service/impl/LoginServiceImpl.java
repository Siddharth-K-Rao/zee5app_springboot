package com.zee.zee5app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidUsernameException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public String addCredentials(Login login) {
		Login login1 = loginRepository.save(login);
		
		if(login1 != null) {
			return "Success";
		}
		else {
			return "Fail";
		}
	}

	@Override
	public String deleteCredentials(String userName) throws IdNotFoundException, InvalidUsernameException{
		
		Optional<Login> optional = loginRepository.findById(userName);
		
		if(optional.isEmpty()) {
			throw new IdNotFoundException("Record Not Found");
		}
		else {
			loginRepository.deleteById(userName);
			return "Success";
		}
		
		
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeRole(String userName, ROLE role) {
		// TODO Auto-generated method stub
		return null;
	}


}

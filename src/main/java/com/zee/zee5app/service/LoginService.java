package com.zee.zee5app.service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidUsernameException;

public interface LoginService {

	public String addCredentials(Login login);
	public String deleteCredentials(String userName) throws IdNotFoundException, InvalidUsernameException;
	public String changePassword(String userName,String password);
	public String changeRole(String userName, EROLE role);
}

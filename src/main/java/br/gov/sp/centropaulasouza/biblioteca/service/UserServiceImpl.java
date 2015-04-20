package br.gov.sp.centropaulasouza.biblioteca.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author hideki
 */
@Service
public class UserServiceImpl implements UserService{
 
        @Override
	public String getMessage() {
		return "JSF 2.2 + Spring Integration 4.1.6.RELEASE";
	}
 
}

package br.gov.sp.centropaulasouza.biblioteca.controller;

import br.gov.sp.centropaulasouza.biblioteca.service.UserService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

/**
 *
 * @author hideki
 */
@Component
@ManagedBean
@SessionScoped
public class UserController{
 
        @Inject
	UserService userService;
 
	public void setUserBo(UserService userService) {
		this.userService = userService;
	}
 
	public String printMsgFromSpring() {
 
		return userService.getMessage();
 
	}
 
}

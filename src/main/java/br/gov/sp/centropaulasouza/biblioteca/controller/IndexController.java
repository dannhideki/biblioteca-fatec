package br.gov.sp.centropaulasouza.biblioteca.controller;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.stereotype.Controller;

/**
 *
 * @author hideki
 */
@Controller
@RequestScoped
@Named
public class IndexController {

	public String getMessage() {
		return "Seja bem vindo a Biblioteca da Fatec!";
	}

	public String registerUser() {
		return "/public/register_user.xhtml";
	}
	
	public String login(){
		return "/public/login.xhtml";
	}

	public String index(){
		return "/public/index.xhtml";
	}
}

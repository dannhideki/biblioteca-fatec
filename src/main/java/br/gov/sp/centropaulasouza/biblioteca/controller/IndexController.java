package br.gov.sp.centropaulasouza.biblioteca.controller;

import br.gov.sp.centropaulasouza.biblioteca.service.UserService;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author hideki
 */
@Controller
@RequestScoped
@Named
public class IndexController {
    @Autowired
    UserService userService;

    @PostConstruct
    public void init() {
        System.out.println("Bean executado!");
    }

    public String getPrintMsgFromSpring() {
        return userService.getMessage();
    }

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

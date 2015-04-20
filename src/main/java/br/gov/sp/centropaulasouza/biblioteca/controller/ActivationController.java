package br.gov.sp.centropaulasouza.biblioteca.controller;

import br.gov.sp.centropaulasouza.biblioteca.service.UsuarioService;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Daniel Hideki
 */
@Named(value = "activation")
@RequestScoped
public class ActivationController {
 
    @ManagedProperty(value = "#{param.key}")
    private String key;
    
    @Autowired
    private UsuarioService userService;
 
    private boolean valid = false;
    
    public void validaUsuario(){
        if(userService.existsValidation(getKey())){
            setValid(true);
        } 
    }
 
    public String getKey() {
        return key;
    }
 
    public void setKey(String key) {
        this.key = key;
    }
 
    public boolean isValid() {
        return valid;
    }
 
    public void setValid(boolean valid) {
        this.valid = valid;
    }    
}

package br.gov.sp.centropaulasouza.biblioteca.controller;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.centropaulasouza.biblioteca.model.Usuario;
import br.gov.sp.centropaulasouza.biblioteca.service.UsuarioService;

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
        if(existsValidation()){
            setValid(true);
        }else{
        	setValid(false);
        }
    }
    
    public boolean existsValidation(){
    	Usuario user = userService.existsValidation(getKey());
    	if(user != null){
    		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", user);
    	}
    	return user != null;
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

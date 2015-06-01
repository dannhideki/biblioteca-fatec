package br.gov.sp.centropaulasouza.biblioteca.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageUtil {
	
	/**
	 * Envia mensagem de sucesso para a view
	 * 
	 */
	public static void enviaMensagemSucesso(String msg) 
	{
		FacesContext context = FacesContext.getCurrentInstance();  
		context.addMessage(null, new FacesMessage("Sucesso", msg));  
	}
	
	
	/**
	 * Envia mensagem de erro a view
	 * 
	 */
	public static void enviaMensagemErro(String msg) 
	{
		FacesContext context = FacesContext.getCurrentInstance();  
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro", msg));  
	}
	
}

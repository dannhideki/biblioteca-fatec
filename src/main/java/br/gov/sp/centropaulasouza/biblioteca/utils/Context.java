package br.gov.sp.centropaulasouza.biblioteca.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hideki
 */
public class Context {
     
    public static String getContextPath() {
 
        HttpServletRequest req = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        return url.substring(0, url.length() - req.getRequestURI().length())
                + req.getContextPath() + "/";
    }
}

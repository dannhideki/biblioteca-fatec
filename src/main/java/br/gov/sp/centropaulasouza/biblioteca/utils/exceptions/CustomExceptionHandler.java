package br.gov.sp.centropaulasouza.biblioteca.utils.exceptions;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import javax.el.ELException;
import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.mail.MailSendException;
/**
 *
 * @author Daniel Hideki
 */
 
//Inicialmente devemos implementar a classe CustomExceptionHandler que extende a classe ExceptionHandlerWrapper
public class CustomExceptionHandler extends ExceptionHandlerWrapper {
 
    private ExceptionHandler wrapped;
 
    //Obtém uma instância do FacesContext
    final FacesContext facesContext = FacesContext.getCurrentInstance();
 
    //Obtém um mapa do FacesContext
    final Map requestMap = facesContext.getExternalContext().getRequestMap();
 
    //Obtém o estado atual da navegação entre páginas do JSF
    final NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
 
    //Declara o construtor que recebe uma exceptio do tipo ExceptionHandler como parâmetro
    CustomExceptionHandler(ExceptionHandler exception) {
        this.wrapped = exception;
    }
 
    //Sobrescreve o método ExceptionHandler que retorna a "pilha" de exceções
    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }
 
    //Sobrescreve o método handle que é responsável por manipular as exceções do JSF
    @Override
   public void handle() throws FacesException {
        for (final Iterator<ExceptionQueuedEvent> it = getUnhandledExceptionQueuedEvents().iterator(); it.hasNext();) {
            Throwable t = it.next().getContext().getException();
            while (isException(t)) {
                t = t.getCause();
            }
            if (isException(t)) {
                FacesContext facesContext = FacesContext.getCurrentInstance();

                HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
                HttpSession session = request.getSession(true);
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(buffer);
                t.printStackTrace(ps);

                try {
                    String stackTrace = "Possivel erro : " + buffer.toString();
                    session.setAttribute("errorMsg", stackTrace);

                    facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "/public/404.xhtml");
                    System.out.println(t.getMessage());
                } catch (final Exception e) {
                    e.printStackTrace();
                } finally {
                    it.remove();
                }
            }
        }
        getWrapped().handle();
    }

    private boolean isException(Throwable t) {
        boolean isException = false;
        if(t instanceof IllegalStateException) isException = true;
        else if(t instanceof FileNotFoundException) isException = true;
        else if(t instanceof ViewExpiredException) isException = true;
        else if(t instanceof NullPointerException) isException = true;
        else if(t instanceof FacesException) isException = true;
        else if(t instanceof ELException) isException = true;
        else if(t instanceof IllegalArgumentException) isException = true;
        else if(t instanceof InvocationTargetException) isException = true;
        else if (t instanceof ConstraintViolationException) isException = true;
        else if (t instanceof MailSendException) isException = true;
        return isException;
    }
}

package br.gov.sp.centropaulasouza.biblioteca.utils.validators;

import br.gov.sp.centropaulasouza.biblioteca.service.ProfileService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Daniel Hideki
 */
@Component
@RequestScoped
public class EmailValidator implements Validator {

    @Autowired
    private ProfileService profileService;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\."
            + "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*"
            + "(\\.[A-Za-z]{2,})$";

    private Pattern pattern;
    private Matcher matcher;

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String email = value.toString();
        if (profileService.validateEmail(email)) {
            FacesMessage msg
                    = new FacesMessage("m_inputEmail",
                            "O email inserido já existem em nossa base de dados, insira outro email para realizar o cadastro");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);

            throw new ValidatorException(msg);
        }else{
            matcher = pattern.matcher(email);
		if(!matcher.matches()){
 
			FacesMessage msg = 
				new FacesMessage("m_inputEmail", 
						"Formato de email inválido");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
 
		}
        }
    }

}

package br.gov.sp.centropaulasouza.biblioteca.utils.converter;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.centropaulasouza.biblioteca.model.Pessoa;
import br.gov.sp.centropaulasouza.biblioteca.service.PessoaService;

@Service
@ManagedBean
@RequestScoped
public class PessoaConverter implements Converter, Serializable {

	private static final long serialVersionUID = -4136706886708579100L;
	
	@Autowired
	private PessoaService pessoaService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (StringUtils.isEmpty(value)) {
			return null;
		} else {
			Long ra = Long.parseLong(value);
			return pessoaService.findPessoaByRa(ra);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || ((Pessoa) value).getId() == null) {
			return "";
		} else {
			Pessoa pessoa = (Pessoa) value;
			return pessoa.getRa().toString();
		}
	}

}

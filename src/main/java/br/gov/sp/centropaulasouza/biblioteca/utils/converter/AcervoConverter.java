package br.gov.sp.centropaulasouza.biblioteca.utils.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.centropaulasouza.biblioteca.model.Acervo;
import br.gov.sp.centropaulasouza.biblioteca.service.AcervoService;

@Named
public class AcervoConverter implements Converter {

	@Autowired
	private AcervoService acervoService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.isEmpty() || value == null) {
			return null;
		} else {
			Integer codigo = Integer.parseInt(value.toString());
			return acervoService.getAcervoByCodigo(codigo);
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value == null || ((Acervo)value).getCodigo() == null) {
			return "";
		} else {
			Acervo acervo = (Acervo) value;
			return acervo.getCodigo().toString();
		}
	}

}

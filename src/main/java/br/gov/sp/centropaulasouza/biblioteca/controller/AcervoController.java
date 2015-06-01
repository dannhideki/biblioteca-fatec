package br.gov.sp.centropaulasouza.biblioteca.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.gov.sp.centropaulasouza.biblioteca.model.Acervo;
import br.gov.sp.centropaulasouza.biblioteca.service.AcervoService;

@Controller
@RequestScoped
@Named
public class AcervoController {

	@Autowired
	private AcervoService acervoService;

	private List<Acervo> acervoList;

	private Acervo selectdAcervo;

	@PostConstruct
	public void init(){
		acervoList = acervoService.getList();
		selectdAcervo = new Acervo();
	}
	
	public List<Acervo> completeAcervo(String query){
		return acervoService.findByQuery(query);
	}

	public List<Acervo> getAcervoList() {
		return acervoList;
	}

	public void setAcervoList(List<Acervo> acervoList) {
		this.acervoList = acervoList;
	}

	public Acervo getSelectdAcervo() {
		return selectdAcervo;
	}

	public void setSelectdAcervo(Acervo selectdAcervo) {
		this.selectdAcervo = selectdAcervo;
	}
}

package br.gov.sp.centropaulasouza.biblioteca.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import br.gov.sp.centropaulasouza.biblioteca.model.Pessoa;
import br.gov.sp.centropaulasouza.biblioteca.model.Usuario;
import br.gov.sp.centropaulasouza.biblioteca.model.enums.RoleEnum;
import br.gov.sp.centropaulasouza.biblioteca.model.enums.SexoEnum;
import br.gov.sp.centropaulasouza.biblioteca.service.PessoaService;
import br.gov.sp.centropaulasouza.biblioteca.service.UsuarioService;
import br.gov.sp.centropaulasouza.biblioteca.utils.ServiceFinder;
import br.gov.sp.centropaulasouza.biblioteca.utils.date.ManipulateDate;
import br.gov.sp.centropaulasouza.biblioteca.utils.mail.SimpleRegistrationService;
import br.gov.sp.centropaulasouza.biblioteca.utils.security.GenerateMD5;
import br.gov.sp.centropaulasouza.biblioteca.utils.security.GenerateValidation;

/**
 *
 * @author hideki
 */
@ManagedBean
@Controller
@RequestScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 549293639078895594L;

	@Autowired
    private PessoaService pessoaService;

    @Autowired
    private UsuarioService usuarioService;

    private Usuario user;
    private Pessoa pessoa;
    private String ra;
    private String newPassword;

    private int day = 0;
    private int month = 0;
    private int year = 0;
    
    private Boolean senhaTrocadaComSucesso = false;

    @PostConstruct
    public void init() {
        user = new Usuario();
        pessoa = new Pessoa();

    }

    public String save() {
        user.setPassword(GenerateMD5.generate(user.getPassword()));
        user.setValidation(GenerateValidation.keyValidation());
        user.getPermissions().add(RoleEnum.ROLE_COMMON.getValue());
        user.setEnable(true);
        user.setDataCadastro(new Date());

        pessoa.setUser(user);
        pessoa.setDataNascimento(ManipulateDate.getDate(year, month, day));
        pessoa.setDataCadastro(new Date());
        pessoaService.saveOrUpdate(pessoa);

        //Para enviar email de confirmação de cadastro
        SimpleRegistrationService mail = (SimpleRegistrationService) ServiceFinder.findBean("registrationService");
        mail.register(pessoa);
        user = new Usuario();
        pessoa = new Pessoa();
        return "/public/feedback_login";
    }
    
    public String trocaSenha(){
    	user = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    	user.setPassword(GenerateMD5.generate(this.newPassword));
    	usuarioService.saveOrUpdate(user);
    	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
    	senhaTrocadaComSucesso = true;
        user = new Usuario();
    	return "/public/feedback_troca_senha";
    }
    
    public String pedidoTrocaSenha(){
    	Pessoa pessoaQuePediuTrocaDeSenha = pessoaService.findPessoaByEmail(pessoa.getEmail());
    	pessoaQuePediuTrocaDeSenha.getUser().setValidation(GenerateValidation.keyValidation());
    	pessoaService.saveOrUpdate(pessoaQuePediuTrocaDeSenha);
    	SimpleRegistrationService mail = (SimpleRegistrationService) ServiceFinder.findBean("registrationService");
        mail.esqueciSenha(pessoaQuePediuTrocaDeSenha);
        return "/public/feedback_troca_senha";
    }

    public String getLoginUsuario() {
        Usuario usuarioLogado = new Usuario();
        SecurityContext context = SecurityContextHolder.getContext();
        if (context instanceof SecurityContext) {
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication) {
                usuarioLogado.setLogin(((User) authentication.getPrincipal()).getUsername());
            }
        }
        return usuarioLogado.getLogin();
    }

    public List<Pessoa> completeRa(String query) {
        List<Pessoa> listaPessoa = pessoaService.findByRaWithLike(query);
        return listaPessoa;
    }
    
    public void selecionaPessoa(SelectEvent select){
    	Pessoa pessoaSelecionada = (Pessoa) select.getObject();
    	this.pessoa = pessoaSelecionada;
    	
    }

    //getters and setters
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Map<String, Object> getDays() {
        return ManipulateDate.getDays();
    }

    public Map<String, Object> getMonths() {
        return ManipulateDate.getMonths();
    }

    public Map<String, Object> getYears() {
        return ManipulateDate.getYears();
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public SexoEnum[] getSexo() {
        return SexoEnum.values();
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

	public Boolean getSenhaTrocadaComSucesso() {
		return senhaTrocadaComSucesso;
	}

	public void setSenhaTrocadaComSucesso(Boolean senhaTrocadaComSucesso) {
		this.senhaTrocadaComSucesso = senhaTrocadaComSucesso;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}

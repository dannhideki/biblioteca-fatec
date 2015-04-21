package br.gov.sp.centropaulasouza.biblioteca.controller;

import br.gov.sp.centropaulasouza.biblioteca.model.Profile;
import br.gov.sp.centropaulasouza.biblioteca.model.enums.RoleEnum;
import br.gov.sp.centropaulasouza.biblioteca.model.enums.SexoEnum;
import br.gov.sp.centropaulasouza.biblioteca.model.Usuario;
import br.gov.sp.centropaulasouza.biblioteca.service.ProfileService;
import br.gov.sp.centropaulasouza.biblioteca.service.UsuarioService;
import br.gov.sp.centropaulasouza.biblioteca.utils.ServiceFinder;
import br.gov.sp.centropaulasouza.biblioteca.utils.date.ManipulateDate;
import br.gov.sp.centropaulasouza.biblioteca.utils.mail.SimpleRegistrationService;
import br.gov.sp.centropaulasouza.biblioteca.utils.security.GenerateMD5;
import br.gov.sp.centropaulasouza.biblioteca.utils.security.GenerateValidation;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author hideki
 */
@Component
@Named
@SessionScoped
public class UsuarioController implements Serializable {

    @Autowired
    private ProfileService profileService;
    
    @Autowired
    private UsuarioService usuarioService;

    private Usuario user;
    private Profile profile;

    private int day = 0;
    private int month = 0;
    private int year = 0;

    @PostConstruct
    public void init() {
        user = new Usuario();
        profile = new Profile();
        
    }

    public String save() {
        user.setPassword(GenerateMD5.generate(user.getPassword()));
        user.setValidation(GenerateValidation.keyValidation());
        user.getPermissions().add(RoleEnum.ROLE_COMMON.getValue());
        user.setEnable(true);
        user.setDataCadastro(new Date());

        profile.setUser(user);
        profile.setDataNascimento(ManipulateDate.getDate(year, month, day));
        profile.setDataCadastro(new Date());
        profileService.save(profile);

        //Para enviar email de confirmação de cadastro
//        SimpleRegistrationService mail = (SimpleRegistrationService) ServiceFinder.findBean("registrationService");
//        mail.register(profile);
        return "/public/feedback_login";
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

    //getters and setters
    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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
}

package br.gov.sp.centropaulasouza.biblioteca.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author hideki
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "enable", columnDefinition = "BOOLEAN")
    private boolean enable;
    private String login;
    private String password;    
    private String validation;
     
    @ElementCollection(targetClass = String.class)
    @JoinTable(name = "USUARIO_PERMISSAO",
               uniqueConstraints = { @UniqueConstraint (columnNames = {"id", "permission" })},
               joinColumns = @JoinColumn(name = "id"))
    @Column(name = "permission", length = 40)
    @Cascade(CascadeType.DELETE)
    private Set<String> permissions = new HashSet<>(); 


    public Usuario() {
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

}

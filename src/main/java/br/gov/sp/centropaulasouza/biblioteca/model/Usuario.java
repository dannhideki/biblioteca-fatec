package br.gov.sp.centropaulasouza.biblioteca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

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
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id", "permission"})},
            joinColumns = @JoinColumn(name = "id"))
    @Column(name = "permission", length = 40)
    @Cascade(CascadeType.DELETE)
    private Set<String> permissions = new HashSet<>();

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCadastro;

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

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}

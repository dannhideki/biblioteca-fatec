package br.gov.sp.centropaulasouza.biblioteca.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Daniel Hideki
 */
@Entity
@Table(name = "EDITORA")
public class AcervoAutor implements Serializable {

    @Id
    @GeneratedValue
    private Integer codigo;

    @MapsId
    @OneToOne
    @JoinColumn(name = "codigo_acervo", referencedColumnName = "codigo")
    private Acervo acervo;

    @OneToOne
    @JoinColumn(columnDefinition = "codigo_acervo", referencedColumnName = "codigo")
    private Autor autor;

    @Column(name = "ativo", columnDefinition = "BOOLEAN")
    private Boolean ativo;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_autor_user_id_cadastro")
    @JoinColumn(name = "user_id_cadastro", referencedColumnName = "id")
    private Usuario usuarioCadastro;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_autor_user_id_alteracao")
    @JoinColumn(name = "user_id_alteracao", referencedColumnName = "id")
    private Usuario usuarioAlteracao;

    //getters and setters
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Acervo getAcervo() {
        return acervo;
    }

    public void setAcervo(Acervo acervo) {
        this.acervo = acervo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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

    public Usuario getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(Usuario usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public Usuario getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(Usuario usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

}

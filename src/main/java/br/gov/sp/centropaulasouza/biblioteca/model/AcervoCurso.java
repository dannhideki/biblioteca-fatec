package br.gov.sp.centropaulasouza.biblioteca.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Daniel Hideki
 */
@Entity
@Table(name = "ACERVO_CURSO")
public class AcervoCurso implements Serializable {

    @Id
    @OneToOne
    @ForeignKey(name = "fk_acervo_curso_acervo_codigo")
    @JoinColumn(name = "acervo_codigo", nullable = false)
    private Acervo acervo;

    @MapsId
    @OneToOne
    @ForeignKey(name = "fk_acervo_curso_curso_codigo")
    @JoinColumn(name = "curso_codigo", nullable = false)
    private Curso curso;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_curso_user_id_cadastro")
    @JoinColumn(name = "user_id_cadastro", referencedColumnName = "id")
    private Usuario usuarioCadastro;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_curso_user_id_alteracao")
    @JoinColumn(name = "user_id_alteracao", referencedColumnName = "id")
    private Usuario usuarioAlteracao;

    //getters and setters
    public Acervo getAcervo() {
        return acervo;
    }

    public void setAcervo(Acervo acervo) {
        this.acervo = acervo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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

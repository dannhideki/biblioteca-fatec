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
@Table(name = "ACERVO_TOMBO")
public class AcervoTombo implements Serializable {

    @Id
    @GeneratedValue
    private Integer codigo;

    @MapsId
    @ManyToOne
    @JoinColumn(name = "codigo_acervo", nullable = false)
    private Acervo acervo;

    private String tombo;
    private String isbn;
    private Integer numeroPaginas;
    private Integer anoPublicacao;
    private String volume;
    private String codigoBarras;

    @Column(name = "ativo", columnDefinition = "BOOLEAN")
    private Boolean ativo;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_tombo_user_id_cadastro")
    @JoinColumn(name = "user_id_cadastro", referencedColumnName = "id")
    private Usuario usuarioCadastro;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_tombo_user_id_alteracao")
    @JoinColumn(name = "user_id_alteracao", referencedColumnName = "id")
    private Usuario usuarioAlteracao;

    @OneToOne
    @ForeignKey(name = "fk_acervo_tombo_codigo_acervo_status")
    @JoinColumn(name = "codigo_acervo_status", referencedColumnName = "codigo")
    private AcervoStatus avervoStatus;

//    private String cdu_old;
//    private String pha_old;
//    private Integer nedicao;
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

    public String getTombo() {
        return tombo;
    }

    public void setTombo(String tombo) {
        this.tombo = tombo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
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

    public AcervoStatus getAvervoStatus() {
        return avervoStatus;
    }

    public void setAvervoStatus(AcervoStatus avervoStatus) {
        this.avervoStatus = avervoStatus;
    }

}

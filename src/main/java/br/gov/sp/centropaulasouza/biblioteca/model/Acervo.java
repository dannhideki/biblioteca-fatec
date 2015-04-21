package br.gov.sp.centropaulasouza.biblioteca.model;

import br.gov.sp.centropaulasouza.biblioteca.model.enums.TipoAquisicaoEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Daniel Hideki
 */
@Entity
@Table(name = "ACERVO")
public class Acervo implements Serializable {

    @Id
    @GeneratedValue
    private Integer codigo;
    private String descricao;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_codigo_categoria")
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
    private Categoria codigoCategoria;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_codigo_genero")
    @JoinColumn(name = "codigo_genero", referencedColumnName = "codigo")
    private Genero codigoGenero;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_codigo_sub_genero")
    @JoinColumn(name = "codigo_sub_genero", referencedColumnName = "codigo")
    private SubGenero codigoSubGenero;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_codigo_assunto")
    @JoinColumn(name = "codigo_assunto", referencedColumnName = "codigo")
    private Assunto codigoAssunto;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_codigo_sub_assunto")
    @JoinColumn(name = "codigo_sub_assunto", referencedColumnName = "codigo")
    private SubAssunto codigoSubAssunto;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_codigo_editora")
    @JoinColumn(name = "codigo_editora", referencedColumnName = "codigo")
    private Editora editora;

    private Integer numeroPagina;
    private String duracao;
    private Double valorCompra;
    private Integer anoPublicacao;
    private String isbn;

    @Lob
    private byte[] ilustracao;

    @Lob
    private byte[] pdf;

    private String resumo;
    private Integer numeroCopias;

    @Enumerated(EnumType.STRING)
    private TipoAquisicaoEnum tipoAquisicao;

    private Boolean midia;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_user_id_cadastro")
    @JoinColumn(name = "user_id_cadastro", referencedColumnName = "id")
    private Usuario usuarioCadastro;

    @ManyToOne
    @ForeignKey(name = "fk_acervo_user_id_alteracao")
    @JoinColumn(name = "user_id_alteracao", referencedColumnName = "id")
    private Usuario usuarioAlteracao;

//    private String cdu;
//    private String cuter;
//    private String link;
//    private String local;
    //getters and setters
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Categoria codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Genero getCodigoGenero() {
        return codigoGenero;
    }

    public void setCodigoGenero(Genero codigoGenero) {
        this.codigoGenero = codigoGenero;
    }

    public SubGenero getCodigoSubGenero() {
        return codigoSubGenero;
    }

    public void setCodigoSubGenero(SubGenero codigoSubGenero) {
        this.codigoSubGenero = codigoSubGenero;
    }

    public Assunto getCodigoAssunto() {
        return codigoAssunto;
    }

    public void setCodigoAssunto(Assunto codigoAssunto) {
        this.codigoAssunto = codigoAssunto;
    }

    public SubAssunto getCodigoSubAssunto() {
        return codigoSubAssunto;
    }

    public void setCodigoSubAssunto(SubAssunto codigoSubAssunto) {
        this.codigoSubAssunto = codigoSubAssunto;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Integer getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(Integer numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public byte[] getIlustracao() {
        return ilustracao;
    }

    public void setIlustracao(byte[] ilustracao) {
        this.ilustracao = ilustracao;
    }

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Integer getNumeroCopias() {
        return numeroCopias;
    }

    public void setNumeroCopias(Integer numeroCopias) {
        this.numeroCopias = numeroCopias;
    }

    public TipoAquisicaoEnum getTipoAquisicao() {
        return tipoAquisicao;
    }

    public void setTipoAquisicao(TipoAquisicaoEnum tipoAquisicao) {
        this.tipoAquisicao = tipoAquisicao;
    }

    public Boolean getMidia() {
        return midia;
    }

    public void setMidia(Boolean midia) {
        this.midia = midia;
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

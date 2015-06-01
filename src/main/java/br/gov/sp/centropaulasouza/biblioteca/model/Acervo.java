package br.gov.sp.centropaulasouza.biblioteca.model;

import br.gov.sp.centropaulasouza.biblioteca.model.enums.TipoAquisicaoEnum;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

	private static final long serialVersionUID = -2163672556051337781L;
	
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

    @OneToOne
    @ForeignKey(name = "fk_acervo_codigo_autor")
    @JoinColumn(name = "codigo_autor", referencedColumnName = "codigo")
    private Autor autor;

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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((anoPublicacao == null) ? 0 : anoPublicacao.hashCode());
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((codigoAssunto == null) ? 0 : codigoAssunto.hashCode());
		result = prime * result
				+ ((codigoCategoria == null) ? 0 : codigoCategoria.hashCode());
		result = prime * result
				+ ((codigoGenero == null) ? 0 : codigoGenero.hashCode());
		result = prime
				* result
				+ ((codigoSubAssunto == null) ? 0 : codigoSubAssunto.hashCode());
		result = prime * result
				+ ((codigoSubGenero == null) ? 0 : codigoSubGenero.hashCode());
		result = prime * result
				+ ((dataAlteracao == null) ? 0 : dataAlteracao.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((duracao == null) ? 0 : duracao.hashCode());
		result = prime * result + ((editora == null) ? 0 : editora.hashCode());
		result = prime * result + Arrays.hashCode(ilustracao);
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((midia == null) ? 0 : midia.hashCode());
		result = prime * result
				+ ((numeroCopias == null) ? 0 : numeroCopias.hashCode());
		result = prime * result
				+ ((numeroPagina == null) ? 0 : numeroPagina.hashCode());
		result = prime * result + Arrays.hashCode(pdf);
		result = prime * result + ((resumo == null) ? 0 : resumo.hashCode());
		result = prime * result
				+ ((tipoAquisicao == null) ? 0 : tipoAquisicao.hashCode());
		result = prime
				* result
				+ ((usuarioAlteracao == null) ? 0 : usuarioAlteracao.hashCode());
		result = prime * result
				+ ((usuarioCadastro == null) ? 0 : usuarioCadastro.hashCode());
		result = prime * result
				+ ((valorCompra == null) ? 0 : valorCompra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acervo other = (Acervo) obj;
		if (anoPublicacao == null) {
			if (other.anoPublicacao != null)
				return false;
		} else if (!anoPublicacao.equals(other.anoPublicacao))
			return false;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (codigoAssunto == null) {
			if (other.codigoAssunto != null)
				return false;
		} else if (!codigoAssunto.equals(other.codigoAssunto))
			return false;
		if (codigoCategoria == null) {
			if (other.codigoCategoria != null)
				return false;
		} else if (!codigoCategoria.equals(other.codigoCategoria))
			return false;
		if (codigoGenero == null) {
			if (other.codigoGenero != null)
				return false;
		} else if (!codigoGenero.equals(other.codigoGenero))
			return false;
		if (codigoSubAssunto == null) {
			if (other.codigoSubAssunto != null)
				return false;
		} else if (!codigoSubAssunto.equals(other.codigoSubAssunto))
			return false;
		if (codigoSubGenero == null) {
			if (other.codigoSubGenero != null)
				return false;
		} else if (!codigoSubGenero.equals(other.codigoSubGenero))
			return false;
		if (dataAlteracao == null) {
			if (other.dataAlteracao != null)
				return false;
		} else if (!dataAlteracao.equals(other.dataAlteracao))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (duracao == null) {
			if (other.duracao != null)
				return false;
		} else if (!duracao.equals(other.duracao))
			return false;
		if (editora == null) {
			if (other.editora != null)
				return false;
		} else if (!editora.equals(other.editora))
			return false;
		if (!Arrays.equals(ilustracao, other.ilustracao))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (midia == null) {
			if (other.midia != null)
				return false;
		} else if (!midia.equals(other.midia))
			return false;
		if (numeroCopias == null) {
			if (other.numeroCopias != null)
				return false;
		} else if (!numeroCopias.equals(other.numeroCopias))
			return false;
		if (numeroPagina == null) {
			if (other.numeroPagina != null)
				return false;
		} else if (!numeroPagina.equals(other.numeroPagina))
			return false;
		if (!Arrays.equals(pdf, other.pdf))
			return false;
		if (resumo == null) {
			if (other.resumo != null)
				return false;
		} else if (!resumo.equals(other.resumo))
			return false;
		if (tipoAquisicao != other.tipoAquisicao)
			return false;
		if (usuarioAlteracao == null) {
			if (other.usuarioAlteracao != null)
				return false;
		} else if (!usuarioAlteracao.equals(other.usuarioAlteracao))
			return false;
		if (usuarioCadastro == null) {
			if (other.usuarioCadastro != null)
				return false;
		} else if (!usuarioCadastro.equals(other.usuarioCadastro))
			return false;
		if (valorCompra == null) {
			if (other.valorCompra != null)
				return false;
		} else if (!valorCompra.equals(other.valorCompra))
			return false;
		return true;
	}
}

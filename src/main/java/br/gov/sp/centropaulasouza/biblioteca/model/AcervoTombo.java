package br.gov.sp.centropaulasouza.biblioteca.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "ACERVO_TOMBO")
public class AcervoTombo implements Serializable {

	private static final long serialVersionUID = 8363644970297326440L;

	@Id
    @GeneratedValue
    private Integer codigo;

    @OneToOne
    @ForeignKey(name = "fk_acervo_tombo_codigo_acervo")
    @JoinColumn(name = "codigo_acervo", nullable = false, referencedColumnName = "codigo")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acervo == null) ? 0 : acervo.hashCode());
		result = prime * result
				+ ((anoPublicacao == null) ? 0 : anoPublicacao.hashCode());
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result
				+ ((avervoStatus == null) ? 0 : avervoStatus.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((codigoBarras == null) ? 0 : codigoBarras.hashCode());
		result = prime * result
				+ ((dataAlteracao == null) ? 0 : dataAlteracao.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result
				+ ((numeroPaginas == null) ? 0 : numeroPaginas.hashCode());
		result = prime * result + ((tombo == null) ? 0 : tombo.hashCode());
		result = prime
				* result
				+ ((usuarioAlteracao == null) ? 0 : usuarioAlteracao.hashCode());
		result = prime * result
				+ ((usuarioCadastro == null) ? 0 : usuarioCadastro.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
		AcervoTombo other = (AcervoTombo) obj;
		if (acervo == null) {
			if (other.acervo != null)
				return false;
		} else if (!acervo.equals(other.acervo))
			return false;
		if (anoPublicacao == null) {
			if (other.anoPublicacao != null)
				return false;
		} else if (!anoPublicacao.equals(other.anoPublicacao))
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (avervoStatus == null) {
			if (other.avervoStatus != null)
				return false;
		} else if (!avervoStatus.equals(other.avervoStatus))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (codigoBarras == null) {
			if (other.codigoBarras != null)
				return false;
		} else if (!codigoBarras.equals(other.codigoBarras))
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
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (numeroPaginas == null) {
			if (other.numeroPaginas != null)
				return false;
		} else if (!numeroPaginas.equals(other.numeroPaginas))
			return false;
		if (tombo == null) {
			if (other.tombo != null)
				return false;
		} else if (!tombo.equals(other.tombo))
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
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}
}

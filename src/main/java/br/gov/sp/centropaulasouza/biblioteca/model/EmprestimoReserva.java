package br.gov.sp.centropaulasouza.biblioteca.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Daniel Hideki
 */
@Entity
@Table(name = "EMPRESTIMO_RESERVA")
public class EmprestimoReserva implements Serializable {

	private static final long serialVersionUID = 8127330971930970587L;

	@Id
    @GeneratedValue
    private Integer codigo;

    @ManyToOne
    @ForeignKey(name = "fk_emprestimo_reserva_profile_id")
    @JoinColumn(name = "profile_id")
    private Pessoa profile;

    private String tipo;
    private double valorTotalMulta;
//DEFAULT '1.5' COMMENT 'Valor fixo é 1,50'
    private double valorFixoMulta;
    private Integer qtdadeDias;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataEmprestimo;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @ManyToOne
    @ForeignKey(name = "fk_emprestimo_reserva_user_id_cadastro")
    @JoinColumn(name = "user_id_cadastro", referencedColumnName = "id")
    private Usuario usuarioCadastro;

    @ManyToOne
    @ForeignKey(name = "fk_emprestimo_reserva_user_id_alteracao")
    @JoinColumn(name = "user_id_alteracao", referencedColumnName = "id")
    private Usuario usuarioAlteracao;

    //getters and setteres
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Pessoa getProfile() {
        return profile;
    }

    public void setProfile(Pessoa profile) {
        this.profile = profile;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorTotalMulta() {
        return valorTotalMulta;
    }

    public void setValorTotalMulta(double valorTotalMulta) {
        this.valorTotalMulta = valorTotalMulta;
    }

    public double getValorFixoMulta() {
        return valorFixoMulta;
    }

    public void setValorFixoMulta(double valorFixoMulta) {
        this.valorFixoMulta = valorFixoMulta;
    }

    public Integer getQtdadeDias() {
        return qtdadeDias;
    }

    public void setQtdadeDias(Integer qtdadeDias) {
        this.qtdadeDias = qtdadeDias;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((dataAlteracao == null) ? 0 : dataAlteracao.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result
				+ ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result
				+ ((qtdadeDias == null) ? 0 : qtdadeDias.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime
				* result
				+ ((usuarioAlteracao == null) ? 0 : usuarioAlteracao.hashCode());
		result = prime * result
				+ ((usuarioCadastro == null) ? 0 : usuarioCadastro.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorFixoMulta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorTotalMulta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		EmprestimoReserva other = (EmprestimoReserva) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
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
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (qtdadeDias == null) {
			if (other.qtdadeDias != null)
				return false;
		} else if (!qtdadeDias.equals(other.qtdadeDias))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
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
		if (Double.doubleToLongBits(valorFixoMulta) != Double
				.doubleToLongBits(other.valorFixoMulta))
			return false;
		if (Double.doubleToLongBits(valorTotalMulta) != Double
				.doubleToLongBits(other.valorTotalMulta))
			return false;
		return true;
	}
}

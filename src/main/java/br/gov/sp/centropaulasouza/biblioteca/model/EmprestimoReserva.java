package br.gov.sp.centropaulasouza.biblioteca.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "EMPRESTIMO_RESERVA")
public class EmprestimoReserva implements Serializable {

    @Id
    @GeneratedValue
    private Integer codigo;

    @ManyToOne
    @ForeignKey(name = "fk_emprestimo_reserva_profile_id")
    @JoinColumn(name = "profile_id")
    private Profile profile;

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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
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

}

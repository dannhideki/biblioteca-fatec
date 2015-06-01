package br.gov.sp.centropaulasouza.biblioteca.dao;

import br.gov.sp.centropaulasouza.biblioteca.model.Pessoa;



/**
 *
 * @author hideki
 */
public interface PessoaDao {

    public void save(Pessoa pessoa);

    public Pessoa getPessoa(Long id);

    public void remove(Pessoa pessoa);

    public void update(Pessoa pessoa);
}

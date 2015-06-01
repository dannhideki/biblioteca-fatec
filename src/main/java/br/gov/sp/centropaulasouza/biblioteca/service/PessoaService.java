package br.gov.sp.centropaulasouza.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.centropaulasouza.biblioteca.dao.PessoaDaoImpl;
import br.gov.sp.centropaulasouza.biblioteca.model.Pessoa;
import br.gov.sp.centropaulasouza.biblioteca.model.Usuario;

/**
 *
 * @author hideki
 */
@Component
@Transactional(readOnly=true)
public class PessoaService {

	@Autowired
	private PessoaDaoImpl pessoaDao;

	@Transactional(readOnly=false)
	public void saveOrUpdate(Pessoa pessoa) {
		if(pessoa.getId() == null){
			pessoaDao.save(pessoa);
		}else{
			pessoaDao.update(pessoa);
		}
	}

	public boolean validateEmail(String email){
		return pessoaDao.existsEmail(email);
	}

	public Pessoa getPessoa(Long id){
		return pessoaDao.getPessoa(id);
	}

	public List<Pessoa> findByRaWithLike(String ra){
		return pessoaDao.findByRaWithLike(ra);
	}

	public Pessoa findPessoaByRa(Long ra){
		return pessoaDao.findPessoaByRa(ra);
	}

	public Pessoa findPessoaByUser(Usuario user) {
		return pessoaDao.findPessoaByUser(user);
	}

	public Pessoa findPessoaByEmail(String email) {
		return pessoaDao.findPessoaByEmail(email);
	}
}

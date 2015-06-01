package br.gov.sp.centropaulasouza.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.gov.sp.centropaulasouza.biblioteca.model.Pessoa;
import br.gov.sp.centropaulasouza.biblioteca.model.Usuario;


/**
 *
 * @author hideki
 */
@Repository
public class PessoaDaoImpl implements PessoaDao{

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Pessoa pessoa) {
		em.persist(pessoa);
	}

	@Override
	public Pessoa getPessoa(Long id) {
		return em.find(Pessoa.class, id);
	}

	@Override
	public void remove(Pessoa pessoa) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void update(Pessoa pessoa) {
		em.merge(pessoa);
	}

	public boolean existsEmail(String email) {
		try{
			Pessoa pessoa = em.createQuery("SELECT p FROM Pessoa p WHERE p.email = :email",Pessoa.class)
					.setParameter("email", email).getSingleResult();
			return pessoa != null;
		}catch(NoResultException ne){
			return false;
		}
	}

	public List<Pessoa> findByRaWithLike(String ra){
		List<Pessoa> list = em.createQuery("SELECT p from Pessoa p WHERE str(p.ra) LIKE :ra",Pessoa.class)
				.setParameter("ra", ra +"%")
				.getResultList();
		return list;
	}

	public Pessoa findPessoaByRa(Long ra) {
		return em.createQuery("SELECT p FROM Pessoa p WHERE p.ra = :ra",Pessoa.class)
				.setParameter("ra", ra)
				.getSingleResult();
	}

	public Pessoa findPessoaByUser(Usuario user) {
		Pessoa pessoa = new Pessoa();
		try{
			pessoa = em.createQuery("SELECT p FROM Pessoa p WHERE p.user = :user",Pessoa.class)
					.setParameter("user", user)
					.getSingleResult();
		}catch (NoResultException e){
			e.printStackTrace();
		}
		return pessoa;
	}

	public Pessoa findPessoaByEmail(String email) {
		Pessoa pessoa = new Pessoa();
		try{
			pessoa = em.createQuery("SELECT p FROM Pessoa p WHERE p.email = :email",Pessoa.class)
					.setParameter("email", email)
					.getSingleResult();
		}catch (NoResultException e){
			e.printStackTrace();
		}
		return pessoa;
	} 

}

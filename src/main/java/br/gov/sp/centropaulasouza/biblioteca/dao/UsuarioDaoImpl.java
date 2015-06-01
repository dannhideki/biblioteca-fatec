package br.gov.sp.centropaulasouza.biblioteca.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.gov.sp.centropaulasouza.biblioteca.model.Usuario;

/**
 *
 * @author Daniel Hideki
 */
@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	public Usuario existsValidation(String validation) {
		try{
			Usuario user = em.createQuery("SELECT u FROM Usuario u WHERE u.validation = :validation",Usuario.class)
					.setParameter("validation", validation).getSingleResult();
			if (user != null) {
				user.setEnable(true);
				user.setValidation("");
				save(user);
			}
			return user;
		}catch(NoResultException ne){
			return null;
		}
	}

	@Override
	public void save(Usuario user) {
		if(user.getId() == null){
			em.persist(user);
		}else{
			em.merge(user);
		}
	}

	public Usuario getUsuarioById(Integer id) {
		return em.find(Usuario.class, id);
	}

	public Usuario getUsuarioByLogin(String login) {
		Usuario user = new Usuario();
		try{
			user = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login",Usuario.class)
					.setParameter("login", login).getSingleResult();
		}catch(NoResultException ne){
			ne.printStackTrace();
		}
		return user;
	}
}

package br.gov.sp.centropaulasouza.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.gov.sp.centropaulasouza.biblioteca.model.Acervo;

/**
 *
 * @author hideki
 */
@Repository
public class AcervoDaoImp implements AcervoDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Acervo acervo) {
		em.persist(acervo);
	}

	@Override
	public Acervo getAcervo(Integer id) {
		return em.find(Acervo.class, id);
	}

	@Override
	public List<Acervo> list() {
return em.createQuery("from Acervo", Acervo.class).getResultList();
	}

	@Override
	public void remove(Acervo acervo) {
		em.remove(acervo);
	}

	@Override
	public void update(Acervo acervo) {
		em.merge(acervo);
	}

	public List<Acervo> findByQuery(String query) {
		return em.createQuery("from Acervo a where a.descricao like :query",Acervo.class)
				.setParameter("query", "%"+query+"%")
				.getResultList();
	}
}

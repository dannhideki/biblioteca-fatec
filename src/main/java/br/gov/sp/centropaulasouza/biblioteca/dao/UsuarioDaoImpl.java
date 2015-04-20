package br.gov.sp.centropaulasouza.biblioteca.dao;

import br.gov.sp.centropaulasouza.biblioteca.model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniel Hideki
 */
@Repository
public class UsuarioDaoImpl implements UsuarioDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean existsValidation(String validation) {
        Session session = sessionFactory.openSession();

        Usuario user = (Usuario) session.createQuery("SELECT u FROM Usuario u WHERE u.validation = :validation")
                .setParameter("validation", validation).uniqueResult();

        if (user != null) {
            user.setEnable(true);
            user.setValidation("");
            save(user, session);
            return true;
        }
        return false;
    }

    @Override
    public void save(Usuario user, Session session) {
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
        tx.commit();
    }
}

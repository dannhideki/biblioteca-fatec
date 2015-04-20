package br.gov.sp.centropaulasouza.biblioteca.dao;

import br.gov.sp.centropaulasouza.biblioteca.model.Profile;
import br.gov.sp.centropaulasouza.biblioteca.model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author hideki
 */
@Repository
public class ProfileDaoImpl implements ProfileDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Profile profile) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(profile);
        tx.commit();  
    }

    @Override
    public Profile getProfile(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Profile profile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Profile profile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean existsEmail(String email) {
        Session session = sessionFactory.openSession();

        Profile profile = (Profile) session.createQuery("SELECT p FROM Profile p WHERE p.email = :email")
                .setParameter("email", email).uniqueResult();

        return profile != null;
    }

}

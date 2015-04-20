package br.gov.sp.centropaulasouza.biblioteca.dao;


import br.gov.sp.centropaulasouza.biblioteca.model.Livro;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author hideki
 */
@Service
public class LivroDaoImp implements LivroDao {

    @Override
    public void save(Livro livro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livro getLivro(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Livro> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Livro livro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Livro livro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public void save(Livro livro) {
//        //Session session = HibernateUtil_old.getSessionFactory().openSession();
//        Transaction t = session.beginTransaction();
//        session.save(livro);
//        t.commit();
//    }
//    public Livro getLivro(long id) {
//        Session session = HibernateUtil_old.getSessionFactory().openSession();
//        return (Livro) session.load(Livro.class, id);
//    }
//    public List<Livro> list() {
//        //Session session = HibernateUtil_old.getSessionFactory().openSession();
//        Transaction t = session.beginTransaction();
//        List lista = session.createQuery("from Livro").list();
//        t.commit();
//        return lista;
//    }
//    public void remove(Livro livro) {
//        Session session = HibernateUtil_old.getSessionFactory().openSession();
//        Transaction t = session.beginTransaction();
//        session.delete(livro);
//        t.commit();
//    }
//    public void update(Livro livro) {
//        Session session = HibernateUtil_old.getSessionFactory().openSession();
//        Transaction t = session.beginTransaction();
//        session.update(livro);
//        t.commit();
//    }
}

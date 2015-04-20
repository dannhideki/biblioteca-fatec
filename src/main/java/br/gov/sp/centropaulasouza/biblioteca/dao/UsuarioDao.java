package br.gov.sp.centropaulasouza.biblioteca.dao;

import br.gov.sp.centropaulasouza.biblioteca.model.Usuario;
import org.hibernate.Session;

/**
 *
 * @author Daniel Hideki
 */
public interface UsuarioDao {

    public boolean existsValidation(String validation);

    public void save(Usuario user, Session session);
}

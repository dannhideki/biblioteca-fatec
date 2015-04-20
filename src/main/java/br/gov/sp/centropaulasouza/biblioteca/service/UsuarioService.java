package br.gov.sp.centropaulasouza.biblioteca.service;

import br.gov.sp.centropaulasouza.biblioteca.dao.UsuarioDao;
import br.gov.sp.centropaulasouza.biblioteca.dao.UsuarioDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Daniel Hideki
 */
@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    private UsuarioDaoImpl userDao;

    @Transactional
    public boolean existsValidation(String validation) {
        return userDao.existsValidation(validation);
    }
}

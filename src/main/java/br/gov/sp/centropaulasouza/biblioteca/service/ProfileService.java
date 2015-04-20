package br.gov.sp.centropaulasouza.biblioteca.service;

import br.gov.sp.centropaulasouza.biblioteca.dao.ProfileDaoImpl;
import br.gov.sp.centropaulasouza.biblioteca.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hideki
 */
@Service
public class ProfileService {

    @Autowired
    private ProfileDaoImpl profileDao;

    public void save(Profile profile) {
        profileDao.save(profile);
    }
    
    public boolean validateEmail(String email){
       return profileDao.existsEmail(email);
    }
}

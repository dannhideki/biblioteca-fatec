package br.gov.sp.centropaulasouza.biblioteca.service;

import br.gov.sp.centropaulasouza.biblioteca.dao.AcervoDaoImp;
import br.gov.sp.centropaulasouza.biblioteca.model.Acervo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hideki
 */
@Service
@Transactional(readOnly=false)
public class AcervoService {
    
    @Autowired
    private AcervoDaoImp acervoDao;
    
    public List<Acervo> getList(){
        return acervoDao.list();
    }
    
    public Acervo getAcervoByCodigo(Integer id){
    	return acervoDao.getAcervo(id);
    }
    
    public List<Acervo> findByQuery(String query){
    	return acervoDao.findByQuery(query);
    }

}

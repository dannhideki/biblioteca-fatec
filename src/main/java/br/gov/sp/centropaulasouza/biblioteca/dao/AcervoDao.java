package br.gov.sp.centropaulasouza.biblioteca.dao;


import br.gov.sp.centropaulasouza.biblioteca.model.Acervo;
import java.util.List;

/**
 *
 * @author hideki
 */
public interface AcervoDao {

    public void save(Acervo acervo);
    public Acervo getAcervo(Integer id);
    public List<Acervo> list();
    public void remove(Acervo acervo);
    public void update(Acervo acervo);

}

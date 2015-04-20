package br.gov.sp.centropaulasouza.biblioteca.dao;


import br.gov.sp.centropaulasouza.biblioteca.model.Livro;
import java.util.List;

/**
 *
 * @author hideki
 */
public interface LivroDao {

    public void save(Livro livro);
    public Livro getLivro(long id);
    public List<Livro> list();
    public void remove(Livro livro);
    public void update(Livro livro);

}

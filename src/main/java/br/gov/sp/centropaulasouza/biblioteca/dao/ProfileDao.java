package br.gov.sp.centropaulasouza.biblioteca.dao;

import br.gov.sp.centropaulasouza.biblioteca.model.Profile;



/**
 *
 * @author hideki
 */
public interface ProfileDao {

    public void save(Profile profile);

    public Profile getProfile(int id);

    public void remove(Profile profile);

    public void update(Profile profile);
}

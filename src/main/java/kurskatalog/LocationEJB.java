/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ben Yuly
 */

@Stateless
public class LocationEJB {
    
    @PersistenceContext(unitName = "KurskatalogPU")
    private EntityManager em;

    
    public void persist( Location loc )
    {
	em.persist( loc );
    }

    public void merge( Location loc )
    {
        em.merge( loc );
    }

    public void remove( Location loc )
    {
        em.remove( em.merge( loc ) );
    }
    
    public List<Location> getAllLocations()
    {
        return em.createQuery( "SELECT l FROM Location l", Location.class ).getResultList();
    }

}

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
public class OfferingEJB {
    
    @PersistenceContext(unitName = "KurskatalogPU")
    private EntityManager em;
    
    public void persistOffering( Offering offer )
    {
	em.persist( offer );
    }

    public void updateOffering( Offering offer )
    {
        em.merge( offer );
    }

    public void deleteOffering( Offering offer )
    {
        em.remove( em.merge( offer ) );
    }
    
    
    
    public List<Offering> listOfferings()
    {
        return em.createQuery( "SELECT o FROM Offering o", Offering.class ).getResultList();
    }

    public List<Location> listLocations()
    {
        return em.createQuery( "SELECT l FROM Location l", Location.class ).getResultList();
    }
}

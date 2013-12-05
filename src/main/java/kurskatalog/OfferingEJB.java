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
    
    public void persistOffering( OfferingMetadata offer )
    {
	em.persist( offer );
    }

    public void updateOffering( OfferingMetadata offer )
    {
        em.merge( offer );
    }

    public void deleteOffering( OfferingMetadata offer )
    {
        em.remove( em.merge( offer ) );
    }
    
    public List<OfferingMetadata> listOfferings()
    {
        return em.createQuery( "SELECT s FROM OfferingMetadata s", OfferingMetadata.class ).getResultList();
    }
}

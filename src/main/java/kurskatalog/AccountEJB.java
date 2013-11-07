package kurskatalog;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AccountEJB
{
    @PersistenceContext(unitName = "KurskatalogDB")
    private EntityManager em;

    public void createAccount( Account account )
    {
	em.persist( account );
    }
}

package kurskatalog;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import java.util.List;

@Stateless
public class AccountEJB
{
    @PersistenceContext(unitName = "KurskatalogPU")
    private EntityManager em;

    public Account register( Account account )
    {
	em.persist( account );
	return account;
    }

    public Account login( Account account )
    {
	try
	{
            account = em.createQuery( "SELECT a FROM Account a WHERE a.username = :user AND a.password = :pass", Account.class )
                        .setParameter( "user", account.getUsername() )
	                .setParameter( "pass", account.getHashedPassword() )
	                .getSingleResult();
	}
	catch ( NoResultException nr )
	{
	    account = null;
	}

	return account;
    }

    public void persistStudent( Student stud )
    {
    }

    public void deleteStudent( Student stud )
    {
    }
 
    public List<Student> getAllStudents()
    {
        return null;
    }
}

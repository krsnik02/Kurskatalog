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

    public Account login( Credentials cred )
    {
	Account account;
	try
	{
            account = em.createQuery( "SELECT a FROM Account a WHERE a.credentials = :cred", Account.class )
                        .setParameter( "cred", cred ).getSingleResult();
	}
	catch ( NoResultException nr )
	{
	    account = null;
	}

	return account;
    }

    public void persistAccount( Account acct )
    {
	em.persist( acct );
    }

    public void mergeAccount( Account acct )
    {
        em.merge( acct );
    }

    public void deleteAccount( Account acct )
    {
        em.remove( em.merge( acct ) );
    }

 
    public List<Student> listStudents()
    {
        return em.createQuery( "SELECT s FROM Student s", Student.class ).getResultList();
    }

    public List<Professor> listProfessors()
    {
        return em.createQuery( "SELECT p FROM Professor p", Professor.class ).getResultList();
    }

    public List<Administrator> listAdministrators()
    {
        return em.createQuery( "SELECT a FROM Administrator a", Administrator.class ).getResultList();
    }
}

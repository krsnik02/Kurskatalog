package kurskatalog;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class PersistenceEJB
{
    @PersistenceContext(unitName = "KurskatalogPU")
    private EntityManager em;

    public void persist( Object o )
    {
        em.persist( o );
    }

    public void update( Object o )
    {
        em.merge( o );
    }

    public void delete( Object o )
    {
        em.remove( em.merge( o ) );
    }



    public Account getAccountForCredentials( Credentials cred )
    {
        Account account;
        try
        {
            account = em.createQuery( "SELECT a FROM Account a WHERE a.credentials = :cred", Account.class ).setParameter( "cred", cred ).getSingleResult();
        }
        catch ( NoResultException nr )
        {
            account = null;
        }

        return account;
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

    public List<Course> listCourses( CourseSearchQuery searchQuery )
    {
	CriteriaBuilder builder = em.getCriteriaBuilder();
	CriteriaQuery<Course> crit = builder.createQuery( Course.class );

	Root<Course> c = crit.from( Course.class );
	crit = crit.select( c );

	if ( searchQuery.getDepartmentCode() != null && searchQuery.getDepartmentCode() != "" )
		crit = crit.where( builder.equal( c.get("department").get("code").as( String.class ), 
						  searchQuery.getDepartmentCode() ) );

	if ( searchQuery.getCourseCode() != null && searchQuery.getCourseCode() != "" )
		crit = crit.where( builder.equal( c.get("code").as( String.class ), 
						  searchQuery.getCourseCode() ) );

	if ( searchQuery.getName() != null && searchQuery.getName() != "" )
		crit = crit.where( builder.equal( c.get("name").as( String.class ),
						  searchQuery.getName() ) );

        return em.createQuery( crit ).getResultList();
    }

    public List<Department> listDepartments()
    {
        return em.createQuery( "SELECT d FROM Department d", Department.class ).getResultList();
    }
    
    public List<Department> listHead(Professor prof)
    {
	TypedQuery<Department> query = em.createQuery( "SELECT d FROM Department d where d.head = ?1", Department.class );
	query.setParameter(1, prof.getId());
	return query.getResultList();
    }

    public List<Offering> listOfferings()
    {
        return em.createQuery( "SELECT o FROM Offering o", Offering.class ).getResultList();
    }
}

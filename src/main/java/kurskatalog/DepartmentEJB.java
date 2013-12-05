package kurskatalog;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DepartmentEJB
{
    @PersistenceContext(unitName = "KurskatalogPU")
    private EntityManager em;

    public void persistDepartment( Department dept )
    {
        em.persist( dept );
    }

    public void updateDepartment( Department dept )
    {
        em.merge( dept );
    }

    public void deleteDepartment( Department dept )
    {
        em.remove( em.merge( dept ) );
    }

 
    public List<Department> listDepartments()
    {
        return em.createQuery( "SELECT d FROM Department d", Department.class ).getResultList();
    }
}

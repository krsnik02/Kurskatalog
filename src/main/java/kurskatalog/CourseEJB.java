package kurskatalog;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CourseEJB
{
    @PersistenceContext(unitName = "KurskatalogPU")
    private EntityManager em;

    public void persistCourse( Course c )
    {
        em.persist( c );
    }

    public void updateCourse( Course c )
    {
        em.merge( c );
    }

    public void deleteCourse( Course c )
    {
        em.remove( em.merge( c ) );
    }

    
    public List<Course> listCourses()
    {
        return em.createQuery( "SELECT c FROM Course c", Course.class ).getResultList();
    }
}

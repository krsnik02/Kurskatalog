package kurskatalog;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

@ManagedBean
public class CourseController
{
    @EJB
    private PersistenceEJB ejb;

    private Course course = new Course();
    private List<String> prerequisiteIds = new ArrayList<String>();
    private List<String> corequisiteIds = new ArrayList<String>();

    public Course getCourse() { return course; }
    public void setCourse( Course c ) { course = c; }

    public List<String> getPrerequisiteIds() { return prerequisiteIds; }
    public void setPrerequisiteIds( List<String> ids ) { prerequisiteIds = ids; }

    public List<String> getCorequisiteIds() { return corequisiteIds; }
    public void setCorequisiteIds( List<String> ids ) { corequisiteIds = ids; }


    public List<Course> listCourses() { return ejb.listCourses(); }

    public CourseType[] getCourseTypes() 
    {
        CourseType[] types = { CourseType.LEC, CourseType.LAB, CourseType.SEM, CourseType.STU };
        return types;
    }


    public String persistCourse()
    {
	Set<Prerequisite> prereqs = new HashSet<Prerequisite>();
	for ( String id : prerequisiteIds )
	{
		Prerequisite prereq = new Prerequisite();
		prereq.getCourse().setId( Long.parseLong( id ) );
		prereqs.add( prereq );
	}
	for ( String id : corequisiteIds )
	{
		Prerequisite coreq = new Prerequisite();
		coreq.getCourse().setId( Long.parseLong( id ) );
		coreq.setCorequisite( true );
		prereqs.add( coreq );
	}
        course.setPrerequisites( prereqs );

        ejb.persist( course );
	course = new Course();
	return "list-courses.xhtml";
    }


    public String modifyCourse( Course c )
    {
        course = c;
	return "modify-course.xhtml";
    }

    public String updateCourse()
    {
        ejb.update( course );
        course = new Course();
        return "list-courses.xhtml";
    }

    
    public String deleteCourse( Course c )
    {
        ejb.delete( c );
        return "list-courses.xhtml";
    }
}

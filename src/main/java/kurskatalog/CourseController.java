package kurskatalog;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

@ManagedBean
public class CourseController
{
    @EJB
    private PersistenceEJB ejb;

    private Course course = new Course();
    private List<String> prerequisiteIds = new ArrayList<String>();
    private List<String> corequisiteIds = new ArrayList<String>();
    private CourseSearchQuery searchQuery = new CourseSearchQuery();

    public Course getCourse() { return course; }
    public void setCourse( Course c ) { course = c; }

    public List<String> getPrerequisiteIds() { return prerequisiteIds; }
    public void setPrerequisiteIds( List<String> ids ) { prerequisiteIds = ids; }

    public List<String> getCorequisiteIds() { return corequisiteIds; }
    public void setCorequisiteIds( List<String> ids ) { corequisiteIds = ids; }

    public CourseSearchQuery getSearchQuery() { return searchQuery; }
    public void setSearchQuery( CourseSearchQuery query ) { searchQuery = query; }



    private List<Course> courseList;

    public List<Course> getCourseList() { return courseList; }
    public void setCourseList( List<Course> courses ) { courseList = courses; }


    @PostConstruct
    public void initialize()
    {
        courseList = ejb.listCourses( new CourseSearchQuery() );
    }



    public CourseType[] getCourseTypes() 
    {
        CourseType[] types = { CourseType.LEC, CourseType.LAB, CourseType.SEM, CourseType.STU };
        return types;
    }


    public String search()
    {
        courseList = ejb.listCourses( searchQuery );
        return "list-courses.xhtml";
    }


    public String persistCourse()
    {
	List<Prerequisite> prereqs = new ArrayList<Prerequisite>();
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
        courseList = ejb.listCourses( searchQuery );

	return "list-courses.xhtml";
    }


    public String modifyCourse( Course c )
    {
        course = c;
	prerequisiteIds = new ArrayList<String>();
	corequisiteIds = new ArrayList<String>();
	for ( Prerequisite preq : course.getPrerequisites() )
        {
            if ( preq.isCorequisite() )
	    {
	        prerequisiteIds.add( Long.toString( preq.getId() ) );
	    }
            else
            {
                corequisiteIds.add( Long.toString( preq.getId() ) );
            }
        }
	return "modify-course.xhtml";
    }

    public String updateCourse()
    {
	List<Prerequisite> prereqs = new ArrayList<Prerequisite>();
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

        ejb.update( course );
        course = new Course();
        courseList = ejb.listCourses( searchQuery );    

        return "list-courses.xhtml";
    }

    
    public String deleteCourse( Course c )
    {
        ejb.delete( c );
        course = new Course();
        courseList = ejb.listCourses( searchQuery );

        return "list-courses.xhtml";
    }
}

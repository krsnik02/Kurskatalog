package kurskatalog;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class CourseController
{
    @EJB
    private CourseEJB courseEJB;

    private Course course = new Course();

    public Course getCourse() { return course; }
    public void setCourse( Course c ) { course = c; }

    public List<Course> listCourses() { return courseEJB.listCourses(); }

    public CourseType[] getCourseTypes() 
    {
        CourseType[] types = { CourseType.LEC, CourseType.LAB, CourseType.SEM, CourseType.STU };
        return types;
    }


    public String persistCourse()
    {
        courseEJB.persistCourse( course );
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
        courseEJB.updateCourse( course );
        course = new Course();
        return "list-courses.xhtml";
    }

    
    public String deleteCourse( Course c )
    {
        courseEJB.deleteCourse( c );
        return "list-courses.xhtml";
    }
}

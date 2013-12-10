package kurskatalog;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;

@Entity
public class Student extends Account
{
    @ManyToMany(cascade=CascadeType.ALL)
    private List<Offering> registeredCourses;
    
    public Student() 
    {
        registeredCourses = new ArrayList<Offering>();
    }
    
    public List<Offering> listCourses()
    {
	return registeredCourses;
    }
    
    public void setCourses( List<Offering> registeredCourses_ )
    {
	registeredCourses = registeredCourses_;
    }
};

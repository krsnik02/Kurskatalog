package kurskatalog;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
public class Student extends Account
{
    @OneToMany(cascade=CascadeType.ALL)
    private List<Offering> registeredCourses;
    
    public Student() 
    {
        registeredCourses = new ArrayList<Offering>();
    }
    
    public List<Offering> getRegisteredCourses()
    {
	return registeredCourses;
    }
    
    public void setRegisteredCourses( List<Offering> registeredCourses_ )
    {
	registeredCourses = registeredCourses_;
    }
};

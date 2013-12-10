package kurskatalog;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class Student extends Account
{
    private List<Offering> registeredCourses;
    
    public Student() {}
    
    public List<Offering> getRegisteredCourses(){
	return registeredCourses;
    }
    
    public void setRegisteredCourses(List<Offering> registeredCourses_){
	registeredCourses = registeredCourses_;
    }
};

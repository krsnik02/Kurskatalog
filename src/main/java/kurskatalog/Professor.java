package kurskatalog;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Professor extends Account
{
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<Offering> courseLoad;
    
    @OneToOne
    private Department headOf;
    
    public Professor() {}
    
    public List<Offering> listCourses()
    {
	return courseLoad;
    }
    
    public Department getHeadOf(){
	return headOf;
    }
    
    public void setHeadOf(Department dept){
	headOf = dept;
    }
};

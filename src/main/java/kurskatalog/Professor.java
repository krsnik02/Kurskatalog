package kurskatalog;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;

@Entity
public class Professor extends Account
{
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<Offering> courseLoad;
    
    @OneToMany(mappedBy="head", fetch=FetchType.EAGER)
    private List<Department> headOf;
    
    public Professor() {}
    
    public List<Offering> listCourses()
    {
	return courseLoad;
    }
    
    public List<Department> getHeadOf(){
	return headOf;
    }
    
    public void setHeadOf(List<Department> dept){
	headOf = dept;
    }
};

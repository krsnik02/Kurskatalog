/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kurskatalog;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

/**
 *
 * @author Ben Yuly
 */

@Entity
public class Course 
{
    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    
    @Column(length = 4096)
    private String description;
    
    @ManyToOne
    Department department;
    
    @OneToMany(cascade=CascadeType.PERSIST)
    private Set<Prerequisite> prerequisites;
    
    private int code;
    private CourseType type;
    
    public Course() 
    {
        department = new Department();
	prerequisites = new HashSet<Prerequisite>();
    }
    
    public long getId(){ return id; }
    public void setId( long id_ ) { id = id_; }
    
    public String getName() { return name; }
    public void setName( String name_){ name = name_; }
    
    public String getDescription(){ return description; }
    public void setDescription( String description_ ){ description = description_; }
    
    public Department getDepartment (){ return department; }
    public void setDepartment( Department department_ ){ department = department_; } 
    
    public int getCode(){ return code; }
    public void setCode( int code_ ){ code = code_; }
    
    public CourseType getType(){ return type; }
    public void setType( CourseType type_ ){ type = type_; }

    public Set<Prerequisite> getPrerequisites() { return prerequisites; }
    public void setPrerequisites( Set<Prerequisite> prereqs ) { prerequisites = prereqs; }
}
